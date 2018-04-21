package com.findmytutor.model;

public class School
{
	private String school_name;
	private String school_address;

	public School()
	{

	}

	public School(String school_name, String school_address)
	{
		this.school_name = school_name;
		this.school_address = school_address;
	}

	private String getSchool_name()
	{
		return school_name;
	}

	private void setSchool_name(String shcool_name)
	{
		this.school_name = shcool_name;
	}

	private String getSchool_address()
	{
		return school_address;
	}

	private void setSchool_address(String school_address)
	{
		this.school_address = school_address;
	}

}
