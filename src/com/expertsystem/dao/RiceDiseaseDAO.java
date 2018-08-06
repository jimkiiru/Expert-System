package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.RiceDiseaseModel;

@Repository
@Transactional
public class RiceDiseaseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public RiceDiseaseModel getById(int diseaseId)
	{
		return (RiceDiseaseModel) sessionFactory.getCurrentSession().get(RiceDiseaseModel.class, diseaseId);
	}
	
	@SuppressWarnings("unchecked")
	public List<RiceDiseaseModel> getAllDiseases()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RiceDiseaseModel.class);
		return criteria.list();
	}
	public int save(RiceDiseaseModel treatment)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(treatment);
		return i;
	}
	
	public void update(RiceDiseaseModel treatment)
	{
		sessionFactory.getCurrentSession().merge(treatment);
		
	}
	
	public void delete(int diseaseId)
	{
		RiceDiseaseModel a = getById(diseaseId);
		sessionFactory.getCurrentSession().delete(a);
	}
}
