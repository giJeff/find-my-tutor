package com.findmytutor.model;

import java.io.Serializable;

public enum RoleProfileType implements Serializable
{
	STUDENT("STUDENT"), TUTOR("TUTOR"), ADMIN("ADMIN");

	String roleProfileType;

	private RoleProfileType(String roleProfileType)
	{
		this.roleProfileType = roleProfileType;
	}

	public String getRoleProfileType()
	{
		return roleProfileType;
	}

}
