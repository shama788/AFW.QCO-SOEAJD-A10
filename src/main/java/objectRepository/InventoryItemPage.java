package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	// Rule 1: Create POM class for every web page
		// Rule 2 : Identify the webElements -Declaration
		@FindBy(id = "add-to-cart")
		private WebElement addToCartBtn;

		// Rule 3: Initialization
		public InventoryItemPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Rule 4: Utilization
		public WebElement getAddToCartBtn() {
			return addToCartBtn;
		}

		// Rule 5: Provide business library- generic method but related to scenario
		// (Code optimization) to perform login operation

		/**
		 * This method will perform add product to the cart
		 */
		public void clickOnAddToCartBtn() {

			addToCartBtn.click();
		}

	}


	


