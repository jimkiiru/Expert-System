package com.expertsystem.controller;

import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.model.ExpertModel;
import com.expertsystem.model.FarmerModel;
import com.expertsystem.model.LoginModel;
import com.expertsystem.model.PhotoModel;
import com.expertsystem.model.ReplyModel;

@Controller
public class ReplyController {

	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "/sendResponse", method = RequestMethod.GET)
	public ModelAndView newFarmer(@RequestParam("photoId") Integer photoId, HttpSession session) {
		ModelAndView mav = new ModelAndView("newReply");

		String lgid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(lgid);

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

		int logid = 0;
		Query qrey2 = sess.createQuery("from PhotoModel e where e.photoId=:pid");
		qrey2.setInteger("pid", photoId);
		List l2 = qrey2.list();
		Iterator it2 = l2.iterator();
		while (it2.hasNext()) {
			Object o = (Object) it2.next();
			PhotoModel em = (PhotoModel) o;
			logid = em.getLogid();
		}
		mav.addObject("famid", logid);
		mav.addObject("photoId", photoId);
		ReplyModel category = new ReplyModel();
		mav.getModelMap().put("newReply", category);
		return mav;
	}

	@RequestMapping(value = "/sendResponse", method = RequestMethod.POST)
	public String create(@Valid ReplyModel reply, BindingResult result, SessionStatus status) {

		/*
		 * validator.validate(farmer, result); if (result.hasErrors()) {
		 * ModelAndView mav = new ModelAndView("newFarmer"); return mav; }
		 */
		ModelAndView mav = new ModelAndView("expertDashboard");

		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		String hqlUpdate = "update PhotoModel p set p.reply=:rep where p.photoId=:pid and p.logid=:lid ";
		int updateEntities = sess.createQuery(hqlUpdate).setString("rep", reply.getReply())
				.setInteger("pid", reply.getPhotoId()).setInteger("lid", reply.getFarmerid()).executeUpdate();
		tx.commit();
		sess.close();

		return "redirect:expertDash";
	}
}
