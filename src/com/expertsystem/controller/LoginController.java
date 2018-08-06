package com.expertsystem.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.dao.PhotoDAO;
import com.expertsystem.model.*;
import com.expertsystem.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private PhotoDAO photoDAO;
	
	@Autowired
	public LoginService loginService;

	@Autowired
	protected SessionFactory sessionFactory;
	String status = "";

	@RequestMapping(value = "/loginC", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("loginForm");
		LoginModel category = new LoginModel();
		mav.getModelMap().put("loginForm", category);
		return mav;
	}

	@RequestMapping(value = "/loginC", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid LoginForm loginForm, BindingResult result, Map model, HttpSession session,
			HttpServletRequest request) {
		
		Session sess = sessionFactory.openSession();
		int logid = 0;		
		Query qry = sess.createQuery("from LoginModel p where p.username=:user");
		qry.setString("user", loginForm.getUsername());
		List l = qry.list();

		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel p = (LoginModel) o;
			logid = p.getLogid();
		} 
		session.setAttribute("logid", logid); 
		
		String userExists = loginService.checkLogin(loginForm.getUsername(), loginForm.getPassword());
		if (userExists.equals("1")) {
			ModelAndView mav = new ModelAndView("expertDashboard");
			
			String logidE = "" + session.getAttribute("logid");
			int lid = Integer.parseInt(logidE);

			String username = "";
			Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
			qrey.setInteger("lid", lid);
			List lE = qrey.list();
			Iterator itE = lE.iterator();
			while (itE.hasNext()) {
				Object o = (Object) itE.next();
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
			
			List<PhotoModel> photoList = photoDAO.getAllPhotos();
			mav.addObject("photoList", photoList);
			return mav;
		} else if (userExists.equals("0")) {
			ModelAndView mav = new ModelAndView("farmersDashboard");
			
			String lgid=""+session.getAttribute("logid");		
			int lid=Integer.parseInt(lgid);
			
			String username="";
			Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
			qrey.setInteger("lid", lid);
			List li = qrey.list();
			Iterator ite = li.iterator();
			while (ite.hasNext()) {
				Object o = (Object) ite.next();
				LoginModel log = (LoginModel) o;
				username = log.getUsername();			
			}
			int farmerId=0;
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
			
			Session sess2 = sessionFactory.openSession();
			Query qry2 = sess2.createQuery("from PhotoModel m where m.logid=:lid");
			qry2.setInteger("lid", lid);
			List list = qry2.list();
			request.setAttribute("list", list);
			
			return mav;
		} else if(userExists.equals("null")){
			ModelAndView mav = new ModelAndView("loginForm");
			mav.addObject("errMess", "Wrong Credentials");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("loginForm");
			mav.addObject("errMess", "Wrong Credentials");
			return mav;
		}
	}
}
