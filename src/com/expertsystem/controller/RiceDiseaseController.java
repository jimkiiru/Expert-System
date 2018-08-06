package com.expertsystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.dao.RiceDiseaseDAO;
import com.expertsystem.model.ExpertModel;
import com.expertsystem.model.LoginModel;
import com.expertsystem.model.RiceDiseaseModel;

@Controller
public class RiceDiseaseController {
	
	private String filePath;
	private String url;
	private String saveDirectory = "C:\\Users\\james kiiru\\mars_workspace\\ExpertSystem\\webapps\\img\\";
	
	@Autowired
	private RiceDiseaseDAO riceDiseaseDAO;
	
	@Autowired
	SessionFactory factory;

	@RequestMapping("/viewAllRiceDiseases")
	public ModelAndView getAllDiseases(HttpSession session) {
		ModelAndView mav = new ModelAndView("showRiceDiseases");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int expertId = 0;
		Query qrey1 = sess.createQuery("from ExpertModel e where e.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			ExpertModel em = (ExpertModel) o;
			expertId = em.getExpertId();
		}
		mav.addObject("expertId", expertId);

		
		List<RiceDiseaseModel> riceDisease = riceDiseaseDAO.getAllDiseases();
		mav.addObject("riceDisease", riceDisease);
		return mav;
	}
	@RequestMapping(value = "/saveRiceDisease", method = RequestMethod.GET)
	public ModelAndView newRiceDisease(HttpSession session) {
		ModelAndView mav = new ModelAndView("newRiceDisease");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int expertId = 0;
		Query qrey1 = sess.createQuery("from ExpertModel e where e.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			ExpertModel em = (ExpertModel) o;
			expertId = em.getExpertId();
		}
		mav.addObject("expertId", expertId);

		
		RiceDiseaseModel riceDisease = new RiceDiseaseModel();
		mav.getModelMap().put("newRiceDisease", riceDisease);
		return mav;
	}
	
	@RequestMapping(value = "/saveRiceDisease", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("newRiceDisease") RiceDiseaseModel riceDisease,
			@RequestParam CommonsMultipartFile[] fileUpload, BindingResult result, SessionStatus status) throws IllegalStateException, IOException {
		
		/*validator.validate(farmer, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("newFarmer");
			return mav;
		}*/
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());
				riceDisease.setDiseasePhoto("img/"+aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}
		
		riceDiseaseDAO.save(riceDisease);
		ModelAndView mav = new ModelAndView("newRiceDisease");
		mav.addObject("successMess", "Record Saved");
		status.setComplete();
		return mav;
	}

	@RequestMapping(value = "/updateRiceDisease", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("diseaseId") Integer diseaseId,HttpSession session) {
		ModelAndView mav = new ModelAndView("editRiceDisease");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int expertId = 0;
		Query qrey1 = sess.createQuery("from ExpertModel e where e.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			ExpertModel em = (ExpertModel) o;
			expertId = em.getExpertId();
		}
		mav.addObject("expertId", expertId);

		
		RiceDiseaseModel category = riceDiseaseDAO.getById(diseaseId);
		mav.addObject("editRiceDisease", category);
		return mav;
	}

	@RequestMapping(value = "/updateRiceDisease", method = RequestMethod.POST)
	public String update(@ModelAttribute("editRiceDisease") RiceDiseaseModel riceDisease, 
			@RequestParam CommonsMultipartFile[] fileUpload, BindingResult result, SessionStatus status) throws IllegalStateException, IOException {
		/*validator.validate(farmer, result);
		if (result.hasErrors()) {
			return "editCategory";
		}*/
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());
				riceDisease.setDiseasePhoto("img/"+aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}
		
		riceDiseaseDAO.update(riceDisease);
		status.setComplete();
		return "redirect:viewAllRiceDiseases";
	}

	@RequestMapping("deleteRiceDisease")
	public ModelAndView delete(@RequestParam("diseaseId") Integer diseaseId) {
		ModelAndView mav = new ModelAndView("redirect:viewAllRiceDiseases");
		riceDiseaseDAO.delete(diseaseId);
		return mav;
	}
}
