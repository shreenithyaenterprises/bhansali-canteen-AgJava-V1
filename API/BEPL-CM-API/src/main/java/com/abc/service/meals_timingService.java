package com.abc.service;

import java.util.List;
import com.abc.model.meals_timing;

public interface meals_timingService
{

	public List<meals_timing> getAllmeals_timing();
	
	public List<meals_timing> getAllmealstimingBySite(String site);
	
	public meals_timing getmeals_timingById(String meal_code);
	
	public meals_timing Save(meals_timing meals_timing);
	
	public List<meals_timing> SaveAll(List<meals_timing> meals_timing);
	
	public void delete(meals_timing meals_timing);

}