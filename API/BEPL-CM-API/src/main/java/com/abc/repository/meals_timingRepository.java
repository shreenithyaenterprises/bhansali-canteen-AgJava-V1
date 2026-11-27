package com.abc.repository;


import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.model.Meal_timing_Id;
import com.abc.model.meals_timing;

@Repository
public interface meals_timingRepository extends JpaRepository<meals_timing, Meal_timing_Id> {

	public List<meals_timing> findAllBySiteCode(String site);
	
	@Query(nativeQuery = true, value="select ISNULL(site_name,'DS')site_name,ISNULL(site_code,'DS')site_code,sum(case when meal_code = 'BF' then 1 ELSE 0 end) BF,sum(case when meal_code = 'LN' then 1 ELSE 0 end) LN,sum(case when meal_code = 'SN' then 1 ELSE 0 end) SN,sum(case when meal_code = 'DN' then 1 ELSE 0 end) DN,sum(case when meal_code = 'MNS' then 1 ELSE 0 end) MNS,sum(case when meal_code = 'IC' then 1 ELSE 0 end) IC from Vw_Food_Punch_WOD WITH (NOLOCK) where punch_date = convert(date,:PDate) and (:site_code is null or site_code = :site_code)  group by site_name,site_code")
	public List<Map<String, Object>>  getSiteWiseCountByItem(String site_code, String PDate);	

	@Query(nativeQuery = true, value="select count(*)meal_count,ISNULL(meal,'UKN')meal from Vw_Food_Punch_WOD where punch_date = convert(date,:PDate) and (:site_code IS NULL OR site_code=:site_code) group by meal order by meal desc")
	public List<Map<String, Object>>  getMealsSummaryDaily(@Param("site_code") String site_code, @Param("PDate") String PDate);	
	
	@Query(nativeQuery = true, value="select catcode,category,sum(case when meal_code = 'BF' then 1 ELSE 0 end) BF,sum(case when meal_code = 'LN' then 1 ELSE 0 end) LN,sum(case when meal_code = 'SN' then 1 ELSE 0 end) SN,sum(case when meal_code = 'DN' then 1 ELSE 0 end) DN,sum(case when meal_code = 'MNS' then 1 ELSE 0 end) MNS,sum(case when meal_code = 'IC' then 1 ELSE 0 end) IC,sum(case when meal_code = 'UKN' then 1 ELSE 0 end) UKN from Vw_Food_Punch_Monthly WITH (NOLOCK) where (:site_code IS NULL OR site_code=:site_code) group by catcode,category")
	public List<Map<String, Object>>  getMealsSummaryMonthly(@Param("site_code") String site_code);

	@Query(nativeQuery = true, value="select site_code,site_name,sum(case when meal_code = 'BF' then 1 ELSE 0 end) BF,sum(case when meal_code = 'LN' then 1 ELSE 0 end) LN,sum(case when meal_code = 'SN' then 1 ELSE 0 end) SN,sum(case when meal_code = 'DN' then 1 ELSE 0 end) DN,sum(case when meal_code = 'MNS' then 1 ELSE 0 end) MNS,sum(case when meal_code = 'IC' then 1 ELSE 0 end) IC,sum(case when meal_code = 'UKN' then 1 ELSE 0 end) UKN from Vw_Food_Punch_Monthly WITH (NOLOCK) group by site_code,site_name")
	public List<Map<String, Object>>  getAllMealsSummaryMonthly();

    @Query(value = "{CALL dbo.sp_emp_date_meal_summary(:from_date, :to_date, :site)}", nativeQuery = true)
	//@Query(nativeQuery = true, value="select * from Monthly_Meals_Summary")
	public List<Map<String, Object>>  getDatewiseEmpMeals(String from_date, String to_date, String site);

	//	@Query(nativeQuery = true, value="select dept_code,department, SUM(CASE WHEN meal_code='BF' THEN 1 ELSE 0 END)breakfast,"
//			+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END)lunch,SUM(CASE WHEN meal_code='SN' THEN 1 ELSE 0 END)snacks,"
//			+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END)dinner,SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END)tea,"
//			+ " SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END)uc from Vw_Food_Punch_WOD where "
//			+ " Convert(date,Punch_date) between  :from_date and :to_date and (:dept_code IS NULL OR dept_code=:dept_code) group by dept_code,department order by department")
//	public List<Map<String, Object>>  getDeptwiseCountbyDate(@Param("dept_code") String dept_code, @Param("from_date") String from_date, @Param("to_date") String to_date);

	
	
	
	@Query(nativeQuery = true, value="select * from Vw_Food_Punch WITH (NOLOCK) where (:meal_code IS NULL OR meal_code=:meal_code) AND (:site_code IS NULL OR site_code=:site_code) AND (:areacode IS NULL OR areacode=:areacode) order by punch_time desc")
	public List<Map<String, Object>>  getMealsDetail(@Param("meal_code") String meal_code, @Param("site_code") String site_code, @Param("areacode") String areacode);	

	@Query(nativeQuery = true, value="select * from Vw_Food_Punch_Monthly where (:site_code IS NULL OR site_code=:site_code) AND (:catcode IS NULL OR catcode=:catcode) order by punch_date, punch_time asc")
	public List<Map<String, Object>>  getMealsDetailMonthly(@Param("site_code") String site_code, @Param("catcode") String catcode);	

}