package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abc.bean.payloadBean;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import com.abc.service.ReportService;

@RestController
@RequestMapping("/Report/")
public class ReportController implements CORSInterface
{
	@Autowired
	ReportService Rptservice;
	
	@PostMapping(value = "getSummaryReportbyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getSummaryReportbyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getSummaryReportbyDate<<<");
		try
		{
			if (pb.getSite().equals("-1"))
				pb.setSite(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getSummaryReportbyDate(pb.getFrom_date(), pb.getTo_date(), pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getExceptionReportbyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getExceptionReportbyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getExceptionReportbyDate<<<");
		System.out.println(pb.toString());
		try
		{
			if (pb.getDeptcode().equals("-1"))
				pb.setDeptcode(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getExceptionReportbyDate(pb.getFrom_date(), pb.getTo_date(), pb.getDeptcode(), pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Canteen Service Error");
		}
	}
	@PostMapping(value = "getDepartmentSummarybyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getDepartmentSummarybyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getDepartmentSummarybyDate<<<");
		System.out.println(pb.toString());
		try
		{
			if (pb.getDeptcode().equals("-1"))
				pb.setDeptcode(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDepartmentSummarybyDate(pb.getFrom_date(), pb.getTo_date(), pb.getDeptcode(),pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getContractorSummarybyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getContractorSummarybyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getDepartmentSummarybyDate<<<");
		System.out.println(pb.toString());
		try
		{
			if (pb.getDeptcode().equals("-1"))
				pb.setDeptcode(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDepartmentSummarybyDate(pb.getFrom_date(), pb.getTo_date(), pb.getDeptcode(),pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getDeptwiseCountbyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getDeptwiseCountbyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getDeptwiseCountbyDate<<<");
		System.out.println(pb.toString());
		try
		{
			if (pb.getDeptcode().equals("-1"))
				pb.setDeptcode(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDeptwiseCountbyDate(pb.getFrom_date(), pb.getTo_date(), pb.getDeptcode(), pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getPersonSummarybyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getPersonSummarybyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{

		System.out.println(pb.toString());
		try
		{
			if (pb.getEmp_code().equals("-1"))
				pb.setEmp_code(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getPersonSummarybyDate(pb.getFrom_date(), pb.getTo_date(), pb.getEmp_code(), pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getMealSummarybyDate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealSummarybyDate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealSummarybyDate<<<");
		System.out.println(pb.toString());
		try
		{
			if (pb.getCode().equals("-1"))
				pb.setCode(null);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getMealSummarybyDate(pb.getFrom_date(), pb.getTo_date(), pb.getCode(), pb.getSite()));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getDatewiseEmpMeals",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getDatewiseEmpMeals(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getDeptwiseCountbyDate<<<");
		System.out.println(pb.toString());
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDatewiseEmpMeals(pb));
		} catch (Exception e)
		{
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getMealAggregate",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealAggregate(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealAggregate<<<");
		System.out.println(pb.toString());
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getMealAggregateByDate(pb));
		} catch (Exception e)
		{
			//System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
//	@PostMapping(value = "getDaysofTheMonth",  produces = MediaType.APPLICATION_JSON_VALUE)
//	public ApiResponse<payloadBean> getDaysofTheMonth(@RequestBody payloadBean pb) throws Exception,ServiceException
//	{
//		System.out.println(">>>getDaysofTheMonth<<<");
//		System.out.println(pb.toString());
//		try
//		{
//			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDaysBetween(pb));
//		} catch (Exception e)
//		{
//			//System.out.println(e.toString());
//			throw new ServiceException("Head Count Service Error");
//		}
//	}
	@PostMapping(value = "getUnregisteredUser",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getUnregisteredUser(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getUnregisteredUser<<<");
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getUnregisteredUser(pb));
		} catch (Exception e)
		{
			throw new ServiceException("Canteen Service Error");
		}
	}
	@PostMapping(value = "getDatesBetweenfromAndTo",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getDaysofTheMonth(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getDatesbBetweenfromAndTo<<<");
		System.out.println(pb.toString());
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Records fetched.",Rptservice.getDatesbBetweenfromAndTo(pb));
		} catch (Exception e)
		{
			//System.out.println(e.toString());
			throw new ServiceException("Canteen Service Error");
		}
	}
}
