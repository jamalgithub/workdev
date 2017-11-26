package com.denofprogramming.service.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

import com.denofprogramming.service.MessageOfTheDayService;

public class MessageCheckerPostProcessor implements BeanPostProcessor, PriorityOrdered {

	private int order = 0;

	public int getOrder() {
		return order;
	}

	public void setOrder(final int order) {
		this.order = order;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof MessageOfTheDayService) {
			final MessageOfTheDayService service = (MessageOfTheDayService) bean;
			if (!"".equals(service.getMessage()))
				System.out.println("MessageCheckerBeanPostProcessor-->BeforeInitialization : " + beanName
						+ " contains: " + service.getMessage());
		}

		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof MessageOfTheDayService) {
			final MessageOfTheDayService service = (MessageOfTheDayService) bean;
			if (!"".equals(service.getMessage()))
				System.out.println("MessageCheckerBeanPostProcessor-->AfterInitialization : " + beanName
						+ " contains: " + service.getMessage());
		}
		return bean;
	}

}
