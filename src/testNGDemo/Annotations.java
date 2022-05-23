package testNGDemo;
import org.testng.annotations.*;

public class Annotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	@BeforeGroups
	public void beforeGropus() {
		System.out.println("beforeGroups");
	}
	
	//grouping tests
	@Test(groups={"smoke"})
	public void  test() {
		System.out.println("test");
	}
	//having multiple group names
	@Test(groups= {"smoke","test"})
	public void abctest() {
		System.out.println("abctest");
	}
	@Test(groups={"test"})
	public void zTest() {
		System.out.println("zTest");
	}
	
	@Test(dependsOnMethods = {"zTest"})
	public void dependsMethods(){
		System.out.println("depends on method");
	}
	@Test(enabled=false,groups= {"smoke"})
	public void test3() {
		System.out.println("test3");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("afterGroups");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	
}
