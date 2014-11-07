package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlImage extends HtmlElementBase {

	public HtmlImage(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
	}

	public String getAlt(){
		return getWebElement().getAttribute("alt");
	}
	
	public String getSrc(){
		return getWebElement().getAttribute("src");
	}
}
