package com.abc.service;

import java.util.List;
import com.abc.model.meals;

public interface mealsService
{
	public List<meals> getAllmeals();
	
	public meals getmealsById(String meal_code);
	
	public meals Save(meals meals);
	
	public List<meals> SaveAll(List<meals> meals);
	
	public void delete(String meal_code);

	public void pullPunchData();
}