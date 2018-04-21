package com.findmytutor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.findmytutor.model.TutorApplication;
import com.findmytutor.model.User;
import com.findmytutor.service.RoleProfileService;
import com.findmytutor.service.TutorApplicationService;
import com.findmytutor.service.UserService;

@Controller
@RequestMapping("/tutor")
@SessionAttributes("roles")
public class TutorApplicationController
{

	@Autowired
	TutorApplicationService tutorApplicationService;

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
	 * This method will provide the registration form
	 */
	@RequestMapping(value = "/newtutor", method = RequestMethod.GET)
	public String newTutorApplication(ModelMap model)
	{
		User user = new User();
		model.addAttribute("username", user.getUsername());
		TutorApplication tutorApplication = new TutorApplication();
		model.addAttribute("tutorApplication", tutorApplication);
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "tutorapplication";
	}

	/**
	 * This method will be called on submit, it saves and validates users
	 */
	@RequestMapping(value = "/newtutor", method = RequestMethod.POST)
	public String saveTutorApplication(@Valid TutorApplication tutorApplication, BindingResult result, ModelMap model)
	{
		if (result.hasErrors())
		{
			return "tutorapplication";
		}

		tutorApplicationService.saveApplication(tutorApplication);

		model.addAttribute("loggedinuser", getPrincipalUsername());
		model.addAttribute("success", "User " + getPrincipalUsername() + " has applied to be a tutor!");
		// return "success";
		return "tutorapplicationsuccess";
	}

	/**
	 * This method will provide a list of users
	 */
	@RequestMapping(value = "/listapplications", method = RequestMethod.GET)
	public String listUsers(ModelMap model)
	{
		List<TutorApplication> applications = tutorApplicationService.findAllApplications();
		model.addAttribute("applications", applications);
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "tutorapplicationlist";
	}

	/**
	 * This method will delete an user found by the ID
	 */
	@RequestMapping(value = "/delete-tutor-application-with-{id}", method = RequestMethod.GET)
	public String deleteTutorApplication(@PathVariable int id)
	{
		tutorApplicationService.deleteTutorApplicationByID(id);
		return "redirect:/tutor/listapplications";
	}
	
	/**
	 * This method will delete an user found by the USERNAME
	 */
	@RequestMapping(value = "/delete-tutor-application-by-{username}", method = RequestMethod.GET)
	public String deleteTutorApplication(@PathVariable String username)
	{
		tutorApplicationService.deleteTutorApplicationByUsername(username);
		return "redirect:/tutor/listapplications";
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