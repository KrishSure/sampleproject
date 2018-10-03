package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Test;

public class GroupsDemo {
  @Test(groups= {"bvt"})
  public void testcase1() {
	  System.out.println("I am first test case");
  }
  
  @Test
  public void testcase2() {
	  System.out.println("I am second test case");
  }
  
  @Test(groups= {"reg"}, dependsOnGroups= {"bvt"})
  public void testcase3() {
	  System.out.println("I am third test case");
  }
  
  @Test(groups= {"bvt"})
  public void regressiontestcase() {
	  System.out.println("I am regression test case");
  }
}
