package Controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TypeExtensions.CStringExtension;

public class CWebButton extends CWebAutomationElement {

	public CWebButton(WebElement webElement, WebDriver driver) {
		super(webElement, driver);
	}

	public String getValue(){
		
		String value = getWebElement().getAttribute("value");
		
		if (value.length() == 0){
			 return getWebElement().getText();
		}
		
		return value;
	}
}
