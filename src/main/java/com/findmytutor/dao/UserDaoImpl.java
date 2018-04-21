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

import com.findmytutor.model.User;

@Repository("userDao")
public class UserDaoImpl<RoleProfile> extends AbstractDao<Integer, User> implements UserDao
{

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	public User findById(int id)
	{
		User user = getByKey(id);
		if (user != null)
		{
			Hibernate.initialize(user.getRoleProfiles());
		}
		return user;
	}

	public User findByUsername(String username)
	{
		logger.info("USERNAME : {}", username);
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> userRoot = query.from(User.class);
			query.select(userRoot);
			query.where(builder.equal(userRoot.get("username"), username));

			User user = (User) session.createQuery(query).getSingleResult();
			if (user != null)
			{
				Hibernate.initialize(user.getRoleProfiles());
			}
			return user;

		}
		catch (NoResultException nre)
		{

		}
		return null;
	}

	public List<User> findAllUsers()
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> userRoot = query.from(User.class);
			query.select(userRoot);
			query.orderBy(builder.asc(userRoot.get("lastName")));

			// Use criteria to query with session to fetch all contacts
			List<User> users = session.createQuery(query).getResultList();

			return users;
		}
		catch (NoResultException nre)
		{

		}
		return null;

	}

	public void save(User user)
	{
		persist(user);
	}

	public void deleteByUsername(String username)
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> userRoot = query.from(User.class);
			query.select(userRoot);
			query.where(builder.equal(userRoot.get("username"), username));

			User user = (User) session.createQuery(query).getSingleResult();
			delete(user);
		}
		catch (NoResultException nre)
		{

		}

	}

	@Override
	public List<User> findAllTutors()
	{
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			Join<User, RoleProfile> join = root.join("roleProfiles");
			query.where(builder.equal(join.get("type"), "TUTOR"));

			// Use criteria to query with session to fetch all contacts
			List<User> users = session.createQuery(query).getResultList();

			return users;
		}
		catch (NoResultException nre)
		{

		}
		return null;
	}

}
