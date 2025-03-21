package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_03 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("https://www.saucedemo.com/");
			  driver.findElement(By.id("user-name")).sendKeys("standard_user");
			  driver.findElement(By.id("password")).sendKeys("secret_sauce");
			  driver.findElement(By.id("login-button")).click(); 
			 driver.findElement(By.xpath("//div[@class='inventory_item_label']/..//button[text()='Add to cart']")).click(); 
			 driver.findElement(By.id("shopping_cart_container")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.id("remove-sauce-labs-backpack")).click();
			 Thread.sleep(3000);
			 driver.navigate().back();
			 Thread.sleep(3000);
			 driver.findElement(By.id("react-burger-menu-btn")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Logout")).click(); 
			 

	}

}
