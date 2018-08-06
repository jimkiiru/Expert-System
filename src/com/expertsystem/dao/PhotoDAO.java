package com.expertsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expertsystem.model.PhotoModel;

@Repository
@Transactional
public class PhotoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PhotoModel getById(int photoId)
	{
		return (PhotoModel) sessionFactory.getCurrentSession().get(PhotoModel.class, photoId);
	}
	
	@SuppressWarnings("unchecked")
	public List<PhotoModel> getAllPhotos()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PhotoModel.class);
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}
	public int save(PhotoModel photo)
	{
		int i;		
		i=(Integer) sessionFactory.getCurrentSession().save(photo);
		return i;
	}
	
	public void update(PhotoModel photo)
	{
		sessionFactory.getCurrentSession().merge(photo);
		
	}
	
	public void delete(int photoId)
	{
		PhotoModel s = getById(photoId);
		sessionFactory.getCurrentSession().delete(s);
	}
}
