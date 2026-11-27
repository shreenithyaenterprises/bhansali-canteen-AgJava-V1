package com.abc.repository;

import org.springframework.data.repository.CrudRepository;
import com.abc.model.AppConfig;

public interface AppConfigRepository extends CrudRepository<AppConfig, Integer> {

}