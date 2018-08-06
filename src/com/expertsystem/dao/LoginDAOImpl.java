package com.expertsystem.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.expertsystem.model.LoginModel;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	String status;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public String checkLogin(String username, String password) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		String userFound = "";
		String SQL_QUERY = "select a.status from LoginModel as a where a.username=? and a.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List list = query.list();
		Iterator itr = list.iterator();

		if (itr.hasNext()) {
			Object o = itr.next();
			status = "" + o;
		}
		
		if (status.equals("expert")) {
			if ((list != null) && (list.size() > 0)) {
				userFound = "1";
			}
		} else if (status.equals("farmer")) {
			if ((list != null) && (list.size() > 0)) {
				userFound = "0";
			}
		} else if(status.equals("")){			
				userFound = "null";			
		}
		return userFound;
	}

}
