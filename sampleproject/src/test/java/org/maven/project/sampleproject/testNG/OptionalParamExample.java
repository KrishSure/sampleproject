package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OptionalParamExample {
	@Parameters("param one")
	@Test
	public void testOptionParamOne(@Optional("First Param") String paramOne) {

		System.out.println("Parameter passed from XML ::" + paramOne);
	}

	@Parameters("param two")
	@Test
	public void testOptionParamTwo(@Optional("IamOptional") String paramTwo) {

		System.out.println("Optional value passed ::" + paramTwo);
	}
}
