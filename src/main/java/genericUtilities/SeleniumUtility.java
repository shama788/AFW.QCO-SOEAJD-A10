package genericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of methods related to Selenium
 * @author Admin
 */

public class SeleniumUtility {
	/**
	 * This method will maximize window
	 * @author Admin
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();	
	}

	
	
	/**
	 * This method will minimize window
	 * @author Admin
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();	
	}
	
	/**
	 * This method will implicitly wait of 10 seconds
	 * @author Admin
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	/**
	 * This mehod will wait 10 seconds for element to be clickable
	 * @author Admin
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @author Admin
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * This method will handle dropdown by Visible text (method by overloading)
	 * @author Admin
	 * @param element
	 * @param visibletext
	 */
	public void handleDropDown(String visibletext,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	

	/**
	 * This method will handle dropdown by Value
	 * @author Admin
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will be used for mouse hover action on webelement
	 * @author Admin
	 * @param driver
	 * @param element
	 */
	public void mouseOverActions(WebDriver driver, WebElement element) {
		 Actions action=new Actions(driver);
		 action.moveToElement(element).perform();
	}
	
	/**
	 * This method will be used for double click actions on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickActions(WebDriver driver, WebElement element) {
		 Actions action=new Actions(driver);
		 action.doubleClick(element).perform();
	}
	
	
	/**
	 * This method will be used for context click actions on webelement
	 * @param driver
	 * @param element
	 */
	public void contextClickActions(WebDriver driver, WebElement element) {
		 Actions action=new Actions(driver);
		 action.contextClick(element).perform();
	}
	
	
	/**
	 * This method will be used for drag and drop actions on webelement
	 * @param driver
	 * @param element
	 */
	public void dargAndDropActions(WebDriver driver, WebElement srcelement, WebElement tarelement) {
		 Actions action=new Actions(driver);
		 action.dragAndDrop(srcelement, tarelement).perform();
	}
	//send keys,click click and hold not frequently 
	
	/**
	 * This method will be used for scroll to particular webelement
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver, WebElement element) {
		 Actions action=new Actions(driver);
		 action.scrollToElement(element).perform();
	}
	
	/**
	 * This method will be used for frame handling by index
	 * @param driver
	 * @param index
	 */
	public void frameHandle(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will be used for frame handling by name
	 * @param driver
	 * @param nameOrID
	 */
	public void frameHandle(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will be used for frame handling by webelement
	 * @param driver
	 * @param element
	 */
	public void frameHandle(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will be used for Back to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to window
	 * @param driver
	 * @param String
	 */
	public void switchToWindow(WebDriver driver, String windowID) {
		driver.switchTo().window(windowID);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	
	
	/**
	 * This method will get the alert text
	 * @param driver
	 */
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	
	/**
	 * This method will enter the data to alert popup
	 * @param driver
	 * @param data
	 */
	public void enterDataToAlert(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method will capture the screenshot and return the path to the caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		 FileHandler.copy(src, dst);
		 
		 return dst.getAbsolutePath();//for extend report
		 
		 //addproducttocart-takescreenshot-addproductcart-22-02-2025-14-21-30.png
		 //addproducttocart-takescreenshot-addproductcart-22-02-2025-14-21-45.png
	}
	
}



