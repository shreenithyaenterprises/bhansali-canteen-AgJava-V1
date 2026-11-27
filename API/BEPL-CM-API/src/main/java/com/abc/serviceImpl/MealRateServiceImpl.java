package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.MealRate;
import com.abc.repository.MealRateRepository;
import com.abc.service.MealRateService;

@Service
@Transactional
public class MealRateServiceImpl implements MealRateService
{

	@Autowired
	MealRateRepository repo;
	
	@Override
	public List<MealRate> getAllMealRate()
	{
		return (List<MealRate>) repo.findAll();
	}
	@Override
	public MealRate getMealRateById(Integer sr_no)
	{
		return repo.findById(sr_no).get();
	}
	@Override
	public MealRate Save(MealRate mealrate)
	{
		return repo.save(mealrate);
	}
	@Override
	public List<MealRate> SaveAll(List<MealRate> mealrate)
	{
		return (List<MealRate>) repo.saveAll(mealrate);
	}
	@Override
	public void delete(Integer sr_no)
	{
		 repo.deleteById(sr_no);
	}
}
