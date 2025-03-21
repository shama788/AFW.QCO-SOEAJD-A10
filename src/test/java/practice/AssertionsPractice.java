package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
   //Hard Assert
	@Test
	public void sample() {
		System.out.println("step 1");
		Assert.assertEquals(0, 1);
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		System.out.println("step 5");
	}
	 
	//soft Assert
	@Test
	public void sample1() {
		SoftAssert sa=new SoftAssert();
		System.out.println("step 1");
		sa.assertEquals(0, 1);
		System.out.println("step 2");
		System.out.println("step 3");
		sa.assertEquals("b", "a");
		System.out.println("step 4");
		System.out.println("step 5");
		
		//sa.assertAll();
		
	}
}
