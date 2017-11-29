package com.denofprogramming.service.audit;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AuditLogImpl implements AuditLog {

	
	private List<String> log = new ArrayList<String>();
		
	public void addMessage(String message) {
		
		final Date now = GregorianCalendar.getInstance().getTime();
		log.add(now.toString() + "+++" + message);
	}

	
	public void output() {
		System.out.println("---Audit Log-Start---");
		for(String audit : log){
			System.out.println(audit);
		}
		System.out.println("---Audit Log-End---");
	}

}
