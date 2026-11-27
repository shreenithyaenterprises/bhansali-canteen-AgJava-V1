package com.abc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class emergencyId implements Serializable 
{
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+05:30")
	@Temporal(TemporalType.DATE)
	private Date created_date;
	private String shift;
	
	public emergencyId()
	{
		super();
	}

	public emergencyId(Date created_date, String shift)
	{
		super();
		this.created_date = created_date;
		this.shift = shift;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(created_date, shift);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		emergencyId other = (emergencyId) obj;
		return Objects.equals(created_date, other.created_date) && Objects.equals(shift, other.shift);
	}
	
	
}
