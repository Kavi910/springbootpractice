package com.example.springbootpratice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	/*
	 * @Scheduled(cron = "0 0/1 * 1/1 * ? *") public void cronJobSch() {
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); Date
	 * now = new Date(); String strDate = sdf.format(now);
	 * System.out.println("Java cron job expression:: " + strDate); }
	 * 
	 */	 @Scheduled(fixedRate = 20000)
	 public void fixedRateSch() { 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Rate scheduler:: " + strDate);
	 }

	 @Scheduled(fixedDelay = 40000, initialDelay = 3000)
	   public void fixedDelaySch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Delay scheduler:: " + strDate);
	   }
}
