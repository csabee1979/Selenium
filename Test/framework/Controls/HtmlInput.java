package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlInput extends HtmlElementBase {


	public HtmlInput(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
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
	
	@Override
	public String getHtmlTag() {
		return "input";
	}
}
