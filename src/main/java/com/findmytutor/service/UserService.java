package com.findmytutor.service;

import java.util.List;

import com.findmytutor.model.User;

public interface UserService
{

	User findById(int id);

	User findByUsername(String username);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserByUsername(String username);

	List<User> findAllUsers();

	List<User> findAllTutors();

	boolean isUsernameUnique(Integer id, String username);

}