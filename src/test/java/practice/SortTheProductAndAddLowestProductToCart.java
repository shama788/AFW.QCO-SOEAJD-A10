package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortTheProductAndAddLowestProductToCart {

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

		// SortTheProductAndAddLowestProductToCart
		// sorting by using select class
		WebElement prod = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select obj = new Select(prod);
		

		List<WebElement> options = obj.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		obj.selectByIndex(2);

		/*
		 * driver.findElement(By.xpath("//select[@class='product_sort_container']")).
		 * click(); String sort =
		 * driver.findElement(By.xpath("//option[.='Price (low to high)']")).getText();
		 * System.out.println(sort);
		 * driver.findElement(By.xpath("//option[.='Price (low to high)']")).click();
		 */

		// Adding the product to cart
		String productToBeAdded = driver.findElement(By.xpath("//div[.='Sauce Labs Onesie']")).getText();
		driver.findElement(By.xpath("//div[.='Sauce Labs Onesie']")).click();

		// Add the product to cart
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// validate for the product

		String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		if (productInCart.equals(productToBeAdded)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		// logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

}
