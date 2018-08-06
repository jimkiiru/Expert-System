package com.expertsystem.controller;

import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.dao.*;
import com.expertsystem.model.*;

@Controller
public class PhotoController {

	private ImageIcon format = null;
	@Autowired
	private PhotoDAO photoDAO;

	@Autowired
	private PhotoValidator validator;

	@Autowired
	SessionFactory factory;
	
	@Autowired
	private JavaMailSender mailSender;

	int yr, mon, day;
	String currdate = "";
	private String filePath;
	private String url;
	private String saveDirectory = "C:\\Users\\james kiiru\\mars_workspace\\ExpertSystem\\webapps\\img\\";

	@RequestMapping("/viewAllPhotos")
	public ModelAndView getAllPhotos(@Valid PhotoModel photo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("showPhotos");
		List<PhotoModel> photoList = photoDAO.getAllPhotos();
		mav.addObject("photoList", photoList);
		return mav;
	}

	@RequestMapping(value = "/savePhoto", method = RequestMethod.GET)
	public ModelAndView newPhoto(HttpSession session) {
		ModelAndView mav = new ModelAndView("newPhoto");
		
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
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		PhotoModel category = new PhotoModel();
		mav.getModelMap().put("newPhoto", category);
		return mav;
	}

	@RequestMapping(value = "/savePhoto", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("newPhoto") PhotoModel photo, BindingResult result,
			@RequestParam CommonsMultipartFile[] fileUpload, SessionStatus status,HttpSession session)
			throws IllegalStateException, IOException {

		/*validator.validate(photo, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("newPhoto");
			return mav;
		}*/
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				photo.setPhotoname("img/" + aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}
		Calendar cal = new GregorianCalendar();
		yr = cal.get(Calendar.YEAR);
		mon = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		currdate = yr + "-" + mon + "-" + day;
		photo.setDate(currdate);
		
		String logid=""+session.getAttribute("logid");
		int lid=Integer.parseInt(logid);
		photo.setLogid(lid);
		
		photoDAO.save(photo);
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo("kiiru.kurj@gmail.com");
		email.setSubject("CropDiagnosis: Uploaded photos");
		email.setText("A photo of an infected crop has been uploaded");
		mailSender.send(email);
		
		ModelAndView mav = new ModelAndView("newPhoto");
		mav.addObject("successMess", "Your photo has been sent");
		status.setComplete();
		return mav;
	}

	@RequestMapping("deletePhoto")
	public ModelAndView delete(@RequestParam("photoId") Integer photoId) {
		ModelAndView mav = new ModelAndView("redirect:expertDash");
		photoDAO.delete(photoId);
		return mav;
	}
}
