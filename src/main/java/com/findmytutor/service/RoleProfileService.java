package com.findmytutor.service;

import java.util.List;

import com.findmytutor.model.RoleProfile;

public interface RoleProfileService
{

	RoleProfile findById(int id);

	RoleProfile findByType(String type);

	List<RoleProfile> findAll();

}
