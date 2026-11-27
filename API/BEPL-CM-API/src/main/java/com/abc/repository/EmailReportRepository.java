package com.abc.repository;

import org.springframework.data.repository.CrudRepository;
import com.abc.model.EmailReport;

public interface EmailReportRepository extends CrudRepository<EmailReport, Integer> {

}