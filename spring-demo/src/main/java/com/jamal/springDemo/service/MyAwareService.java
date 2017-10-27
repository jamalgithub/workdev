package com.jamal.springDemo.service;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class MyAwareService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware,
		BeanFactoryAware, BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		System.out.println("MyAwareService: setResourceLoader called");
		Resource resource = arg0.getResource("classpath:bean-aware.xml");
		System.out.println("MyAwareService: setResourceLoader:: Resource File Name=" + resource.getFilename());
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println("MyAwareService: setImportMetadata called");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("MyAwareService: setEnvironment called");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("MyAwareService: setBeanName called");
		System.out.println("MyAwareService: setBeanName:: Bean Name defined in context= " + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("MyAwareService: setBeanFactory called");
		System.out.println("MyAwareService: setBeanFactory:: myorg bean singleton= " + beanFactory.isSingleton("myorg"));
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("MyAwareService: setBeanClassLoader called");
		System.out.println("MyAwareService: setBeanClassLoader:: ClassLoader Name= " + classLoader.getClass().getName());
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("MyAwareService: setApplicationEventPublisher called");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("MyAwareService: setApplicationContext called");
		System.out.println("MyAwareService: setApplicationContext:: Bean Definition Names= " + Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}

}
