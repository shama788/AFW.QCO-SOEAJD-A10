package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

/**
 * This class consists of methods related to web element of Inventory Page
 * 
 * @author Admin
 */
public class InventoryPage extends SeleniumUtility{
	// Rule 1: Create POM class for every web page
		// Rule 2 : Identify the webElements -Declaration

		@FindBy(className = "product_sort_container")
		private WebElement sortDropDown;

		@FindBy(id = "shopping_cart_container")
		private WebElement cartcontainerBtn;

		@FindBy(id = "react-burger-menu-btn")
		private WebElement menuBtn;

		@FindBy(id = "logout_sidebar_link")
		private WebElement logoutLink;

		// Rule 3: Initialization
		public InventoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Rule 4: Utilization

		public WebElement getSortDropDown() {
			return sortDropDown;
		}

		public WebElement getCartcontainerLink() {
			return cartcontainerBtn;
		}

		public WebElement getMenuBtn() {
			return menuBtn;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}

		// Rule 5: Provide business library- generic method but related to scenario
		// (Code optimization) to perform login operation

		/**
		 * This method will click on product read from excel file and return the details
		 * to caller
		 * 
		 * @param driver
		 * @param PRODUCTNAME
		 * @return
		 */
		public String clickOnProduct(WebDriver driver, String PRODUCTNAME) {
			WebElement prod = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
			String productDetails = prod.getText();
			prod.click();
			return productDetails;

		}

		/**
		 * This method will click on cart container button
		 */

		public void clickOnCartContainer() {
			cartcontainerBtn.click();

		}

		/**
		 * This method will perform click on menu and logout operation
		 */
		public void logoutOfApp() {
			menuBtn.click();
			logoutLink.click();
		}

		/**
		 * This method will sort the product and then click on required product and
		 * return the details to caller
		 * 
		 * @param driver
		 * @param PRODUCTNAME
		 * @param SORTOPTION
		 * @return
		 */
		public String clickOnSortedProduct(WebDriver driver, String PRODUCTNAME, String SORTOPTION) {
			handleDropDown(SORTOPTION, sortDropDown);
			WebElement prod = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
			String productDetails = prod.getText();
			prod.click();
			return productDetails;

		}

	}



