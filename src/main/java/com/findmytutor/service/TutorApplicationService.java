package com.findmytutor.service;

import java.util.List;

import com.findmytutor.model.TutorApplication;

public interface TutorApplicationService
{

	TutorApplication findById(int id);

	TutorApplication findByUsername(String username);

	void saveApplication(TutorApplication tutorApplication);

	List<TutorApplication> findAllApplications();

	void deleteTutorApplicationByID(int id);

	boolean isUsernameUnique(Integer id, String username);

	void deleteTutorApplicationByUsername(String username);
}