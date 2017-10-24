package com.tutorialspoint.service;

import com.tutorialspoint.pojo.Employee;

public class EmpBusinessLogic {
   // Calculate the yearly salary of employee
   public double calculateYearlySalary(Employee employeeDetails){
      double yearlySalary=0;
      yearlySalary = employeeDetails.getMonthlySalary() * 12;
      return yearlySalary;
   }
	
   // Calculate the appraisal amount of employee
   public double calculateAppraisal(Employee employeeDetails){
      double appraisal=0;
      if(employeeDetails.getMonthlySalary() < 10000){
         appraisal = 500;
      }else{
         appraisal = 1000;
      }
      return appraisal;
   }
}