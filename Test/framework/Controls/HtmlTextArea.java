package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlTextArea extends HtmlElementBase {

	public HtmlTextArea(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
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
