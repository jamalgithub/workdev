package com.denofprogramming.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.denofprogramming.service.audit.AuditLog;

@Component
@Aspect
public class AuditIntroduction {

	@DeclareParents(value = "com.denofprogramming.service.*MessagePrinterImpl", defaultImpl = com.denofprogramming.service.audit.AuditLogImpl.class)
	public AuditLog auditLog;
	
}
