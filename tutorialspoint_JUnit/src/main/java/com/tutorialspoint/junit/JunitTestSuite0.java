package com.tutorialspoint.junit;

import junit.framework.*;

public class JunitTestSuite0 {
   public static void main(String[] a) {
      // add the test's in the suite
      TestSuite suite = new TestSuite(TestJunit.class, TestFixtures.class, TestJunit3.class );
      TestResult result = new TestResult();
      suite.run(result);
      System.out.println("Number of test cases = " + result.runCount());
    }
}