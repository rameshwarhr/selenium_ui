package rough;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.base;
import Base.urlconfig;
import pages.homePage;

public class testTest extends base {
	urlconfig c=new urlconfig();
	
	@BeforeMethod()
	public void setup() {
		openBrowser("chrome");
		get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Test
	public void dumyyTest() {
		homePage h=new homePage(driver);
		h.click_BankManagerLoginButton();
		
			}

}
