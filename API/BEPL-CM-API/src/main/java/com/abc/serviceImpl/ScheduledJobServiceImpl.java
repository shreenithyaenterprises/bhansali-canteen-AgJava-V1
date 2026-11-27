package com.abc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.repository.GenericDAO;
import com.abc.service.ScheduledJobService;

public class ScheduledJobServiceImpl implements ScheduledJobService
{
	@Autowired
	GenericDAO dao;
	
	@Override
	public int UpdateAttendance() {
		String sSQL="update a  set a.in_time= b.in_time, a.out_time=b.out_time,a.STATUS=b.punch_status,WORKHRS=b.work_hrs"
				+ " from workmen_muster a inner join vw_in_out_status b"
				+ " on a.CARD_NO=b.emp_code where convert(date,a.PUNCH_DATE)=dateadd(month,2,b.punch_date) ";
		int i=dao.ExecuteUpdate(sSQL);
		return i;
	}

	@Override
	public void GenerateMuster() {
		dao.RunProcedure("sp_gen_workmen_muster", null);
	}

}
