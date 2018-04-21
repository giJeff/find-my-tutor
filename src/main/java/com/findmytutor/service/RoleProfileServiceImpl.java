package com.findmytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findmytutor.dao.RoleProfileDao;
import com.findmytutor.model.RoleProfile;

@Service("roleProfileService")
@Transactional
public class RoleProfileServiceImpl implements RoleProfileService
{

	@Autowired
	RoleProfileDao dao;

	public RoleProfile findById(int id)
	{
		return dao.findById(id);
	}

	public RoleProfile findByType(String type)
	{
		return dao.findByType(type);
	}

	public List<RoleProfile> findAll()
	{
		return dao.findAll();
	}
}
