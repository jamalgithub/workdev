package com.tutorialspoint.junit;
import org.junit.Test;
import com.tutorialspoint.pojo.MessageUtil;

import static org.junit.Assert.assertEquals;

public class TestJunit2 {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
 
   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + message;
      assertEquals(message,messageUtil.salutationMessage());
   }
}