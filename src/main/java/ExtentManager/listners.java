package ExtentManager;




import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.base;




public class listners extends base implements ITestListener
{

	static ExtentReports extent=ExtentReporterNG.setExtent();
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stu
	
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, MarkupHelper.createLabel("Test Passed :- "+result.getMethod().getMethodName()+"-:-"+result.getMethod().getRealClass(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriver driver=base.driver;
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed :- "+result.getMethod().getMethodName()+"-:-"+result.getMethod().getRealClass(), ExtentColor.RED));
		extentTest.get().fail(result.getThrowable());
		Object testObject=result.getInstance();
		
	Class clz=	result.getTestClass().getRealClass();
	
	try {
		driver=(WebDriver)clz.getDeclaredField("driver").get(testObject);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	} 
	
	extentTest.get().addScreenCaptureFromPath(getScreenshot(driver,result.getMethod().getMethodName()));
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	//	test.log(Status.SKIP, MarkupHelper.createLabel("Test Skip :- "+result.getMethod().getMethodName()+"-:-"+result.getMethod().getRealClass(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
 	extent.flush();
	}

}
