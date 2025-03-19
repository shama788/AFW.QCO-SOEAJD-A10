package genericUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 * 
 * @author Admin
 */
public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
    //for listners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("----Database connections Sucessfully ----");
	}

	//@Parameters("browser") //(parameter used for compatibility testing)
	//@BeforeTest(alwaysRun = true) // (Before test use in parallel execution only)
	//public void bcConfig(String BValue) throws IOException //for cross browser
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException {
		String URL = fUtil.readDataFromPropertyFile("url");

		 driver =new ChromeDriver();
		/*For cross browser Execution*/
		/*if (BValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BValue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}*/
		/*-----------------------*/
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		driver.get(URL);
		System.out.println("----- Browser launch Sucessfully ----");
		
		//for listeners
		sdriver=driver;

	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("---- login to App sucessfully---");

	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		System.out.println("--- logout of App sucessfully----");

	}

	//@AfterTest(alwaysRun = true) // (After test use in parallel execution only for both distributed and compatibility)
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("---Browser closure sucessfully---");

	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("----Database closure Sucessfully ----");

	}

}


