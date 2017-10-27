package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppAware 
{
    public static void main( String[] args ){
    	//create the application context (container)
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-aware.xml");
                
        //close the application context (container)
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
