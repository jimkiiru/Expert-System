package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.PotatoDiseaseModel;

@Repository
@Transactional
public class PotatoDiseaseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PotatoDiseaseModel getById(int diseaseId)
	{
		return (PotatoDiseaseModel) sessionFactory.getCurrentSession().get(PotatoDiseaseModel.class, diseaseId);
	}
	
	@SuppressWarnings("unchecked")
	public List<PotatoDiseaseModel> getAllDiseases()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PotatoDiseaseModel.class);
		return criteria.list();
	}
	public int save(PotatoDiseaseModel potato)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(potato);
		return i;
	}
	
	public void update(PotatoDiseaseModel potato)
	{
		sessionFactory.getCurrentSession().merge(potato);
		
	}
	
	public void delete(int diseaseId)
	{
		PotatoDiseaseModel m = getById(diseaseId);
		sessionFactory.getCurrentSession().delete(m);
	}
}
