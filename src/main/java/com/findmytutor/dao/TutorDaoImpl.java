package com.findmytutor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.findmytutor.model.Tutor;

@Repository("tutorDao")
public class TutorDaoImpl<RoleProfile> extends AbstractDao<Integer, Tutor> implements TutorDao{

	static final Logger logger = LoggerFactory.getLogger(TutorDaoImpl.class);
	
	@Override
	public Tutor findById(int id) {
		Tutor tutor = getByKey(id);
		if(tutor != null)
		{
			Hibernate.initialize(tutor.getRoleProfiles());
		}
		return tutor;
	}

	@Override
	public Tutor findByUsername(String userName) {
		logger.info("Username : {}", userName);
		try
		{
			Session session = getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Tutor> query = builder.createQuery(Tutor.class);
			Root<Tutor> tutorRoot = query.from(Tutor.class);
			query.select(tutorRoot);
			query.where(builder.equal(tutorRoot.get("userName"), userName));
			
			Tutor tutor = (Tutor) session.createQuery(query).getSingleResult();
			if(tutor != null)
			{
				Hibernate.initialize(tutor.getRoleProfiles());
			}
			return tutor;
		}
		catch (NoResultException nre)
		{
			
		}
		return null;
	}

	@Override
	public void save(Tutor tutor) {
		persist(tutor);
		
	}

	@Override
	public List<Tutor> findAllTutors() 
	{
		try
		{
			Session session = getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Tutor> query = builder.createQuery(Tutor.class);
			Root<Tutor> root = query.from(Tutor.class);
			Join<Tutor, RoleProfile> join = root.join("roleProfiles");
			query.where(builder.equal(join.get("type"), "TUTOR"));
			
			List<Tutor> tutors = session.createQuery(query).getResultList();
			return tutors;
		}
		catch (NoResultException nre)
		{
			
		}
		return null;
	}

	@Override
	public void deleteByUsername(String userName) {
		try
		{
			Session session = getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Tutor> query = builder.createQuery(Tutor.class);
			Root<Tutor> tutorRoot = query.from(Tutor.class);
			query.select(tutorRoot);
			query.where(builder.equal(tutorRoot.get("userName"), userName));
			
			Tutor tutor = (Tutor) session.createQuery(query).getSingleResult();
			delete(tutor);
		}
		catch (NoResultException nre)
		{
			
		}
		
	}

}
