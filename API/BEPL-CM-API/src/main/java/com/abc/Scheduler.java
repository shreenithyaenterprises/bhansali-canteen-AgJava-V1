package com.abc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.abc.service.mealsService;

@Component
public class Scheduler 
{
	@Autowired
	mealsService mlService;
	
    @Scheduled(cron = "${cron.scheduled.datapull}")
    public void cronJobSch() 
    {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      System.out.println("Java cron job expression:: " + strDate);
      mlService.pullPunchData();
    }
}