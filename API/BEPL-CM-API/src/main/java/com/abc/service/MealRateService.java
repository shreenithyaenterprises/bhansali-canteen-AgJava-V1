package com.abc.service;

import java.util.List;
import com.abc.model.MealRate;

public interface MealRateService
{

	public List<MealRate> getAllMealRate();
	
	public MealRate getMealRateById(Integer sr_no);
	
	public MealRate Save(MealRate mealrate);
	
	public List<MealRate> SaveAll(List<MealRate> mealrate);
	
	public void delete(Integer sr_no);

}