package com.findmytutor.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.findmytutor.model.RoleProfile;
import com.findmytutor.model.User;
import com.findmytutor.service.RoleProfileService;
import com.findmytutor.service.TutorApplicationService;
import com.findmytutor.service.UserService;

@Controller
@RequestMapping("/auth")
@SessionAttributes("roles")
public class LoginController
{

	@Autowired
	UserService userService;
	
	@Autowired
	TutorApplicationService tutorApplicationService;

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
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String newUser(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registration";
	}

	/**
	 * This method will be called on submit, it saves and validates users
	 */
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model)
	{
		if (result.hasErrors())
		{
			return "registration";
		}

		/*
		 * Error message if username is not unique
		 */
		if (!userService.isUsernameUnique(user.getId(), user.getUsername()))
		{
			FieldError usernameError = new FieldError("user", "username",
					messageSource.getMessage("non.unique.username", new String[]
					{
							user.getUsername()
					}, Locale.getDefault()));
			result.addError(usernameError);
			return "registration";
		}

		userService.saveUser(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		// return "success";
		return "registrationsuccess";
	}

	/**
	 * This method will provide updates
	 */
	@RequestMapping(value = "/edit-user-{username}", method = RequestMethod.GET)
	public String editUser(@PathVariable String username, ModelMap model)
	{
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("routeBack", "list");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = "/edit-user-{username}", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String username)
	{
		if (result.hasErrors())
		{
			return "registration";
		}

		userService.updateUser(user);
		model.addAttribute("routeBack", "list");

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registrationsuccess";
	}
	
	/**
	 * This method will provide updates
	 */
	@RequestMapping(value = "/edit-tutor-{username}", method = RequestMethod.GET)
	public String editTutor(@PathVariable String username, ModelMap model)
	{
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("routeBack", "tutorlist");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = "/edit-tutor-{username}", method = RequestMethod.POST)
	public String updateTutor(@Valid User user, BindingResult result, ModelMap model, @PathVariable String username)
	{
		if (result.hasErrors())
		{
			return "registration";
		}

		userService.updateUser(user);
		model.addAttribute("routeBack", "tutorlist");

		model.addAttribute("success",
				"User " + user.getUsername() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registrationsuccess";
	}
	
	/**
	 * This method will provide updates
	 */
	@RequestMapping(value = "/edit-tutor-application-{username}", method = RequestMethod.GET)
	public String editTutorApplication(@PathVariable String username, ModelMap model)
	{
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("routeBack", "tutor/listapplications");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = "/edit-tutor-application-{username}", method = RequestMethod.POST)
	public String updateTutorApplication(@Valid User user, BindingResult result, ModelMap model, @PathVariable String username)
	{
		if (result.hasErrors())
		{
			return "registration";
		}
		model.addAttribute("routeBack", "tutor/listapplications");
		
		tutorApplicationService.deleteTutorApplicationByUsername(username);

		userService.updateUser(user);

		model.addAttribute("success",
				"User " + user.getUsername() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user found by the USERNAME
	 */
	@RequestMapping(value = "/delete-user-{username}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username)
	{
		userService.deleteUserByUsername(username);
		return "redirect:/list";
	}

	/**
	 * This method will delete an user found by the USERNAME
	 */
	@RequestMapping(value = "/delete-tutor-{username}", method = RequestMethod.GET)
	public String deleteTutor(@PathVariable String username)
	{
		userService.deleteUserByUsername(username);
		return "redirect:/tutorlist";
	}

	/**
	 * This method will provide RoleProfile list to views
	 */
	@ModelAttribute("roles")
	public List<RoleProfile> initializeProfiles()
	{
		return roleProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model)
	{
		model.addAttribute("loggedinuser", getPrincipalUsername());
		return "accessDenied";
	}

	/**
	 * if logged in this will not allow users to see the login view again
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage()
	{
		if (isCurrentAuthenticationAnonymous())
		{
			return "login";
		}
		else
		{
			return "redirect:/";
		}
	}

	/**
	 * This method handles logout requests. Toggle the handlers if you are
	 * RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
		{
			// new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:login?logout";
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

	/**
	 * This method returns true if users is already authenticated [logged-in], else
	 * false.
	 */
	private boolean isCurrentAuthenticationAnonymous()
	{
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}