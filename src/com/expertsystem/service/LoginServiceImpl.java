package com.expertsystem.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertsystem.dao.LoginDAO;
import com.expertsystem.model.LoginModel;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	protected SessionFactory sessionFactory;

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public String checkLogin(String username, String password) {
		System.out.println("In Service class...Check Login");
		return loginDAO.checkLogin(username, password);
	}

	

}
