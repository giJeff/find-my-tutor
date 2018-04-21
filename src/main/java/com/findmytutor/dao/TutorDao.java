package com.findmytutor.dao;

import java.util.List;

import com.findmytutor.model.Tutor;

public interface TutorDao 
{
	Tutor findById(int id);
	
	Tutor findByUsername(String userName);
	
	void save(Tutor tutor);
	
	List<Tutor> findAllTutors();
	
	void deleteByUsername(String userName);

}
