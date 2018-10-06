package org.maven.project.sampleproject.testNG;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FirstTestNGExample {
  @Test
  public void FirstTestCase() {
	  System.out.println("Welcome to TestNG");
  }
  
  @Test(groups= {"bvt"})
  public void SecondTestCase() {
	  System.out.println("Welcome to Second Test Case");
	  assertFalse(true);
  }
}
