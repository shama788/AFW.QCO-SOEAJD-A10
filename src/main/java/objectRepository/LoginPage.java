package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class consists of methods related to web element login
 * @author Admin
 */

public class LoginPage {
	//Rule 1: Create POM class for every web page
		//Rule 2 : Identify the webElements -Declaration
		@FindBy(id = "user-name")
			private WebElement usernameEdt;
		
		@FindBy(name = "password")
		private WebElement passwordEdt;
		
		@FindBy(id = "login-button")
		private WebElement loginBtn;
		
		//Rule 3: Initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	    
		
		//Rule 4: Utilization
		
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		
		//Rule 5: Provide business library- generic method but related to scenario (Code optimization) to perform login operation
		
		/**
		 * This method will perform Login Operation
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginToApp(String USERNAME, String PASSWORD)
		{
			usernameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
		
		
	}

