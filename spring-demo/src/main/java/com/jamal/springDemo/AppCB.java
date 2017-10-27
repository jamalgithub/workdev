package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jamal.springDemo.domain.OrganisationCB;

/**
 * Hello world!
 *
 */
public class AppCB 
{
    public static void main( String[] args ){
    	//create the application context (container)
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cb.xml");
                
        //create the beans
        OrganisationCB org = (OrganisationCB) ctx.getBean("myorg");
        
        System.out.println(org);
        
        //close the application context (container)
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
