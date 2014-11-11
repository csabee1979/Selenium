package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlRadioButton extends HtmlElementBase {

	public HtmlRadioButton(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
	}

	public boolean getChecked(){
		return getWebElement().getAttribute("CHECKED") == "true";
	}
	
	public void setChecked(boolean value){
		
		if (value && !getChecked()){
			click();
		}
	}

	
}
