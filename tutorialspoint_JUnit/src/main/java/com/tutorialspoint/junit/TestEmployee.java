package com.tutorialspoint.junit;
import org.junit.Test;

import com.tutorialspoint.pojo.Employee;
import com.tutorialspoint.service.EmpBusinessLogic;

import static org.junit.Assert.*;

public class TestEmployee {
   EmpBusinessLogic empBusinessLogic =new EmpBusinessLogic();
   Employee employee = new Employee();

   //test to check appraisal
   @Test
   public void testCalculateAppriasal() {
      employee.setName("Rajeev");
      employee.setAge(25);
      employee.setMonthlySalary(8000);
      double appraisal= empBusinessLogic.calculateAppraisal(employee);
      assertEquals(506, appraisal, 10.0);
   }

   // test to check yearly salary
   @Test
   public void testCalculateYearlySalary() {
      employee.setName("Rajeev");
      employee.setAge(25);
      employee.setMonthlySalary(8000);
      double salary= empBusinessLogic.calculateYearlySalary(employee);
      assertEquals(96000, salary, 0.0);
   }
}