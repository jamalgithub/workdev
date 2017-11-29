package com.denofprogramming.service.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

import com.denofprogramming.service.MessagePrinterImpl;

public class PrinterCheckerPostProcessor implements BeanPostProcessor, PriorityOrdered {

	private int order = 0;

	public int getOrder() {
		return order;
	}

	public void setOrder(final int order) {
		this.order = order;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof MessagePrinterImpl) {
			System.out.println("PrinterCheckerPostProcessor-->BeforeInitialization : " + beanName);
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof MessagePrinterImpl) {
			System.out.println("PrinterCheckerPostProcessor-->AfterInitialization : " + beanName);
		}
		return bean;
	}

}
