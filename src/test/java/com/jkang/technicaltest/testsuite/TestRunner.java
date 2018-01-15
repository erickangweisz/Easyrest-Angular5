package com.jkang.technicaltest.testsuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author erick
 */
public class TestRunner {
	
public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTestSuite.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }	
      System.out.println("TEST SUITE SUCCESSFUL :: " + result.wasSuccessful());
   }
}
