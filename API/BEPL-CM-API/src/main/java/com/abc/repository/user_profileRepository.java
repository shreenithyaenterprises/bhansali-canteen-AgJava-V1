package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abc.model.user_profile;

public interface user_profileRepository extends CrudRepository<user_profile, String> 
{
	
	public user_profile findByUseridAndPassword(String UserId, String password);
	
	@Query(nativeQuery = true, value=" select u.user_id,u.password,u.site,u.role,u.user_name,u.cmpy_code,r.role role_name,r.menu_text "
			+ " from user_profile u left join mst_role r on u.role=r.role_id where u.user_id=:userId and u.password=:password")
	public user_profile getUserDetails(String userId, String password);
	
	@Modifying
	@Query(nativeQuery = true, value="Update user_profile set password=:password, password_change=:change_flag where user_id=:user_id")
	public int ResetPassword(@Param("user_id") String user_id, @Param("password") String password, @Param("change_flag") int change_flag);


}