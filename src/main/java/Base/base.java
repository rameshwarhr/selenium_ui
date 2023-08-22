package Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import Utility.Constants;

public class base {
	protected static Properties or = new Properties();
	private static FileInputStream fis;
	protected static Logger log = Logger.getLogger(base.class.getName());
	public static WebDriver driver;

	@BeforeSuite()
	public void setUp() {
		PropertyConfigurator.configure("./src/main/resources/properties/log4j.properties");
		log.info("Test Execution Started !!!");

		try {
			fis = new FileInputStream("./src/main/resources/properties/or.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			or.load(fis);
			log.info("or Properties file is loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			log.info("Launching Chrome browser");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			log.info("Launching FireFox browser");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			log.info("Launching Microsoft Edge browser");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		log.info("Maximize The Browser");
		driver.manage().timeouts().pageLoadTimeout(Constants.Page_load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.implicityl_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public void get(String url) {
		log.info("Navigating the URL :- " + url);
		driver.get(url);

	}

	
	
	
	
	
	
	
	

	public static String getScreenshot(WebDriver driver, String methodname) 
	{

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"/Screenshot/"+methodname+"-"+getCurrentTime()+".png";
		
		File file=new File(destPath);
		
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return 	destPath;	
		
		

	}
	
	public static String getCurrentTime() {
		String currentDate=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	
	
	
	
	
	
	
	
	
}
