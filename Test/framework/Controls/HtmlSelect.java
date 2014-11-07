package Controls;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HtmlSelect extends HtmlElementBase {
	private Select selectElement;

	public HtmlSelect(WebElement webElement, WebDriver driver, By locator) {
		super(webElement, driver, locator);
		// TODO Auto-generated constructor stub
		selectElement = new Select(_webElement);
	}

    public HtmlOption getSelectedOption() {
    	return new HtmlOption(selectElement.getFirstSelectedOption(), getDriver(), getLocator());
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

    public List<HtmlOption> getAllOptions(){
    	List<WebElement> options = selectElement.getOptions();
    	List<HtmlOption> webOptions = new ArrayList<HtmlOption>(); 
    	
    	for(WebElement option : options) {
    		webOptions.add(new HtmlOption(option, getDriver(), getLocator()));//Todo: megnézni
    	}
    	
    	return webOptions;
    }
    
    public List<HtmlOption> getAllSelectedOptions(){
    	List<WebElement> options = selectElement.getAllSelectedOptions() ;
    	List<HtmlOption> webOptions = new ArrayList<HtmlOption>(); 
    	
    	for(WebElement option : options) {
    		webOptions.add(new HtmlOption(option, getDriver(), getLocator()));
    	}
    	
    	return webOptions;
    }
    
	@Override
	public String getHtmlTag() {
		return "button";
	}
}
