package com.findmytutor.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.findmytutor.model.RoleProfile;
import com.findmytutor.service.RoleProfileService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToRoleProfileConverter implements Converter<Object, RoleProfile>
{

	static final Logger logger = LoggerFactory.getLogger(RoleToRoleProfileConverter.class);

	@Autowired
	RoleProfileService roleProfileService;

	/**
	 * Gets RoleProfile by Id
	 * 
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public RoleProfile convert(Object element)
	{
		Integer id = Integer.parseInt((String) element);
		RoleProfile profile = roleProfileService.findById(id);
		logger.info("Profile : {}", profile);
		return profile;
	}

}