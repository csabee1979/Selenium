package Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class CBrowserFactory {
	static public CWebBrowser GetBrowser() throws InterruptedException{	
		FirefoxDriver driver = new FirefoxDriver();
		Thread.sleep(3000);
		return new CWebBrowser(driver);
	}
}
