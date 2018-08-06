package com.expertsystem.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.expertsystem.dao.FarmerDAO;
import com.expertsystem.model.ExpertModel;
import com.expertsystem.model.FarmerModel;
import com.expertsystem.model.FarmerProfilePic;
import com.expertsystem.model.LoginModel;
import com.expertsystem.model.ProfilePicModel;

@Controller
public class FarmerController {

	String token = "";
	@Autowired
	private FarmerDAO farmerDAO;

	@Autowired
	private FarmerFormValidator validator;

	@Autowired
	SessionFactory factory;
	
	private String saveDirectory = "C:\\Users\\james kiiru\\mars_workspace\\ExpertSystem\\webapps\\img\\";

	
	@RequestMapping(value = "/viewExpertsF", method = RequestMethod.GET)
	public ModelAndView shoExp() {
		ModelAndView model = new ModelAndView("showExpertsFarmer");
		return model;
	}
	
	@RequestMapping(value = "/farmersdashboard", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("farmersDashboard");

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

		Query qry = sess.createQuery("from PhotoModel m where m.logid=:lid");
		qry.setInteger("lid", lid);
		List list = qry.list();
		request.setAttribute("list", list);
		mav.addObject("farmerId", farmerId);

		return mav;
	}

	@RequestMapping(value = "/farmersProfile", method = RequestMethod.GET)
	public ModelAndView Profile(@RequestParam("farmerId") Integer farmerId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("farmerProfile");

		Session sess = factory.openSession();
		Query query = sess.createQuery("from FarmerModel p where p.farmerId=:id");
		query.setInteger("id", farmerId);
		List l = query.list();
		request.setAttribute("list", l);

		return mav;
	}

	@RequestMapping("/viewAllFarmers")
	public ModelAndView getAllFarmers() {
		ModelAndView mav = new ModelAndView("showFarmers");
		List<FarmerModel> farmer = farmerDAO.getAllFarmers();
		mav.addObject("farmer", farmer);
		return mav;
	}

	@RequestMapping(value = "/saveFarmer", method = RequestMethod.GET)
	public ModelAndView newFarmer() {
		ModelAndView mav = new ModelAndView("newFarmer");
		FarmerModel category = new FarmerModel();
		mav.getModelMap().put("newFarmer", category);
		return mav;
	}

	@RequestMapping(value = "/saveFarmer", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("newFarmer") FarmerModel farmer, LoginModel lm,
			BindingResult result, SessionStatus status) {

		/*
		 * validator.validate(farmer, result); if (result.hasErrors()) {
		 * ModelAndView mav = new ModelAndView("newFarmer"); return mav; }
		 */
		ModelAndView mav = new ModelAndView("newFarmer");

		Session sess = factory.openSession();
		Query qryE = sess.createQuery("from FarmerModel c where c.emailaddress=:email");
		qryE.setString("email", farmer.getEmailaddress());
		List lE = qryE.list();
		Iterator itE = lE.iterator();
		while (itE.hasNext()) {
			mav.addObject("successMess", "A User with that Email Already exist");
			return mav;
		}
		Query qryP = sess.createQuery("from FarmerModel c where c.phonenum=:pn");
		qryP.setString("pn", farmer.getPhonenum());
		List lP = qryP.list();
		Iterator itP = lP.iterator();
		while (itP.hasNext()) {
			mav.addObject("successMess", "A User with that Phone number Already exist");
			return mav;
		}
		Query qryN = sess.createQuery("from FarmerModel c where c.nationalId=:nID");
		qryN.setString("nID", farmer.getNationalId());
		List lN = qryN.list();
		Iterator itN = lN.iterator();
		while (itN.hasNext()) {
			mav.addObject("successMess", "A User with that National ID Already exist");
			return mav;
		}

		farmer.setStatus("farmer");
		farmer.setProfilePic("img/user.png");
		int i = farmerDAO.save(farmer);

		if (i > 0) {
			String username = "", pass = "", state = "";
			// SessionFactory factory = new
			// AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			t.begin();
			Query query = session.createQuery("from FarmerModel p where p.phonenum=:phone");
			query.setString("phone", farmer.getPhonenum());
			List list = query.list();
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Object o = (Object) itr.next();
				FarmerModel f = (FarmerModel) o;

				username = f.getPhonenum();
				pass = f.getPassword();
				state = f.getStatus();

			}
			lm.setUsername(username);
			lm.setPassword(pass);
			lm.setStatus(state);

			session.save(lm);
			t.commit();
			session.close();
		}
		mav.addObject("successMess", "Record Sent");
		return mav;
	}

	@RequestMapping(value = "/updateFarmer", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("farmerId") Integer farmerId) {
		ModelAndView mav = new ModelAndView("editFarmer");
		FarmerModel category = farmerDAO.getById(farmerId);
		mav.addObject("editFarmer", category);
		return mav;
	}

	@RequestMapping(value = "/updateFarmer", method = RequestMethod.POST)
	public String update(@ModelAttribute("editFarmer") FarmerModel farmer, BindingResult result, SessionStatus status) {
		validator.validate(farmer, result);
		if (result.hasErrors()) {
			return "editCategory";
		}
		farmerDAO.update(farmer);
		status.setComplete();
		return "editFarmer";
	}

	@RequestMapping("deleteFarmer")
	public ModelAndView delete(@RequestParam("farmerId") Integer farmerId) {
		ModelAndView mav = new ModelAndView("redirect:viewAllFarmers.do");
		farmerDAO.delete(farmerId);
		return mav;
	}

	@RequestMapping(value = "/updateFarProfilePic", method = RequestMethod.GET)
	public ModelAndView profilePic() {
		ModelAndView mav = new ModelAndView("updateFarmerProfilePic");
		FarmerProfilePic category = new FarmerProfilePic();
		mav.getModelMap().put("updateFarmerProfilePic", category);
		return mav;
	}

	@RequestMapping(value = "/updateFarProfilePic", method = RequestMethod.POST)
	public String profilePic2(@ModelAttribute("updateFarmerProfilePic") FarmerProfilePic profile, BindingResult result,
			@RequestParam CommonsMultipartFile[] fileUpload, SessionStatus status, HttpSession session)
			throws IllegalStateException, IOException {

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

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				profile.setProfilePic("img/" + aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}

		Transaction tx = sess.beginTransaction();
		String hqlUpdate = "update FarmerModel l set l.profilePic=:pic where l.phonenum=:pnum";
		int updateEntities = sess.createQuery(hqlUpdate).setString("pic", profile.getProfilePic())
				.setString("pnum", username).executeUpdate();
		tx.commit();
		sess.close();

		return "redirect:farmersProfile?farmerId=" + farmerId;
	}

}
