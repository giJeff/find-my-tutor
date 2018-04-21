package com.findmytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findmytutor.dao.TutorApplicationDao;
import com.findmytutor.model.TutorApplication;

@Service("tutorApplicationService")
@Transactional
public class TutorApplicationServiceImpl implements TutorApplicationService
{

	@Autowired
	private TutorApplicationDao dao;

	public TutorApplication findById(int id)
	{
		return dao.findById(id);
	}

	public void saveApplication(TutorApplication tutorApplication)
	{

		dao.save(tutorApplication);
	}

	public List<TutorApplication> findAllApplications()
	{
		return dao.findAllApplications();
	}

	public void deleteTutorApplicationByID(int id)
	{
		dao.deleteByID(id);
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username)
	{
		TutorApplication user = findByUsername(username);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public TutorApplication findByUsername(String username)
	{
		TutorApplication user = dao.findByUsername(username);
		return user;
	}

	@Override
	public void deleteTutorApplicationByUsername(String username)
	{
		dao.deleteByUsername(username);
		
	}

}
