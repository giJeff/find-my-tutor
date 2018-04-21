package com.findmytutor.dao;

import java.util.List;

import com.findmytutor.model.TutorApplication;

public interface TutorApplicationDao
{

	TutorApplication findById(int id);

	TutorApplication findByUsername(String username);

	void save(TutorApplication tutorApplication);

	List<TutorApplication> findAllApplications();

	void deleteByID(int id);

	void deleteByUsername(String username);

}
