package com.abc.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bean.payloadBean;
import com.abc.repository.GenericDAO;
import com.abc.repository.meals_timingRepository;
import com.abc.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService
{
	@Autowired
	meals_timingRepository mtRepo;
	@Autowired
	GenericDAO dao;
	StringBuilder sSQL = new StringBuilder();
	@Override
	public List<Map<String, Object>> getSummaryReportbyDate(String from_date, String to_date, String site)
	{
		 sSQL.setLength(0);
//		String sSQL="select p.punch_date,p.EmployeesCode emp_code,e.name,ISNULL(e.site,'OTH') emp_site,ISNULL(e.catcode,'UKN')catcode,p.terminal_alias,p.punch_time,p.punch_date_time,p.punch_status,p.IP device_ip,"
//				+ " s.site_name,d.areacode,area_description,d.site_code,ISNULL(m.meal_code,'UKN')meal_code,m.shift_code,ISNULL(m.meal_name,'UKN') meal,  "
//				+ " CASE WHEN e.CATCODE='VDR' THEN 'VDR' ELSE 'EMP' END emp_type  "
//				+ " from Parallel p   "
//				+ " left join mst_device d on p.ip=d.ip_address "
//				+ " left join EMPLOYEE e on e.ENROLMENT_NUMBER=p.EmployeesCode "
//				+ " left join mst_site s on s.site_code=d.site_code "
//				+ " left join meals_timing m on CONVERT(VARCHAR(5),CAST(p.Punch_time AS TIME), 108) between  Convert(time,m.time_range_from) and Convert(time,m.time_range_to) and d.SITE_CODE=m.site_code "
//				+ " where Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' and site";
		
		sSQL.append("select * from Vw_Food_Punch_WOD  WITH (NOLOCK) where Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' ");		
		if (!Objects.isNull(site))
			sSQL.append("and site_code = '" + site + "'");
		
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString()); 
	}
	@Override
	public List<Map<String, Object>> getExceptionReportbyDate(String from_date, String to_date, String dept, String site) {
		 sSQL.setLength(0);
		 sSQL.append("select * from Vw_Food_Punch_WOD  WITH (NOLOCK) where meal_code is null and meal is null and "
				+ "  Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"'  and (dept_code = '" + dept + "' or "+ dept +" is null) ");
		if (!Objects.isNull(site))
			sSQL.append("and site_code ='"+ site +"' ");
		
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override
	public List<Map<String, Object>> getDepartmentSummarybyDate(String from_date, String to_date, String dept, String site) {
		 sSQL.setLength(0);
//		 sSQL.append("select emp_code,name,punch_date,dept_code,department, CASE WHEN meal_code='BF' THEN 1 ELSE 0 END breakfast,"
//				+ " CASE WHEN meal_code='LN' THEN 1 ELSE 0 END lunch,CASE WHEN meal_code='SN' THEN 1 ELSE 0 END snacks,"
//				+ " CASE WHEN meal_code='DN' THEN 1 ELSE 0 END dinner,CASE WHEN meal_code='TE' THEN 1 ELSE 0 END tea,"
//				+ " CASE WHEN meal_code is null THEN 1 ELSE 0 END uc"
//				+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where"
//				+ " Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' and (dept_code = '" + dept + "' or "+ dept +" is null) ");

		 sSQL.append("select emp_code,name,category,department,division_name,contname,punch_date,dept_code,department, SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END) TEA,"
					+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END) lunch,"
					+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END) dinner, SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END) uc"
					+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where"
					+ " Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' and (dept_code = '" + dept + "' or "+ dept +" is null) ");

		if (!Objects.isNull(site))
			sSQL.append("and site_code= '"+ site +"'");
	
		sSQL.append("GROUP BY emp_code,name,category,department,division_name,contname,punch_date,dept_code,department");
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override
	public List<Map<String, Object>> getDeptwiseCountbyDate(String from_date, String to_date, String dept, String site) {
		sSQL.setLength(0);
		sSQL.append("select dept_code,department, SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END)TEA,"
				+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END)lunch,SUM(CASE WHEN meal_code='SN' THEN 1 ELSE 0 END)snacks,"
				+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END)dinner,SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END)uc"
				+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where"
				+ " Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' and (dept_code = '" + dept + "' or "+ dept +" is null) ");
		
		if (!Objects.isNull(site))
			sSQL.append("and site_code= '"+ site +"'");
		sSQL.append(" group by dept_code,department order by department");
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());//mtRepo.getDeptwiseCountbyDate(dept, from_date, to_date); //
	}
	@Override
	public List<Map<String, Object>> getPersonSummarybyDate(String from_date, String to_date, String code, String site) {
		sSQL.setLength(0);
		sSQL.append("select punch_date,emp_code,name,department,category,division_name,contname, SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END)TEA,"
				+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END)lunch,"
				+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END)dinner,SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END)uc"
				+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where "
				+ " Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' and (emp_code = '" + code + "' or "+ code +" is null) ");
		
		if (!Objects.isNull(site))
			sSQL.append("and site_code= '"+ site +"'");
		
		sSQL.append(" group by punch_date,emp_code,name,department,category,division_name,contname ");
		
		if (!Objects.isNull(site))
			sSQL.append(",site_code");
		
		sSQL.append(" order by punch_date");
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override
	public List<Map<String, Object>> getMealSummarybyDate(String from_date, String to_date, String code, String site) {
		sSQL.setLength(0);
		sSQL.append("select punch_date,punch_time,emp_code,name,department,category,division_name,contname,meal_code,meal, SUM(CASE WHEN  meal_code='LN' THEN 1"
				+ " WHEN meal_code='TE' THEN 1 WHEN meal_code='DN' THEN 1 ELSE 1 END) meal_count"
				+ " from Vw_Food_Punch_WOD WITH (NOLOCK) where"
				+ " Convert(date,Punch_date) between '"+ from_date +"' and '"+ to_date +"' ");
		
		if (!Objects.isNull(site))
			sSQL.append("and site_code= '"+ site +"'");
		if (!Objects.isNull(code))
			sSQL.append("and meal_code= '"+ code +"'");
		
		sSQL.append(" group by punch_date,punch_time,emp_code,name,department,category,division_name,contname,meal_code,meal order by punch_date, name");
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}

	@Override
	public List<Map<String, Object>> getDatewiseEmpMeals(payloadBean pb) {
			
		return mtRepo.getDatewiseEmpMeals(pb.getFrom_date(),pb.getTo_date(), pb.getSite());
	}
	@Override
	public List<Map<String, Object>> getMealAggregateByDate(payloadBean pb) {
		sSQL.setLength(0);
		
		if(pb.getCatcode().equals("-1")) 
		{
			pb.setCatcode(null);
		}
		else 
		{
			pb.setCatcode("'"+pb.getCatcode()+"'");
		}
			
		if (pb.getRole().equals("0")) 
		{
			sSQL.append("select Convert(varchar(11),punch_date,106)punch_date, "
					+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END) lunch, "
					+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END) dinner,SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END) tea, "
					+ " SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END) uc, "
					+ " SUM(CASE WHEN meal_code IS NOT NULL THEN 1 ELSE 1 END) meal_count "
					+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where Convert(date,Punch_date) between '"+ pb.getFrom_date() +"' and '"+ pb.getTo_date() +"'"
					+ " and ("+ pb.getCatcode() +" is null or emp_type="+ pb.getCatcode() +")"
					+ " GROUP BY punch_date "
					+ " UNION ALL "
					+ " select 'Total' punch_date, "
					+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END) lunch, "
					+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END) dinner,SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END) tea, "
					+ " SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END) uc, "
					+ " SUM(CASE WHEN meal_code IS NOT NULL THEN 1 ELSE 1 END) meal_count "
					+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where Convert(date,Punch_date) between '"+ pb.getFrom_date() +"' and '"+ pb.getTo_date() +"'"
					+ " and ("+ pb.getCatcode() +" is null or emp_type="+ pb.getCatcode() +")"
					+ "order by punch_date");

		} else
		{
			sSQL.append("select Convert(varchar(11),punch_date,106)punch_date, "
					+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END) lunch, "
					+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END) dinner,SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END) tea, "
					+ " SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END) uc, "
					+ " SUM(CASE WHEN meal_code IS NOT NULL THEN 1 ELSE 1 END) meal_count "
					+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where Convert(date,Punch_date) between '"+ pb.getFrom_date() +"' and '"+ pb.getTo_date() +"' and site_code='"+ pb.getSite() +"'"
					+ " and ("+ pb.getCatcode() +" is null or emp_type="+ pb.getCatcode() +")"
					+ " GROUP BY punch_date "
					+ " UNION ALL " 
					+ " select 'Total' punch_date, "
					+ " SUM(CASE WHEN meal_code='LN' THEN 1 ELSE 0 END) lunch, "
					+ " SUM(CASE WHEN meal_code='DN' THEN 1 ELSE 0 END) dinner,SUM(CASE WHEN meal_code='TE' THEN 1 ELSE 0 END) tea, "
					+ " SUM(CASE WHEN meal_code is null THEN 1 ELSE 0 END) uc, "
					+ " SUM(CASE WHEN meal_code IS NOT NULL THEN 1 ELSE 1 END) meal_count "
					+ " from Vw_Food_Punch_WOD  WITH (NOLOCK) where Convert(date,Punch_date) between '"+ pb.getFrom_date() +"' and '"+ pb.getTo_date() +"' and site_code='"+ pb.getSite() +"'"
					+ " and ("+ pb.getCatcode() +" is null or emp_type="+ pb.getCatcode() +")"
					+ "order by punch_date");
		}
		
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override //not in use
	public List<Map<String, Object>> getDaysofTheMonth(payloadBean pb) 
	{
		String sSQL="WITH numbers "
				+ "as ("
				+ "    Select 1 as value"
				+ "    Union ALL "
				+ "    Select value + 1 from numbers "
				+ "    where value + 1 <= Day(EOMONTH(datefromparts("+pb.getYear()+","+ pb.getMonth()+ ",1)))"
				+ ") SELECT datefromparts("+ pb.getYear() +","+ pb.getMonth() +",numbers.value) dates FROM numbers";
		 
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override
	public Stream<LocalDate> getDaysBetween(payloadBean pb) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(pb.getFrom_date(), dateFormat);
		LocalDate endDate = LocalDate.parse(pb.getTo_date(), dateFormat).plusDays(1);
		return IntStream.range(0, (int) ChronoUnit.DAYS.between(startDate, endDate)).mapToObj(startDate::plusDays);

	}
	@Override
	public List<Map<String, Object>> getUnregisteredUser(payloadBean pb) {

		String sSQL="select * from vw_unRegisteredUser where site_code='"+ pb.getSite()+"'";
		 
		System.out.println(sSQL);
		return  dao.getDataMap(sSQL.toString());
	}
	@Override
	public Stream<LocalDate> getDatesbBetweenfromAndTo(payloadBean pb) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(pb.getFrom_date(), dateFormat);
		LocalDate endDate = LocalDate.parse(pb.getTo_date(), dateFormat).plusDays(1);
		return IntStream.range(0, (int) ChronoUnit.DAYS.between(startDate, endDate)).mapToObj(startDate::plusDays);

	}
	
}
