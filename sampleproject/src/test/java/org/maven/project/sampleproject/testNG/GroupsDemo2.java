package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Test;

public class GroupsDemo2 {
	@Test(groups= {"bvt"})
	  public void testcase11() {
		  System.out.println("I am first test case in demo2");
	  }
	  
	  @Test
	  public void testcase12() {
		  System.out.println("I am second test case in demo2");
	  }
	  
	  @Test(groups= {"reg"}, dependsOnGroups= {"bvt"})
	  public void testcase13() {
		  System.out.println("I am third test case in demo2");
	  }
	  
	  @Test(groups= {"uat"})
	  public void regressiontestcase_1() {
		  System.out.println("I am regression test case in demo2");
	  }
}
