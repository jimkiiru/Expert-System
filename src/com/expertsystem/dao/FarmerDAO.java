package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.FarmerModel;

@Repository
@Transactional
public class FarmerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public FarmerModel getById(int farmerId)
	{
		return (FarmerModel) sessionFactory.getCurrentSession().get(FarmerModel.class, farmerId);
	}
	
	@SuppressWarnings("unchecked")
	public List<FarmerModel> getAllFarmers()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FarmerModel.class);
		return criteria.list();
	}
	public int save(FarmerModel farmer)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(farmer);
		return i;
	}
	
	public void update(FarmerModel farmer)
	{
		farmer.setStatus("farmer");
		sessionFactory.getCurrentSession().merge(farmer);
		
	}
	
	public void delete(int farmerId)
	{
		FarmerModel a = getById(farmerId);
		sessionFactory.getCurrentSession().delete(a);
	}
}
