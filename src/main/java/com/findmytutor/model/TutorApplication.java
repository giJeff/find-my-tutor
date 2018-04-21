package com.findmytutor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "TUTOR_APPLICATION")
public class TutorApplication implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;

	@NotEmpty
	@Column(name = "QUESTION1", unique = false, nullable = false)
	private String question1;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getQuestion1()
	{
		return question1;
	}

	public void setQuestion1(String question1)
	{
		this.question1 = question1;
	}

}
