package PageObjectBase;

import org.openqa.selenium.WebDriver;

abstract public class CControlBase {
	protected WebDriver driver;
	public CControlBase(WebDriver driver){
		this.driver = driver;
	}
}
