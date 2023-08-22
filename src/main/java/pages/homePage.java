package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.base;
import Utility.elementUtil;

public class homePage extends base {
	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Bank Manager Login']")
	private WebElement bankManagerBtn;

	public void click_BankManagerLoginButton() {
		elementUtil.click(driver, bankManagerBtn, 2, "Bank Manager Button");
	}

}
