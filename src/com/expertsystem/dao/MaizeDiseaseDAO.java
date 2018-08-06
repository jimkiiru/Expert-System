package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.MaizeDiseaseModel;

@Repository
@Transactional
public class MaizeDiseaseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MaizeDiseaseModel getById(int diseaseId)
	{
		return (MaizeDiseaseModel) sessionFactory.getCurrentSession().get(MaizeDiseaseModel.class, diseaseId);
	}
	
	@SuppressWarnings("unchecked")
	public List<MaizeDiseaseModel> getAllDiseases()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MaizeDiseaseModel.class);
		return criteria.list();
	}
	public int save(MaizeDiseaseModel maize)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(maize);
		return i;
	}
	
	public void update(MaizeDiseaseModel maize)
	{
		sessionFactory.getCurrentSession().merge(maize);
		
	}
	
	public void delete(int diseaseId)
	{
		MaizeDiseaseModel m = getById(diseaseId);
		sessionFactory.getCurrentSession().delete(m);
	}
}
