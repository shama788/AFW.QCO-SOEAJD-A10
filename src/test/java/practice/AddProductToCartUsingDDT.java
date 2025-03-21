package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Read required data
		//property file--common data
		//open the document in java readable formate
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//create object of property class - java.util
		Properties p=new Properties();
		
		//Load the file input stream to properties
		p.load(fis);
		
		//read the data using keys (data variables should be in capital letter)
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
	
	    //Launch the browser
			WebDriver driver=new ChromeDriver();
			 driver.manage().window().maximize(); 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
			//Load the Application
			 driver.get(URL);
			  
			//Login to the application
			 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		 		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		 		driver.findElement(By.id("login-button")).click();
		 		
			//click on the product-jacket
		 		 String productToBeAdded = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).getText();
		 		driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).click();//text()=.
		 		
			//Add the product to cart
		 		 driver.findElement(By.id("add-to-cart")).click();
		 		 
			//Navigate to cart
		 		driver.findElement(By.id("shopping_cart_container")).click();
		 		
			//validate for the product
		 		String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		 		if(productInCart.equals(productToBeAdded))
		 		{
		 			System.out.println("PASS");
		 			System.out.println(productInCart);
		 		}
			//logout of application 
		 		driver.findElement(By.id("react-burger-menu-btn")).click();
		 		driver.findElement(By.linkText("Logout")).click();
		 		
		

	}

}
