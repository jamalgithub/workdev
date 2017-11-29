package com.denofprogramming.service.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.denofprogramming.service.audit.AuditLog;

@Component
@Aspect
public class MessagePrinterLoggingAspect {

	
	
	@Before("MessagePrinterPointcuts.loggingOperation()")
	public void logBefore(final JoinPoint joinPoint) {
		
		System.out.println("The method " + joinPoint.getSignature() + " before");
	}
	
	@After("MessagePrinterPointcuts.loggingOperation()")
	public void logAfter(final JoinPoint joinPoint) {
		
		System.out.println("The method " + joinPoint.getSignature() + " after");
	}
	
	@AfterReturning(pointcut="MessagePrinterPointcuts.loggingOperation()", returning="result")
	public void logAfterReturning(final JoinPoint joinPoint, Object result) {
		
		System.out.println("The method " + joinPoint.getSignature() + " after-returning");
		System.out.println("result = " + result);
	}
	
	@AfterThrowing(pointcut="MessagePrinterPointcuts.loggingOperation()", throwing="ex")
	public void logAfterthrowing(final JoinPoint joinPoint, Throwable ex) {
		
		System.out.println("The method " + joinPoint.getSignature() + " after-throwing");
		System.out.println("exception = " + ex);
	}
	
	@Around("MessagePrinterPointcuts.loggingOperation()")
	public Object logAround(final ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("kind: " +joinPoint.getKind());
		System.out.println("sign declaring type: " +joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("sign name: " +joinPoint.getSignature().getName());
		System.out.println("args: " +Arrays.toString(joinPoint.getArgs()));
		System.out.println("target: " + joinPoint.getTarget().getClass().getName());
		System.out.println("this: " + joinPoint.getThis().getClass().getName());
		
		System.out.println("The method " + joinPoint.getSignature() + " Around-before");
		//final String result = (String) joinPoint.proceed();
		final Object result = joinPoint.proceed();
		System.out.println("The method " + joinPoint.getSignature() + " Around-after : " + result);
		
		return result;
	}
	
	@AfterReturning(pointcut="MessagePrinterPointcuts.auditOperation()", returning="result")
	public void audit(final JoinPoint jointPoint,  final String result) {
		final AuditLog auditLog = (AuditLog) jointPoint.getThis();
		auditLog.addMessage(result);
	}
}
