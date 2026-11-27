package com.abc.repository;

import org.springframework.data.repository.CrudRepository;
import com.abc.model.Contractor;

public interface contractorRepository extends CrudRepository<Contractor, String> {

}