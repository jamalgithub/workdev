package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jamal.springDemo.domain.OrganisationCP;

/**
 * Hello world!
 *
 */
public class CPNameSpaceApp 
{
    public static void main( String[] args ){
    	//create the application context (container)
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");
        
        //create the beans
        OrganisationCP org = (OrganisationCP) ctx.getBean("myorg");
        
        System.out.println(org);                                       
        
        //close the application context (container)
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
