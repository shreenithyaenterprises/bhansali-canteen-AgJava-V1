package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.meals;
import com.abc.repository.GenericDAO;
import com.abc.repository.mealsRepository;
import com.abc.service.mealsService;

@Service
@Transactional
public class mealsServiceImpl implements mealsService
{

	@Autowired
	mealsRepository repo;
	
	@Autowired
	GenericDAO dao;
	
	@Override
	public List<meals> getAllmeals()
	{
		return (List<meals>) repo.findAll();
	}
	@Override
	public meals getmealsById(String mealCode)
	{
		return repo.findById(mealCode).orElse(null);
	}
	@Override
	public meals Save(meals meals)
	{
		return repo.save(meals);
	}
	@Override
	public List<meals> SaveAll(List<meals> meals)
	{
		return (List<meals>) repo.saveAll(meals);
	}
	@Override
	public void delete(String mealCode)
	{
		 repo.deleteById(mealCode);
	}
	@Override
	public void pullPunchData() {

		dao.RunProcedure("exec sp_store_punch_data", null);
	}
}
