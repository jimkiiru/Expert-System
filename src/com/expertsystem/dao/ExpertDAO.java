package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.ExpertModel;

@Repository
@Transactional
public class ExpertDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ExpertModel getById(int expertId)
	{
		return (ExpertModel) sessionFactory.getCurrentSession().get(ExpertModel.class, expertId);
	}
	
	@SuppressWarnings("unchecked")
	public List<ExpertModel> getAllExperts()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ExpertModel.class);
		return criteria.list();
	}
	public int save(ExpertModel expert)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(expert);
		return i;
	}
	
	public void update(ExpertModel expert)
	{
		expert.setStatus("expert");
		sessionFactory.getCurrentSession().merge(expert);
		
	}
	
	public void delete(int expertId)
	{
		ExpertModel a = getById(expertId);
		sessionFactory.getCurrentSession().delete(a);
	}
}
