package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.abc.model.Device;


public interface DeviceRepository extends CrudRepository<Device, String> {

	@Query(nativeQuery = true, value="select * from mst_device where site_code =:site ")
	public List<Device> findAllBySiteCode(String site);
	
}