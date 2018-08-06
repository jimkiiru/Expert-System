package com.expertsystem.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.model.*;

@Controller
public class ResetPasswordController {

	private String token;
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "/forgotpass", method = RequestMethod.GET)
	public ModelAndView forgotPass() {
		ModelAndView mav = new ModelAndView("forgotPassword");
		ForgotPassModel forgot = new ForgotPassModel();
		mav.getModelMap().put("forgotPassword", forgot);
		return mav;
	}
	@RequestMapping(value = "/forgotpass", method = RequestMethod.POST)
	public ModelAndView getPass(@ModelAttribute("forgotPassword") ForgotPassModel forgot, BindingResult result) {
						
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

		token = h + "" + ss + "" + randomNum + "" + c;
		
		//SessionFactory factory1 = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		String hqlUpdate = "update LoginModel l set l.password=:pass where l.username=:user";
		int updateEntities = sess.createQuery(hqlUpdate).setString("pass", token)
				.setString("user", forgot.getUsername()).executeUpdate();
		tx.commit();
		String recipientAddress = forgot.getUsername();
		String mess="Your account password has been reset to: "+token;
		SimpleMailMessage email1 = new SimpleMailMessage();
		email1.setTo(recipientAddress);
		email1.setSubject("Password Reset.");
		email1.setText(mess);
		mailSender.send(email1);
		
		ModelAndView mav=new ModelAndView("forgotPassword");
		mav.addObject("mess","Your new password has been mailed to you.");
		
		return mav;
	}
	
	@RequestMapping(value = "/resetpass", method = RequestMethod.GET)
	public ModelAndView resetPass() {
		ModelAndView mav = new ModelAndView("resetPassword");
		ResetPasswordModel pass = new ResetPasswordModel();
		mav.getModelMap().put("resetPassword", pass);
		return mav;
	}

	@RequestMapping(value = "/resetpass", method = RequestMethod.POST)
	public ModelAndView getNewPaswd(@Valid @ModelAttribute("resetPassword")ResetPasswordModel reset, BindingResult result,
			ResetPasswordModel u,HttpServletRequest request, HttpSession session) {

		if (result.hasErrors()) {
			ModelAndView mav1 = new ModelAndView("resetPassword");			
			return mav1;
		}
		
		String oldPassword="";
		//SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		
		Query query = sess.createQuery("from LoginModel l where l.username=?");	
		query.setParameter(0, reset.getUsername());

		List list = query.list();
		Iterator itr = list.iterator();

		if (itr.hasNext()) {
			Object o = (Object) itr.next();
			LoginModel l = (LoginModel) o;
			oldPassword = l.getPassword();
		}
		
		if (oldPassword.equals(reset.getOldPassword())) {
			String hqlUpdate = "update FarmerModel f set f.password=:pass where f.phonenum=:num";
			int updateEntities = sess.createQuery(hqlUpdate).setString("pass", reset.getNewPassword())
					.setString("num", reset.getUsername()).executeUpdate();
			String hqlUpdate1 = "update LoginModel l set l.password=:pas where l.username=:user";
			int updateEntities1 = sess.createQuery(hqlUpdate1).setString("pas", reset.getNewPassword())
					.setString("user", reset.getUsername()).executeUpdate();
			tx.commit();
			sess.close();
			ModelAndView model = new ModelAndView("resetPassword");
			model.addObject("returnMessage", "You have successfully reset your password");
			return model;
		} else {
			ModelAndView mav = new ModelAndView("resetPassword");
			mav.addObject("returnMessage", "Please enter your old password.");
			return mav;
		}
	}
}
