package genericUtilities;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestlistener interface of TestNG
 * @author Admin
 */
public class ListenersImplementations implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-@Test execution Started");
		
		//Intimate the  start @Test to Extent Reports
		test = report.createTest(methodname);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-@Test execution Pass");
		
		//Intimate extent reports @Test is Pass - log the status
				test.log(Status.PASS, methodname+"-@Test execution Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-@Test execution Fail");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the Status as Fail in Extent Reports
		test.log(Status.FAIL, methodname+"-@Test execution Fail");
		
		//Log the Exception in report
		 test.log(Status.WARNING, result.getThrowable());
				
		
		//capture Screenshots
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		
		//configure screenshotName
		String screenShotName = methodname+"-"+j.getSystemDateInFormate();
		
		//we can't use throw due to abstract method
		try {
			//s.captureScreenShot(BaseClass.sdriver, screenShotName);--> this line before report
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			//attach the screenshot to extent reports
			
			test.addScreenCaptureFromPath(path);
			//System.out.println(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-@Test execution Skip");
		
		//Capture the exception
	    System.out.println(result.getThrowable());
	   
	    //Log the status as SKIP in Extent reports
	    test.log(Status.SKIP, methodname+"-@Test execution Skip");
	    
	    //Log the exception in extent reports
	    test.log(Status.WARNING, result.getThrowable());
	    
	    
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("-Suite execution started");
		
		//Configure of extent reports
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDateInFormate()+".html");
		esr.config().setDocumentTitle("SauceLabs Execution Report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.STANDARD);
		
		//load the Basic configuration to extent reports class
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Shama");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("-Suite execution Finished");
		
		//Flush the Report
		report.flush();
		
	}
	
	

}


