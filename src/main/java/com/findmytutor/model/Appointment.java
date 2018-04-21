package com.findmytutor.model;

public class Appointment
{
	private String appt_date; // do the conversion to date in the data layer
	private boolean online; // conversions will be needed to store as tinyint in db
	private String confirmation;

	public Appointment()
	{

	}

	public Appointment(String appt_date, boolean online, String confirmation)
	{
		this.appt_date = appt_date;
		this.online = online;
		this.confirmation = confirmation;
	}

	private String getAppt_date()
	{
		return appt_date;
	}

	private void setAppt_date(String appt_date)
	{
		this.appt_date = appt_date;
	}

	private boolean isOnline()
	{
		return online;
	}

	private void setOnline(boolean online)
	{
		this.online = online;
	}

	private String getConfirmation()
	{
		return confirmation;
	}

	private void setConfirmation(String confirmation)
	{
		this.confirmation = confirmation;
	}
}
