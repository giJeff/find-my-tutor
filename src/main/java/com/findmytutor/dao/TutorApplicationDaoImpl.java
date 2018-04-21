package com.findmytutor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.findmytutor.model.TutorApplication;

@Repository("tutorApplicationDao")
public class TutorApplicationDaoImpl extends AbstractDao<Integer, TutorApplication> implements TutorApplicationDao
{

	static final Logger logger = LoggerFactory.getLogger(TutorApplicationDaoImpl.class);

	public TutorApplication findById(int id)
	{
		TutorApplication tutorApplication = getByKey(id);
		return tutorApplication;
	}

	public TutorApplication findByUsername(String username)
	{
		logger.info("USERNAME : {}", username);
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<TutorApplication> query = builder.createQuery(TutorApplication.class);
			Root<TutorApplication> root = query.from(TutorApplication.class);
			query.select(root);
			query.where(builder.equal(root.get("username"), username));

			TutorApplication application = (TutorApplication) session.createQuery(query).getSingleResult();
			return application;

		}
		catch (NoResultException nre)
		{

		}
		return null;
	}

	public List<TutorApplication> findAllApplications()
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<TutorApplication> query = builder.createQuery(TutorApplication.class);
			Root<TutorApplication> root = query.from(TutorApplication.class);
			query.select(root);
			query.orderBy(builder.asc(root.get("id")));

			// Use criteria to query with session to fetch all contacts
			List<TutorApplication> applications = session.createQuery(query).getResultList();

			return applications;
		}
		catch (NoResultException nre)
		{

		}
		return null;

	}

	public void save(TutorApplication tutorApplication)
	{
		persist(tutorApplication);
	}

	public void deleteByID(int id)
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<TutorApplication> query = builder.createQuery(TutorApplication.class);
			Root<TutorApplication> root = query.from(TutorApplication.class);
			query.select(root);
			query.where(builder.equal(root.get("id"), id));

			TutorApplication application = (TutorApplication) session.createQuery(query).getSingleResult();
			delete(application);
		}
		catch (NoResultException nre)
		{

		}

	}

	@Override
	public void deleteByUsername(String username)
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<TutorApplication> query = builder.createQuery(TutorApplication.class);
			Root<TutorApplication> root = query.from(TutorApplication.class);
			query.select(root);
			query.where(builder.equal(root.get("username"), username));

			TutorApplication application = (TutorApplication) session.createQuery(query).getSingleResult();
			delete(application);
		}
		catch (NoResultException nre)
		{

		}
		
	}

}
