package InventoryTests;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;


@Listeners(genericUtilities.ListenersImplementations.class)
public class AddProductToCartTest extends BaseClass{
	@Test(groups = "SmokeSuite")
	//@Test(groups = "SmokeSuite",retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class) //for failure analyser
	public void tc_001_addProductToCart() throws IOException {

		// Read required Data
		// Property file - common Data(implemented In Base class)

		// Read Test Data From Excel File

		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);

		// Launch the (implemented In Base class)

		// Load the Application(implemented In Base class)

		// Login to Application(implemented In Base class)

		// Click on Product

		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Assert.fail();

		// Add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate To Cart and Validate
		ip.clickOnCartContainer();

		// Validate in the cart page
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		Assert.assertEquals(productInCart, productAdded);
		Assert.assertTrue(productInCart.equals(productAdded));
		 System.out.println(PRODUCTNAME);

		// Logout of Application(implemented In Base class)

	}
	@Test// example to run single method from class cmd -Dtest=className#methodName test
	public void sample() {
		System.out.println("sample");
	}

}



