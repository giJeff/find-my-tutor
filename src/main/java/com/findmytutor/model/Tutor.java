package com.findmytutor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "Tutor")

public class Tutor implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@NotEmpty
	@Column(name = "SUBJECT", nullable = false)
	private String subject;
	
	@NotEmpty
	@Column(name = "BIO", nullable = false)
	private String bio;
	
	@NotEmpty
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String userName;
	
	@NotEmpty
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP_USER_ROLE_PROFILE", joinColumns =
	{
			@JoinColumn(name = "USER_ID")
	}, inverseJoinColumns =
	{
			@JoinColumn(name = "ROLE_PROFILE_ID")
	})
	
	private Set<RoleProfile> roleProfiles = new HashSet<RoleProfile>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLasttName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public String getBio() 
	{
		return this.bio;
	}
	
	public void setBio(String bio)
	{
		this.bio = bio;
	}
	
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public Set<RoleProfile> getRoleProfiles()
	{
		return roleProfiles;
	}
	
	public void setRoleProfiles(Set<RoleProfile> roleProfiles)
	{
		this.roleProfiles = roleProfiles;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Tutor))
			return false;
		Tutor other = (Tutor) obj;
		if(id == null)
		{
			if(other.id != null)
				return false;
		}
		else
			if(!id.equals(other.id))
				return false;
		if(userName == null)
		{
			if(other.userName != null)
				return false;
		}
		else
			if(!userName.equals(other.userName))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject
				+ ", bio=" + bio + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
}
