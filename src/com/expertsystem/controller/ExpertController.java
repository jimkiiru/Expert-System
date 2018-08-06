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
//import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.dao.ExpertDAO;
import com.expertsystem.dao.PhotoDAO;
import com.expertsystem.model.*;

@Controller
public class ExpertController {

	String token = "";
	@Autowired
	private ExpertDAO expertDAO;

	@Autowired
	private PhotoDAO photoDAO;

	@Autowired
	private ExpertFormValidator validator;

	@Autowired
	SessionFactory factory;

	@Autowired
	private JavaMailSender mailSender;
	
	private String saveDirectory = "C:\\Users\\james kiiru\\mars_workspace\\ExpertSystem\\webapps\\img\\";

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView("logout");
		return model;
	}
	
	@RequestMapping(value = "/ind", method = RequestMethod.GET)
	public ModelAndView c1(HttpSession session) {
		ModelAndView model = new ModelAndView("indexC");	
		return model;
	}
	@RequestMapping(value = "/appli", method = RequestMethod.POST)
	public ModelAndView c2(HttpSession session) {
		ModelAndView model = new ModelAndView("application");	
		return model;
	}
	
	@RequestMapping(value = "/chatWin", method = RequestMethod.GET)
	public ModelAndView ChatWindow(HttpSession session) {
		ModelAndView model = new ModelAndView("application");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);
		
		model.addObject("logid", lid);
		
		return model;
	}
	
	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public ModelAndView chat(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView("application");

		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		model.addObject("logid", lid);

		return model;
	}

	@RequestMapping(value = "/exProfile", method = RequestMethod.GET)
	public ModelAndView Profile(@RequestParam("expertId") Integer expertId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("expertProfile");
		// ExpertModel expert = expertDAO.getById(expertId);
		// mav.addObject("expertProfile", expert);

		Session sess = factory.openSession();
		Query query = sess.createQuery("from ExpertModel p where p.expertId=:id");
		query.setInteger("id", expertId);
		List l = query.list();
		request.setAttribute("list", l);

		return mav;
	}

	@RequestMapping(value = "/expertDash", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView("expertDashboard");

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
		model.addObject("expertId", expertId);

		List<PhotoModel> photoList = photoDAO.getAllPhotos();
		model.addObject("photoList", photoList);
		return model;
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView chatboard() {
		ModelAndView model = new ModelAndView("ChatWindow");
		return model;
	}

	@RequestMapping("/viewAllExperts")
	public ModelAndView getAllExperts() {
		ModelAndView mav = new ModelAndView("showExperts");
		List<ExpertModel> expert = expertDAO.getAllExperts();
		mav.addObject("expert", expert);
		return mav;
	}

	@RequestMapping(value = "/saveExpert", method = RequestMethod.GET)
	public ModelAndView newExperts() {
		ModelAndView mav = new ModelAndView("newExpert");
		ExpertModel category = new ExpertModel();
		mav.getModelMap().put("newExpert", category);
		return mav;
	}

	@RequestMapping(value = "/saveExpert", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("newExpert") ExpertModel expert, LoginModel lm,
			BindingResult result, SessionStatus status) {

		validator.validate(expert, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("newExpert");
			return mav;
		}
		// SessionFactory factory = new
		// AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();

		String username = "", pass = "", state = "";

		Random rn = new Random();
		int range = 9999999 - 1000000 + 1;
		int randomNum = rn.nextInt(range) + 1000000; // For 7 digit number

		Random rc = new Random();
		char c = (char) (rc.nextInt(26) + 'A');

		Random df = new Random();
		char h = (char) (df.nextInt(26) + 'A');

		Random sm = new Random();
		char ss = (char) (df.nextInt(26) + 'a');

		System.out.println(c);
		ModelAndView mav = new ModelAndView("newExpert");

		token = h + "" + ss + "" + randomNum + "" + c;

		Session sess = factory.openSession();
		Query qryE = sess.createQuery("from ExpertModel c where c.emailaddress=:email");
		qryE.setString("email", expert.getEmailaddress());
		List lE = qryE.list();
		Iterator itE = lE.iterator();
		while (itE.hasNext()) {
			mav.addObject("successMess", "An Expert with that Email Already exist");
			return mav;
		}
		Query qryP = sess.createQuery("from ExpertModel c where c.phonenum=:pn");
		qryP.setString("pn", expert.getPhonenum());
		List lP = qryP.list();
		Iterator itP = lP.iterator();
		while (itP.hasNext()) {
			mav.addObject("successMess", "An Expert with that Phone number Already exist");
			return mav;
		}

		expert.setPassword(token);
		expert.setStatus("expert");
		expert.setProfilePic("img/user.png");
		int i = expertDAO.save(expert);
		if (i > 0) {
			Query query = session.createQuery("from ExpertModel p where p.phonenum=:phone");
			query.setString("phone", expert.getPhonenum());
			List list = query.list();
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Object o = (Object) itr.next();
				ExpertModel f = (ExpertModel) o;

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

			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(expert.getEmailaddress());
			email.setSubject("Login Credentials");
			email.setText("Your username is: " + username + "/n Password: " + pass);
			mailSender.send(email);
		}
		mav.addObject("successMess", "Record Sent");
		status.setComplete();
		return mav;
	}

	@RequestMapping(value = "/updateExpert", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("expertId") Integer expertId) {
		ModelAndView mav = new ModelAndView("editExpert");
		ExpertModel category = expertDAO.getById(expertId);
		mav.addObject("editExpert", category);
		return mav;
	}

	@RequestMapping(value = "/updateExpert", method = RequestMethod.POST)
	public String update(@ModelAttribute("editExpert") ExpertModel expert, BindingResult result, SessionStatus status) {
		validator.validate(expert, result);
		if (result.hasErrors()) {
			return "editCategory";
		}
		expertDAO.update(expert);
		status.setComplete();
		return "editExpertr";
	}

	@RequestMapping("deleteExpert")
	public ModelAndView delete(@RequestParam("expertId") Integer expertId) {
		ModelAndView mav = new ModelAndView("showExperts");
		expertDAO.delete(expertId);
		return mav;
	}

	@RequestMapping(value = "/updateProfilePic", method = RequestMethod.GET)
	public ModelAndView profilePic() {
		ModelAndView mav = new ModelAndView("updateProfilePic");
		ProfilePicModel category = new ProfilePicModel();
		mav.getModelMap().put("updateProfilePic", category);
		return mav;
	}

	@RequestMapping(value = "/updateProfilePic", method = RequestMethod.POST)
	public String profilePic2(@ModelAttribute("updateProfilePic") ProfilePicModel profile, BindingResult result,
			@RequestParam CommonsMultipartFile[] fileUpload, SessionStatus status, HttpSession session) throws IllegalStateException, IOException {

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

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				profile.setProfilePic("img/" + aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}
		
		Transaction tx=sess.beginTransaction();
		String hqlUpdate="update ExpertModel l set l.profilePic=:pic where l.phonenum=:pnum";
		int updateEntities=sess.createQuery(hqlUpdate)
				.setString("pic",profile.getProfilePic())
				.setString("pnum",username).executeUpdate();
			tx.commit();
			sess.close();

		return "redirect:exProfile?expertId="+expertId;
	}

}
