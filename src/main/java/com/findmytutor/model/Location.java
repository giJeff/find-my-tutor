package com.findmytutor.model;

public class Location
{
	private String building;
	private String room_number;

	public Location()
	{

	}

	public Location(String building, String room_number)
	{
		this.building = building;
		this.room_number = room_number;
	}

	private String getBuilding()
	{
		return building;
	}

	private void setBuilding(String building)
	{
		this.building = building;
	}

	private String getRoom_number()
	{
		return room_number;
	}

	private void setRoom_number(String room_number)
	{
		this.room_number = room_number;
	}
}