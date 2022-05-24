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
	@Parameters({
			"URL"/* ,"Search" */})
	@Test(groups={"smoke"})
	public void  test(String url/*,String key*/) {
		System.out.println("test -smoke");
		System.out.println(url);
		//System.out.println(key);
	}
	//having multiple group names
	@Test(groups= {"smoke","test"})
	public void abctest() {
		System.out.println("abc test -smoke and test");
	}
	
	//to get the parameters from the testng.xml file we need to add @Parameters annotation for each Test method
	@Parameters({"URL"})
	@Test(groups={"test"})
	public void zTest(String url) {
		System.out.println("zTest - test");
		System.out.println(url);
	}
	@Parameters({"URL"})
	@Test(dependsOnMethods = {"zTest"})
	public void dependsMethods(String url){
		System.out.println("depends on method zTest");
		System.out.println(url);
	}
	@Test(enabled=false,groups= {"smoke"})
	public void test3() {
		System.out.println("test3 - smoke");
	}
	
	//add dataprovider as argument in test
	@Test(dataProvider = "getData",groups= {"smoke"})
	public void dataPar(String name, String pass) {
		System.out.println("DataProvider");
		System.out.println(name + "-"+pass);
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
	
	
	//parameterizing using data provider
	@DataProvider
	public Object getData() {
		//for data provider we need to have data as 2D Object array
		Object data[][] = new Object[3][2];
		data[0][0]="A";
		data[0][1]="aZ";
		
		data[1][0]="B";
		data[1][1]="bZ";
		
		data[2][0]="C";
		data[2][1]="cZ";
		
		//after the data is gathered, we need to return the data
		return data;
	}
	
}
