package com.denofprogramming.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MessagePrinterPointcuts {

	@Pointcut("execution(* com.denofprogramming.service.MessagePrinter.*(..))")
	//@Pointcut("execution(* com.denofprogramming.service.MessagePrinterImpl.printMessage(..))")
	//@Pointcut("execution(* com.denofprogramming.service.MessagePrinterImpl.printMessage(String, ..))")
	//@Pointcut("execution(public String com.denofprogramming.service.MessagePrinterImpl.*(..))")
	//@Pointcut("execution(* *.*(..))")
	public void loggingOperation() {}
	
	@Pointcut("execution(* com.denofprogramming.service.MessagePrinter.printAndReturnMessage(..))")
	public void auditOperation() {}
}
