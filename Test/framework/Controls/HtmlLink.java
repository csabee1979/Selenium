package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlLink extends HtmlElementBase {

	public HtmlLink(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
	}
	
	public String getHref() {
		return getCurrentWebElement().getAttribute("href");
	}
	
	@Override
    public By getDefaultByContstraint(){
    	return By.tagName("a");
    }
}
