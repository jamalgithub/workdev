package com.denofprogramming.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.denofprogramming.service.audit.Counter;
import com.denofprogramming.service.audit.CounterImpl;

@Component
@Aspect
public class CounterIntroduction {

	@DeclareParents(value = "com.denofprogramming.service.*MessagePrinterImpl", defaultImpl = CounterImpl.class)
	public Counter counter;
}
