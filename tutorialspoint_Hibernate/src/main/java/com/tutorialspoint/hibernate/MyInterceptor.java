package com.tutorialspoint.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class MyInterceptor extends EmptyInterceptor { 

	// This method is called before an object is deleted.
   public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) { 
	   if ( entity instanceof Emp )
	          System.out.println("Delete Operation");
   } 
 
   // This method is called when an object gets updated. 
   public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, 
                     String[] propertyNames, Type[] types) { 
       if ( entity instanceof Emp ) { 
          System.out.println("Update Operation");
          for ( int i=0; i < propertyNames.length; i++ ) {
              if ( "date".equals( propertyNames[i] ) ) {
            	  currentState[i] = new Date();
                  return true;
              }
          }
          return true;  
       } 
       return false; 
   } 
   
   // This method is called before an object is initialized. 
   public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) { 
	   if ( entity instanceof Emp ) { 
	          System.out.println("Initialize Operation"); 
	          return true;  
	   } 
       return true; 
   } 
   
   // This method is called when an object gets created ( before it is saved ). 
   public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) { 
       if ( entity instanceof Emp ) { 
          System.out.println("Create Operation");
          for ( int i=0; i < propertyNames.length; i++ ) {
              if ( "date".equals( propertyNames[i] ) ) {
                  state[i] = new Date();
                  return true;
              }
          }
          return true;  
       } 
       return false; 
   } 
   
   //called before commit into database 
   public void preFlush(Iterator iterator) { 
      System.out.println("preFlush");
   } 
   
   //called after committed into database 
   public void postFlush(Iterator iterator) { 
      System.out.println("postFlush"); 
   } 
}