package Pages;

import org.openqa.selenium.WebDriver;

import Browsers.CWebBrowser;

abstract public class CPageBase {
	protected CWebBrowser browser;
	public CPageBase(CWebBrowser browser){
		this.browser = browser;
	}
	
	abstract boolean IsDisplayed();
}
