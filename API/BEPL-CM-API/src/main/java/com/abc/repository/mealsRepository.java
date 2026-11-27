package com.abc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.abc.model.meals;

public interface mealsRepository extends CrudRepository<meals, String> {

	@Query(value = "{CALL sp_store_punch_data}", nativeQuery = true)
	public void pullPunchData();
}