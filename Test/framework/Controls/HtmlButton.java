package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TypeExtensions.CStringExtension;

public class HtmlButton extends HtmlElementBase {

	public HtmlButton(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
	}

	public String getValue(){
		
		String value = getWebElement().getAttribute("value");
		
		if (value.length() == 0){
			 return getWebElement().getText();
		}
		
		return value;
	}
}
