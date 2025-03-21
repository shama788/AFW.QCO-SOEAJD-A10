package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveProductFromCart {

	public static void main(String[] args) {
		// Launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

				// Load the Application
				driver.get("https://www.saucedemo.com/");

				// Login to the application
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				driver.findElement(By.id("login-button")).click();

				// click on the product-Backpack
				String productToBeAdded = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
				driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();// text()=.

				// Add the product to cart
				driver.findElement(By.id("add-to-cart")).click();

				// Navigate to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				
				//Remove product from cart
				String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
                   driver.findElement(By.id("remove-sauce-labs-backpack")).click();
                   if(productInCart.equals(productToBeAdded)) {
                	   System.out.println("PASS");
                	   System.out.println(productInCart);
                   }
               	// logout of application
           		driver.findElement(By.id("react-burger-menu-btn")).click();
           		driver.findElement(By.linkText("Logout")).click();
	}

}
