package com.denofprogramming.service.audit;

public interface AuditLog {

	
	void addMessage(final String message);
	
	void output();
	
}
