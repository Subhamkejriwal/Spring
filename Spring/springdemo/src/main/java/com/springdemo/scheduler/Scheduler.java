package com.springdemo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Scheduled(fixedDelay = 10000)
	public void scheduleTask() throws InterruptedException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

		String strDate = dateFormat.format(new Date());

		System.out.println("Hi! I've started running at - " + strDate);
		Thread.sleep(5000);
	}
}