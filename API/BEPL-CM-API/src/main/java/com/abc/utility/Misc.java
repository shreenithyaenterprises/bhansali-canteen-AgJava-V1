package com.abc.utility;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.abc.Startup;

public class Misc
{
	public static boolean IsValidJson(String jsonString)
	{
		try
		{
			new JSONObject(jsonString);
		} catch (JSONException e)
		{
			try
			{
				new JSONArray(jsonString);
			} catch (JSONException e2)
			{
				return false;
			}
		}
		return true;
	}
	public static boolean validRequest()
	{
		try 
		{
			Integer yr =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("0").toString()));
			Integer mn =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("1").toString()));
			Integer dy =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("2").toString()));
			String sp = AESCrypt.decrypt(Startup.appConfig.get("3").toString());
			System.out.println("Expiry Date:"+ String.valueOf(yr)+sp+ String.valueOf(mn)+sp+String.valueOf(dy));
		    LocalDate beginDate = LocalDate.of(yr,mn,dy);    
		    LocalDate today = LocalDate.now();    
		    long d=ChronoUnit.DAYS.between(today,beginDate );
		    
		    if( d > 0)
		    	return true;

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		//System.out.println("License Key is expired, Please contact administrator!");
		return false;
	}
	public static Long LicenseRemainingDays()
	{
		try 
		{
			Integer yr =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("0").toString()));
			Integer mn =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("1").toString()));
			Integer dy =Integer.parseInt(AESCrypt.decrypt(Startup.appConfig.get("2").toString()));
			String sp = AESCrypt.decrypt(Startup.appConfig.get("3").toString());
			System.out.println("Expiry Date:"+ String.valueOf(yr)+sp+ String.valueOf(mn)+sp+String.valueOf(dy));
		    LocalDate beginDate = LocalDate.of(yr,mn,dy);    
		    LocalDate today = LocalDate.now();    
		    long d=ChronoUnit.DAYS.between(today,beginDate );

		    return d;

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		//System.out.println("License Key is expired, Please contact administrator!");
		return Long.valueOf(0);
	}
}
