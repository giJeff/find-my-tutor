package com.findmytutor.service;

import java.util.List;

import com.findmytutor.model.Tutor;

public interface TutorService 
{
	
	Tutor findById(int id);
	
	Tutor findByUsername(String userName);
	
	void saveTutor(Tutor tutor);
	
	void updateTutor(Tutor tutor);
	
	void deleteTutorByUsername(String userName);
	
	List<Tutor> findAllTutors();
	
	boolean isUsernameUnique(Integer id, String userName);
}
