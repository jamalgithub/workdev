package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jamal.springDemo.domain.HumanResourceDept;
import com.jamal.springDemo.domain.OrganisationDI;

/**
 * Hello world!
 *
 */
public class AppDI 
{
    public static void main( String[] args ){
    	//create the application context (container)
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
    	//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-di.xml");
        
        //create the beans
        OrganisationDI org = (OrganisationDI) ctx.getBean("myorg");
        OrganisationDI org2 = (OrganisationDI) ctx.getBean("myorg");
        HumanResourceDept hddept = (HumanResourceDept) ctx.getBean("myhrdept");
        
        org2.setPostalCode("52458");
        
        //invoke the bean methode
        System.out.println(org.corporateSlogan());
        
        //Print the bean details
        System.out.println(org);        
        System.out.println(org2);
        
        if(org == org2) {
        	System.out.println("Singleton scope test: org and org2 point to the same instance.");
        }else {
        	System.out.println("Prototype scope test: org and org2 are separate instances.");
        }
                
        System.out.println(hddept.hiringStatus(5000));
                
        //close the application context (container)
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
