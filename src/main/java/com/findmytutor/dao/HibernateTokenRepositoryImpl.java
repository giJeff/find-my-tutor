package com.findmytutor.dao;

import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.findmytutor.model.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin>
		implements PersistentTokenRepository
{

	static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.rememberme.
	 * PersistentTokenRepository#createNewToken(org.springframework.security.web.
	 * authentication.rememberme.PersistentRememberMeToken) Uses rememberme to store
	 * the currently logged in user info
	 */
	@Override
	public void createNewToken(PersistentRememberMeToken token)
	{
		logger.info("Creating Token for user : {}", token.getUsername());
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persist(persistentLogin);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.rememberme.
	 * PersistentTokenRepository#getTokenForSeries(java.lang.String)
	 */
	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId)
	{
		logger.info("Fetch Token if any for seriesId : {}", seriesId);
		try
		{
			// Open Session
			Session session = getSession();

			// Get Criteria Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria
			CriteriaQuery<PersistentLogin> query = builder.createQuery(PersistentLogin.class);
			Root<PersistentLogin> root = query.from(PersistentLogin.class);
			query.select(root);
			query.where(builder.equal(root.get("series"), seriesId));

			PersistentLogin persistentLogin = (PersistentLogin) session.createQuery(query).getSingleResult();

			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		}
		catch (Exception e)
		{
			logger.info("Token not found...");
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.rememberme.
	 * PersistentTokenRepository#removeUserTokens(java.lang.String)
	 */
	@Override
	public void removeUserTokens(String username)
	{
		logger.info("Removing Token if any for user : {}", username);
		// Open Session
		Session session = getSession();

		// Get Criteria Builder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create Criteria
		CriteriaQuery<PersistentLogin> query = builder.createQuery(PersistentLogin.class);
		Root<PersistentLogin> root = query.from(PersistentLogin.class);
		query.select(root);
		query.where(builder.equal(root.get("username"), username));
		try
		{
			PersistentLogin persistentLogin = (PersistentLogin) session.createQuery(query).getSingleResult();
			if (persistentLogin != null)
			{
				logger.info("rememberMe was selected");
				delete(persistentLogin);
			}
		}
		catch (NoResultException nre)
		{

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.rememberme.
	 * PersistentTokenRepository#updateToken(java.lang.String, java.lang.String,
	 * java.util.Date)
	 */
	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed)
	{
		logger.info("Updating Token for seriesId : {}", seriesId);
		PersistentLogin persistentLogin = getByKey(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		update(persistentLogin);
	}

}
