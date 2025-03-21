package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddLowestPriceProducttToCartUsingDDT_GU {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Create Object of All Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();

		// Read required Data
		// Property file - common Data

		// open the doc in java readable format
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String SORTOPTION = fUtil.readDataFromExcel("Products", 7, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 7, 3);
		System.out.println(PRODUCTNAME);
		// Launch the browser

		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Load the Application
		driver.get(URL);

		// Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-button")).click();

		// Sort the page for lowest Price
		WebElement prodSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sUtil.handleDropDown(SORTOPTION, prodSort);
		// we can only go with visible text

		Thread.sleep(2000);

		// Click on the Lowest price Product
		WebElement Product = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String productToBeAdded = Product.getText();
		Product.click();

		// Add the product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate To Cart and Validate
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productToBeAdded.equals(productInCart)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		} else {
			System.out.println("FAILS");
		}

		// Logout of Application
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

}
