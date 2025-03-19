package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class consists of methods related to web element AddToCart
 * 
 * @author Admin
 */
public class CartPage {
	// Rule 1: Create POM class for every web page
		// Rule 2 : Identify the webElements -Declaration
		@FindBy(className = "inventory_item_name")
		private WebElement itemInfo;

		@FindBy(xpath = "//button[.='Remove']")
		private WebElement removeBtn;

		// Rule 3: Initialization
		public CartPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Rule 4: Utilization

		public WebElement getItemInfo() {
			return itemInfo;
		}

		public WebElement getRemoveBtn() {
			return removeBtn;
		}

		// Rule 5: Provide business library- generic method but related to scenario
		// (Code optimization) to perform login operation

		/**
		 * This method will capture the item name and return it to caller
		 * 
		 * @return
		 */
		public String getItemName() {
			return itemInfo.getText();
		}

		/**
		 * This method will click on remove button
		 */

		public void clickOnRemoveBtn() {
			removeBtn.click();
		}

	}

