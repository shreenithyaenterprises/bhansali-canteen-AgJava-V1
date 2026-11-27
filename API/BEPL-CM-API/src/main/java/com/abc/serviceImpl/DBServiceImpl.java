package com.abc.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bean.payloadBean;
import com.abc.repository.GenericDAO;
import com.abc.repository.meals_timingRepository;
import com.abc.service.DBService;

@Service
public class DBServiceImpl implements DBService
{

	@Autowired
	GenericDAO dao;
	
	@Autowired
	meals_timingRepository mtRepo;
	
	StringBuilder sb = new StringBuilder();
	
	@Override
	public List<Map<String, Object>> getSiteWiseCountByItem(payloadBean pb)
	{
		//int i=dao.RunProcedure("exec sp_punch_status", null);
		
//        sb.setLength(0);
//        sb.append("select ISNULL(site_name,'DS')site_name,ISNULL(site_code,'DS')site_code,sum(case when meal_code = 'BF' then 1 ELSE 0 end) BF,sum(case when meal_code = 'LN' then 1 ELSE 0 end) LN,sum(case when meal_code = 'SN' then 1 ELSE 0 end) SN,sum(case when meal_code = 'DN' then 1 ELSE 0 end) DN,sum(case when meal_code = 'MNS' then 1 ELSE 0 end) MNS,sum(case when meal_code = 'IC' then 1 ELSE 0 end) IC from Vw_Food_Punch_WOD WITH (NOLOCK) where punch_date = '"+ pb.getDate() +"' ");
//		if (!Objects.isNull(pb.getSite()))
//            sb.append("and site_code = '"+ pb.getSite() +"' ");
//		sb.append("group by site_name,site_code");
//		
//		return dao.getDataMap(sb.toString());
		
        return mtRepo.getSiteWiseCountByItem(pb.getSite(), pb.getDate());
		
	}

	@Override
	public List<Map<String, Object>> getMealsSummaryDaily(payloadBean pb)
	{
		//String sSQL="select count(*)meal_count,meal from Vw_Food_Punch where site_name is not null group by meal order by meal desc";
		//return dao.getDataMap(sSQL);
		return mtRepo.getMealsSummaryDaily(pb.getSite(), pb.getDate());
	}
	@Override
	public List<Map<String, Object>> getMealsSummaryMonthly(payloadBean pb)
	{
//		String sSQL="select ISNULL(catcode,'VND')catcode,"
//				+ "  sum(case when meal_code = 'BF' then 1 ELSE 0 end) BF,"
//				+ "  sum(case when meal_code = 'LN' then 1 ELSE 0 end) LN,"
//				+ "  sum(case when meal_code = 'SN' then 1 ELSE 0 end) SN,"
//				+ "  sum(case when meal_code = 'DN' then 1 ELSE 0 end) DN,"
//				+ "  sum(case when meal_code = 'UKN' then 1 ELSE 0 end) UKN"
//				+ "  from Vw_Food_Punch_Monthly group by catcode";
//		return dao.getDataMap(sSQL);
		if (pb.getRole().equalsIgnoreCase("0"))
			return mtRepo.getAllMealsSummaryMonthly();
		
		return mtRepo.getMealsSummaryMonthly(pb.getSite());
	}
	@Override
	public List<Map<String, Object>> getMealsDetail(payloadBean pb)
	{

		return mtRepo.getMealsDetail(pb.getMeal(), pb.getSite(), pb.getAreacode());//dao.getDataMap(sSQL);
	}
	@Override
	public List<Map<String, Object>> getMealsDetailMonthly(payloadBean pb)
	{
		
		return mtRepo.getMealsDetailMonthly(pb.getSite(), pb.getCatcode());//dao.getDataMap(sSQL);
	}
	@Override
	public List<Map<String, Object>> getIOCountDeptWise()
	{
		String sSQL="select v.punch_date,e.DEPTCODE,d.DEPARTMENT ,SUM(v.OUT_COUNT)out_count,SUM(v.IN_COUNT)in_count,SUM(v.IN_COUNT)-SUM(v.OUT_COUNT)inside from "
				+ "	vw_Punch_status v left join EMPLOYEE e on  v.emp_code=e.ENROLMENT_NUMBER "
				+ "	left join DEPARTMENT d on  e.DEPTCODE=d.DEPTCODE group by punch_date,e.DEPTCODE,d.DEPARTMENT ";
		return dao.getDataMap(sSQL);
	}

	@Override
	public List<Map<String, Object>> getIOCountContWise()
	{
		String sSQL="select v.punch_date,e.CONTCODE,C.CONTNAME ,SUM(v.OUT_COUNT)out_count,SUM(v.IN_COUNT)in_count,SUM(v.IN_COUNT)-SUM(v.OUT_COUNT)inside from "
				+ "	vw_Punch_status v left join EMPLOYEE e on  v.emp_code=e.ENROLMENT_NUMBER "
				+ "	left join CONTRACTOR c on  e.CONTCODE=c.CONTCODE group by punch_date,e.CONTCODE,C.CONTNAME ";
		return dao.getDataMap(sSQL);
	}

