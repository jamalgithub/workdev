package com.tutorialspoint.pojo;

public class MessageUtil {
   private String message;
  
   public MessageUtil(String message){
      this.message = message;
   }
      
   public String printMessage(){
      System.out.println(message);
      return message;
   }     
   
   public String salutationMessage(){
      message = "Hi!" + message;
      System.out.println(message);
      return message;
   }
   
   public void printMessageLoop(){
      System.out.println(message);
      while(true);
   }
   
   public void printMessageException(){
      System.out.println(message);
      int a =0;
      @SuppressWarnings("unused")
      int b = 1/a;
   }
}