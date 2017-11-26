package com.jamal.springDemo.service.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

import com.jamal.springDemo.domain.OrganisationCB;

public class CheckerPostProcessor implements BeanPostProcessor, PriorityOrdered {
	private int order = 0;
	
	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof OrganisationCB) {
			OrganisationCB org = (OrganisationCB) bean;
			System.out.println("CheckerBeanPostProcessor-->BeforeInitialization : " + beanName	+ " contains: " + org.toString());
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof OrganisationCB) {
			OrganisationCB org = (OrganisationCB) bean;
			System.out.println("CheckerBeanPostProcessor-->AfterInitialization : " + beanName	+ " contains: " + org.toString());
		}
		return bean;
	}

}
