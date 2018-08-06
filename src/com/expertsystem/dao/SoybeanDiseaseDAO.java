package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.*;


@Repository
@Transactional
public class SoybeanDiseaseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SoybeanDiseaseModel getById(int diseaseId)
	{
		return (SoybeanDiseaseModel) sessionFactory.getCurrentSession().get(SoybeanDiseaseModel.class, diseaseId);
	}
	
	@SuppressWarnings("unchecked")
	public List<SoybeanDiseaseModel> getAllDiseases()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SoybeanDiseaseModel.class);
		return criteria.list();
	}
	public int save(SoybeanDiseaseModel soybean)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(soybean);
		return i;
	}
	
	public void update(SoybeanDiseaseModel soybean)
	{
		sessionFactory.getCurrentSession().merge(soybean);
		
	}
	
	public void delete(int diseaseId)
	{
		SoybeanDiseaseModel s = getById(diseaseId);
		sessionFactory.getCurrentSession().delete(s);
	}
}
