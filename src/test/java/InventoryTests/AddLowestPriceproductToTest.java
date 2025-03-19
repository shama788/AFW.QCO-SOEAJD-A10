package InventoryTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
@Listeners(genericUtilities.ListenersImplementations.class)
public class AddLowestPriceproductToTest extends BaseClass{
	 @Test(groups = "RegressionSuite")
	 public void tc_002_addLowestPriceproductToCart() throws IOException
	{
		
		

		// Read Test Data From Excel File
        
		String SORTOPTION = fUtil.readDataFromExcel("Products", 7, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 7, 3);
		// System.out.println(PRODUCTNAME);
		// Launch the browser


		// Load the Application
		

		// Login to Application

		
		
		// Sort the page for lowest Price
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
		
		// we can only go with visible text
		
		// Click on Product
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);

		// Add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate To Cart and Validate
		ip.clickOnCartContainer();

		
		// Validate in the cart page
        CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		
		Assert.assertEquals(productAdded, productInCart);
		 System.out.println(PRODUCTNAME);

		
		

	}

}



