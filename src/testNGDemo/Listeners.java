package testNGDemo;

import org.testng.ITestListener;
import org.testng.ITestResult;

//testNG Listeners are used to perform activities on the testcase
//listeners listen to the test on each step
//listeners are used with the help of ITestListeners which is an interface which implements TestNG listeners
public class Listeners implements ITestListener{
	@Override
	public void onTestFailure(ITestResult result) {
		//code to be implemented if the test failed
		System.out.println("---------------test failed------------");
		//result object will have the details of all the test
		System.out.println("Failed:"+result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		//code to be implemented if the test is successful
		System.out.println("-----------------Test is completed-------------");
		System.out.println("Passed:"+result.getName());	
	}
}
