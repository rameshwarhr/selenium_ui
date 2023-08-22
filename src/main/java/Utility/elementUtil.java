package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.base;
import ExtentManager.listners;

public class elementUtil extends base {

	public static void click(WebDriver driver, WebElement element, long timeout, String field) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			WebElement elements = null;
			elements = wait.until(ExpectedConditions.elementToBeClickable(element));
			elements.click();
			log.info("clicking an element :" + field);
			listners.extentTest.get().info("clicking on an Element :- " + field);
		} catch (Throwable t) {
			log.error("Error While Clicking on an Element :- " + field + " @Message- " + t.getMessage());
			listners.extentTest.get().fail("Error While clicking on an Element :- " + field);
			Assert.fail(t.getMessage());

		}
	}
}
