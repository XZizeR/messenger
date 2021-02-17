package com.nick.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component
public class EventImplJob implements Runnable{
	
	@Override
	public void run() {
		while (true) {
			try {
				
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
