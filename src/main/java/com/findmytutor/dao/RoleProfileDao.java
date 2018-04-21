package com.findmytutor.dao;

import java.util.List;

import com.findmytutor.model.RoleProfile;

public interface RoleProfileDao
{

	List<RoleProfile> findAll();

	RoleProfile findByType(String type);

	RoleProfile findById(int id);
}
