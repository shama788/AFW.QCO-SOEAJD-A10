package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	
	  @Test 
	  public void sample() 
	  { 
		  System.out.println("hi"); 
		  }
	  
	  //Priority and Invocation count //enabled and dependsonmethod
	  
	  @Test(priority = 1) 
	  public void sample2()
	  { 
		  System.out.println("hello");
	  
	  }
	  
	  @Test(invocationCount = 3,threadPoolSize = 3)
	  public void sample3()
	  {
	  System.out.println("hey");
	  
	 }
	
	@Test(enabled = true)
	public void sample4() {
		Reporter.log("abc", true);
	}
	
	
	  @Test(dependsOnMethods = "sample4") 
	  public void sample5() 
	  {
	  System.out.println("bye"); 
	  }
	 

}
