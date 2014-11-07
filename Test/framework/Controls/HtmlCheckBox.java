package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlCheckBox extends HtmlElementBase{

	public HtmlCheckBox(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
	}

	public boolean getChecked(){
		return getWebElement().getAttribute("").toLowerCase() == "true";
	}
	
	public void setChecked(){
		
		if (!getChecked()){
			click();
		}
	}
}
