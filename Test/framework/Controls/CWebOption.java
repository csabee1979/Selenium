package Controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CWebOption extends CWebAutomationElement {

	public CWebOption(WebElement webElement, WebDriver driver) {
		super(webElement, driver);
	}
	
    public void select()
    {
        if (!_webElement.isSelected())
        {
        	_webElement.click();
        }
    }

}