	@Override
	public List<Map<String, Object>> getIODetail(String areacode, String deptcode, String contcode, String shiftcode)
	{
		String sSQL="select * from vw_punch_detail_view where ";
		return null;//emRepo.getIODetail(areacode,deptcode,contcode,shiftcode);//dao.getDataMap(sSQL);
	}

	@Override
	public List<Map<String, Object>> getSummaryReportbyDate(String from_date, String to_date)
	{

		String sSQL="select p.punch_date,p.EmployeesCode emp_code,e.name,ISNULL(e.site,'OTH') emp_site,ISNULL(e.catcode,'UKN')catcode,p.terminal_alias,p.punch_time,p.punch_date_time,p.punch_status,p.IP device_ip,"
				+ " s.site_name,d.areacode,area_description,d.site_code,ISNULL(m.meal_code,'UKN')meal_code,m.shift_code,ISNULL(m.meal_name,'UKN') meal,  \r\n"
				+ " CASE WHEN e.CATCODE='VDR' THEN 'VDR' ELSE 'EMP' END emp_type  "
				+ " from Parallel p   "
				+ " left join mst_device d on p.ip=d.ip_address "
				+ " left join EMPLOYEE e on e.ENROLMENT_NUMBER=p.EmployeesCode "
				+ " left join mst_site s on s.site_code=d.site_code "
				+ " left join meals_timing m on CONVERT(VARCHAR(5),CAST(p.Punch_time AS TIME), 108) between  Convert(time,m.time_range_from) and Convert(time,m.time_range_to) and d.SITE_CODE=m.site_code "
				+ " where Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' ";
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL); 
	}

	@Override
	public List<Map<String, Object>> getSummaryData(String status)
	{
		String sSQL="select P.emp_code EmployeesCode,e.name,p.Punch_date,p.Punch_time,p.Punch_Status  from punch_summary p left join EMPLOYEE e on e.ENROLMENT_NUMBER=p.emp_code where (in_count =1  or out_count = 1) and punch_status like '"+ status +"%'  and punch_date = convert(date,getdate()) order by Convert(time,Punch_time) desc";
		return dao.getDataMap(sSQL);
	}
	@Override
	public List<Map<String, Object>> getIOMissing(String status)
	{
		String sSQL="SELECT punch_date,punch_time,last_punch_time,emp_code,e.name,last_punch_status,RN,d.DEPARTMENT,c.CONTNAME FROM ( "
				+ "SELECT punch_date,punch_time,PUNCH_DATE_TIME AS last_punch_time,EMPLOYEESCODE emp_code,PUNCH_STATUS last_punch_status,ROW_NUMBER() OVER (PARTITION BY EMPLOYEESCODE  "
				+ "ORDER BY convert(time, PUNCH_TIME) ASC ) RN "
				+ "FROM PARALLEL where convert(date,Punch_date)=convert(date,getdate()) "
				+ ") a left join employee e on e.ENROLMENT_NUMBER=a.emp_code "
				+ "left join DEPARTMENT d on e.DEPTCODE =d.DEPTCODE "
				+ "left join CONTRACTOR c on e.CONTCODE =c.CONTCODE "
				+ "where RN=1 and last_punch_status not like 'In%' and emp_code not in (select emp_code from punch_summary where Convert(date,Punch_date)=Convert(date,getdate()-1)  and punch_status like 'In%' and punch_time between '21:30:00' and '22:30:00') "
				+ "order by punch_time desc";
		return dao.getDataMap(sSQL);
	}
	@Override
	public List<Map<String, Object>> getInsideData(String status)
	{
		
		String sSQL="select emp_code EmployeesCode,RN, Punch_time,Punch_date,last_punch_status Punch_Status, e.name from vw_last_Punch_status p left join EMPLOYEE e on e.ENROLMENT_NUMBER=p.emp_code "
				+ "where Convert(date,Punch_date)=Convert(date,getdate()) and p.RN =1 and last_punch_status like 'In%' "
				+ "union "
				+ "select emp_code EmployeesCode,RN, Punch_time,Punch_date,Punch_Status, e.name from punch_summary p left join EMPLOYEE e on e.ENROLMENT_NUMBER=p.emp_code "
				+ "where Convert(date,Punch_date)=Convert(date,getdate()-1) and p.RN =1 and punch_status like 'In%' "
				+ "and punch_time between '21:30:00' and '22:30:00' and CONVERT (Time, GETDATE()) between '00:00:00' and '06:00' order by punch_time desc";
		return dao.getDataMap(sSQL);
	}


}
