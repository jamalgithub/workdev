package com.tutorialspoint.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestFixtures extends TestCase {
   protected int value1, value2;
   double result;
   
   @Override
   protected void setUp(){     
      System.out.println("-------- Before the test --------");
      System.out.println("value1="+value1+", value2="+value2+", result="+result);
   }

   	@Override
	protected void tearDown() throws Exception {		
   		System.out.println("-------- After the test --------");
        System.out.println("value1="+value1+", value2="+value2+", result="+result);
	}

   	// test method
   public void testAdd1(){
	   System.out.println("-------- Within test testAdd1() --------");
	   value1=3;
	   value2=5;
	   result= value1 + value2;
	   assertTrue(result == 8);
   }
   
   @Test
   public void testAdd2() {
	   System.out.println("-------- Within test testAdd2() --------");
      //count the number of test cases
      System.out.println("No of Test Case = "+ this.countTestCases());
		
      //test getName 
      String name= this.getName();
      System.out.println("Test Case Name = "+ name);

      //test setName
      this.setName("testNewAdd");
      String newName= this.getName();
      System.out.println("Updated Test Case Name = "+ newName);
   }
}