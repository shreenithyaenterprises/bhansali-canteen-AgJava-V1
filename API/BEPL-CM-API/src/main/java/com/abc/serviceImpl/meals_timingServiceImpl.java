package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.meals_timing;
import com.abc.repository.meals_timingRepository;
import com.abc.service.meals_timingService;

@Service
@Transactional
public class meals_timingServiceImpl implements meals_timingService
{

	@Autowired
	meals_timingRepository repo;
	
	@Override
	public List<meals_timing> getAllmeals_timing()
	{
		try {
			return (List<meals_timing>) repo.findAll(Sort.by(Direction.ASC, "siteCode"));
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public meals_timing getmeals_timingById(String meal_code)
	{
		return null;//repo.findByMealCode(meal_code).get();
	}
	@Override
	public meals_timing Save(meals_timing meals_timing)
	{
		return repo.save(meals_timing);
	}
	@Override
	public List<meals_timing> SaveAll(List<meals_timing> meals_timing)
	{
		return (List<meals_timing>) repo.saveAll(meals_timing);
	}
	@Override
	public void delete(meals_timing meals_timing)
	{
		try {
			repo.delete(meals_timing);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public List<meals_timing> getAllmealstimingBySite(String site) 
	{
		try 
		{
			return (List<meals_timing>) repo.findAllBySiteCode(site);
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
