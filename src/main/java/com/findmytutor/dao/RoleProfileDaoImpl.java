package com.findmytutor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.findmytutor.model.RoleProfile;

@Repository("roleProfileDao")
public class RoleProfileDaoImpl extends AbstractDao<Integer, RoleProfile> implements RoleProfileDao
{

	public RoleProfile findById(int id)
	{
		return getByKey(id);
	}

	public RoleProfile findByType(String type)
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<RoleProfile> query = builder.createQuery(RoleProfile.class);
			Root<RoleProfile> root = query.from(RoleProfile.class);
			query.select(root);
			query.where(builder.equal(root.get("type"), type));

			return (RoleProfile) session.createQuery(query).getSingleResult();
		}
		catch (NoResultException nre)
		{

		}
		return null;
	}

	public List<RoleProfile> findAll()
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<RoleProfile> query = builder.createQuery(RoleProfile.class);
			Root<RoleProfile> root = query.from(RoleProfile.class);
			query.select(root);
			query.orderBy(builder.asc(root.get("type")));

			return (List<RoleProfile>) session.createQuery(query).getResultList();
		}
		catch (NoResultException nre)
		{

		}
		return null;
	}

}
