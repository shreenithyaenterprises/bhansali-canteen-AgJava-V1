package com.abc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abc.model.EMContact;


@Repository
public interface EMContactRepository  extends CrudRepository<EMContact, Integer>
{
	@Query(nativeQuery = true, value="select * from Vw_EmergencyController ")
	public List<Map<String, Object>>  getAllEMContact();
	
	@Query(nativeQuery = true, value="select * from vw_punch_detail_view where (:areacode IS NULL OR areacode=:areacode) AND (:deptcode IS NULL OR deptcode=:deptcode) AND (:contcode IS NULL OR contcode=:contcode) AND (:shiftcode IS NULL OR shift_code=:shiftcode) order by punch_time desc")
	public List<Map<String, Object>>  getIODetail(@Param("areacode") String areacode, @Param("deptcode") String deptcode, @Param("contcode") String contcode, @Param("shiftcode") String shiftcode);	
	

}
