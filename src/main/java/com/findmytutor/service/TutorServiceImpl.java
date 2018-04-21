package com.findmytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findmytutor.dao.TutorDao;
import com.findmytutor.model.Tutor;

@Service("tutorService")
@Transactional
public class TutorServiceImpl implements TutorService
{
	@Autowired
	private TutorDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Tutor findById(int id)
	{
		return dao.findById(id);
	}
	
	public Tutor findByUsername(String userName)
	{
		Tutor tutor = dao.findByUsername(userName);
		return tutor;
	}
	
	public void saveTutor(Tutor tutor)
	{
		tutor.setPassword(passwordEncoder.encode(tutor.getPassword()));
		dao.save(tutor);
	}
	
	public void updateTutor(Tutor tutor)
	{
		Tutor entity = dao.findById(tutor.getId());
		if(entity != null)
		{
			entity.setUserName(tutor.getUserName());
			if(!tutor.getPassword().equals(entity.getPassword()))
			{
				entity.setPassword(passwordEncoder.encode(tutor.getPassword()));
			}
			entity.setfirstName(tutor.getFirstName());
			entity.setLasttName(tutor.getLastName());
			entity.setSubject(tutor.getSubject());
			entity.setBio(tutor.getBio());
			entity.setEmail(tutor.getEmail());
			entity.setRoleProfiles(tutor.getRoleProfiles());
		}
	}
	
	public void deleteTutorByUsername(String userName)
	{
		dao.deleteByUsername(userName);
	}
	
	public List<Tutor> findAllTutors()
	{
		return dao.findAllTutors();
	}
	
	public boolean isUsernameUnique(Integer id, String userName)
	{
		Tutor tutor = findByUsername(userName);
		return (tutor == null || ((id != null) && (tutor.getId() == id)));
	}

}
