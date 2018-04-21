package com.findmytutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.findmytutor.model.User;
import com.findmytutor.service.RoleProfileService;
import com.findmytutor.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController
{

	@Autowired
	UserService userService;

	@Autowired
	RoleProfileService roleProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	/**
	 * This method will list all existing users if the current user is logged in
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model)
	{
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "home";
	}

	@RequestMapping(value = "/noadmin", method = RequestMethod.GET)
	public String noAdmin(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "firsttimenoadmin";
	}
	
	/**
	 * This method will provide a list of users
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(ModelMap model)
	{
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "userslist";
	}

	/**
	 * This method will provide a list of users
	 */
	@RequestMapping(value = "/tutorlist", method = RequestMethod.GET)
	public String listTutors(ModelMap model)
	{
		List<User> users = userService.findAllTutors();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "tutorslist";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipalUsername()
	{
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
		{
			userName = ((UserDetails) principal).getUsername();
		}
		else
		{
			userName = principal.toString();
		}
		return userName;
	}

}