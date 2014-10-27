package Controls;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CWebSelect extends CWebAutomationElement {
	private Select selectElement;

	public CWebSelect(WebElement webElement, WebDriver driver) {
		super(webElement, driver);
		// TODO Auto-generated constructor stub
		selectElement = new Select(_webElement);
	}

    public CWebOption getSelectedOption() {
    	return new CWebOption(selectElement.getFirstSelectedOption(), getDriver());
    }
    
    public boolean isMultiple() {
    	return selectElement.isMultiple();
    }
    
    public void selecOptiontByValue(String value)
    {
    	selectElement.selectByValue(value);
    }
    
    public void selecOptiontByVisibleText(String text)
    {
    	selectElement.selectByVisibleText(text);    	
    }
    
    public void selecOptiontByIndex(int index)
    {
    	selectElement.selectByIndex(index);
    }

    public void deselecOptiontByValue(String value)
    {
    	selectElement.deselectByValue(value);
    }
    
    public void deselecOptiontByVisibleText(String text)
    {
    	selectElement.deselectByVisibleText(text);    	
    }
    
    public void deselecOptiontByIndex(int index)
    {
    	selectElement.deselectByIndex(index);
    }

    public List<CWebOption> getAllOptions(){
    	List<WebElement> options = selectElement.getOptions();
    	List<CWebOption> webOptions = new ArrayList<CWebOption>(); 
    	
    	for(WebElement option : options) {
    		webOptions.add(new CWebOption(option, getDriver()));
    	}
    	
    	return webOptions;
    }
    
    public List<CWebOption> getAllSelectedOptions(){
    	List<WebElement> options = selectElement.getAllSelectedOptions() ;
    	List<CWebOption> webOptions = new ArrayList<CWebOption>(); 
    	
    	for(WebElement option : options) {
    		webOptions.add(new CWebOption(option, getDriver()));
    	}
    	
    	return webOptions;
    }
}
