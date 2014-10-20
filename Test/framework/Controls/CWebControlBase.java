package selenium.framework;

import org.openqa.selenium.WebDriver;

abstract public class CWebControlBase {
	protected WebDriver driver;
	public CWebControlBase(WebDriver driver){
		this.driver = driver;
	}
}
