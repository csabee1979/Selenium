package selenium.framework;

import org.openqa.selenium.WebDriver;

abstract public class CPageBase {
	protected WebDriver driver;
	public CPageBase(WebDriver driver){
		this.driver = driver;
	}
	
	abstract boolean IsDisplayed();
}
