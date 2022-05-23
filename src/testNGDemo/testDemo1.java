package testNGDemo;

import org.testng.annotations.Test;

public class testDemo1 {
	
	
	//need to import testNG annotations to run the tests
	@Test //1st test case
	public void testRun() {
		System.out.println("learning testNG");
	}
	
	@Test //2nd test case
	public void test2() {
		System.out.println("test run 2");
	}

}
