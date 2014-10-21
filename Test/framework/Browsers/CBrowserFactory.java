package Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class CBrowserFactory {
	static public CWebBrowser GetBrowser(){
		return new CWebBrowser(new FirefoxDriver());
	}
}
