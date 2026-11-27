package com.abc.model;

import java.io.Serializable;
import java.util.Objects;

public class Meal_timing_Id implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mealCode;
	private String siteCode;
	private String shiftCode;
	
	public Meal_timing_Id(String mealCode, String siteCode, String shiftCode) {
		super();
		this.mealCode = mealCode;
		this.siteCode = siteCode;
		this.shiftCode = shiftCode;
	}

	public Meal_timing_Id() 
	{
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(mealCode, shiftCode, siteCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal_timing_Id other = (Meal_timing_Id) obj;
		return Objects.equals(mealCode, other.mealCode) && Objects.equals(shiftCode, other.shiftCode)
				&& Objects.equals(siteCode, other.siteCode);
	}

}
