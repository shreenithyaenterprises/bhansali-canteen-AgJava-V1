package com.abc.repository;

import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import com.abc.model.emergency;

public interface emergencyRepository extends CrudRepository<emergency, Date> {

}