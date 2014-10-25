package Controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CWebInput extends CWebAutomationElement {


	public CWebInput(WebElement webElement, WebDriver driver) {
		super(webElement, driver);
	}

	public String getValue() {
		return this.getWebElement().getAttribute("value");
	}

	public void setValue(String value) {
		setAttribute("value", value);
	}	

	public void TypeText(String text){
		_webElement.sendKeys(text);
	}
}
