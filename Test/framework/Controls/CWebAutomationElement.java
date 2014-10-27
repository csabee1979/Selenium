package Controls;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import TypeExtensions.CStringExtension;

public class CWebAutomationElement {
	protected WebElement _webElement;
	private final WebDriver _driver;
	private final Actions _action;
	private final Mouse _mouse;

	public CWebAutomationElement(final WebElement webElement, final WebDriver driver) {
		this.setWebElement(webElement);
		this._driver = driver;
		_action = new Actions(_driver);
		_mouse = ((HasInputDevices)_driver).getMouse();
	}
	
	protected WebElement getWebElement() {
		return _webElement;
	}

	protected void setWebElement(final WebElement _webElement) {
		this._webElement = _webElement;
	}
	
    public String getId() {
        return getWebElement().getAttribute("id"); 
    }

    public CWebAutomationElement getParent() {
        return new CWebAutomationElement(getWebElement().findElement(By.xpath("..")), _driver);
    }

    public String getClassName() {
        return getWebElement().getAttribute("class").trim();
    }

    public CStyle getStyle() {
        return new CStyle(getWebElement()); 
    }

    public boolean isDisplayed() {
        try {
            return isExists() ? getWebElement().isDisplayed() : false;
        }
        catch (final NoSuchElementException  e) {
            return false;
        }
    }

    public boolean isEnabled() {
        return getWebElement().isEnabled(); 
    }

    public boolean isDisabled() {
        return !isEnabled();
    }

    public boolean isExists() {
        return getWebElement() != null;
    }

    public String getTagName() {
        return getWebElement().getTagName(); 
    }

    public String getText() {
    	return (getWebElement().getText() != null) ? getWebElement().getText() : getWebElement().getAttribute("text"); 
    }
    
    public boolean isReadOnly() {
        return getClassName().contains("readonly") || !CStringExtension.isNullOrEmpty(getWebElement().getAttribute("readOnly")); 
    }


    public boolean getSelected() {
        return getWebElement().isSelected();
    }

    public Dimension getSize() {
        return getWebElement().getSize(); 
    }

    public Point getLocation() {
        return getWebElement().getLocation();
    }

    public String getInnerHtml() {
    		//return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", _webElement);
    	return getWebElement().getAttribute("innerHTML");
    }

    public String getTitle() {
        return getWebElement().getAttribute("title");
    }

    public String getName() {
        return getWebElement().getAttribute("name");
    }

    public String getValue() {
        return getWebElement().getAttribute("value");
    }
    
    public WebDriver getDriver() {
    	return this._driver;
    }
    
    public void setAttribute(final String attributeName, final String attributeValue) {
        if (_driver != null) {
        	((JavascriptExecutor )this._driver).executeScript("arguments[0].setAttribute('" + attributeName + "',arguments[1]);", this._webElement, attributeValue);
        }
    }
    
    public void click() {
        if (isDisplayed()) {
            _webElement.click();
        }
    }
    
    public void actionClick() {
    	_action.click(_webElement).perform();
    }
    
    public void doubleClick() {
        if (isDisplayed()) {
            _action.doubleClick(_webElement).perform();
        }
    }
    
    public void rightClick() {
        if (isDisplayed()) {
            _action.contextClick(_webElement).perform();
        }
    }

    public void dragAndDrop(final CWebAutomationElement sourceElement) {
    	_action.dragAndDrop(sourceElement._webElement, this._webElement).perform();
    }
    
    public void mouseClick() {
        if (isDisplayed()) {
            _mouse.click(((Locatable)_webElement).getCoordinates());
        }
    }
    
    public void mouseDown() {
    	
        if (isDisplayed()) {
            _mouse.mouseDown(((Locatable)_webElement).getCoordinates());
        }
    }

    
    public void mouseUp() {
        if (isDisplayed())        {
            _mouse.mouseUp(((Locatable)_webElement).getCoordinates());
        }	
    }

    public void mouseMove(final int offsetX, final int offsetY)
    {
        if (isDisplayed()) {
            _mouse.mouseMove(((Locatable)_webElement).getCoordinates(), offsetX, offsetY);
        }
    }

    public void moveTo() {
    	
        if (isDisplayed())        {
        	_action.moveToElement(_webElement, 0, 0).perform();
        }
    }
    
    public void release() {
    	if (isDisplayed()) {
    		_action.release(getWebElement()).perform();
    	}
    }
       
    public CWebInput getWebInput(final By byConstraint){
    	return new CWebInput(getWebElement().findElement(byConstraint), _driver);
    }

    public List<CWebInput> getWebInputs(){
    	final String elementName = "input[type='text']";
    	final List<CWebInput> inputList = new ArrayList<CWebInput>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		inputList.add(new CWebInput(element, _driver));
    	}
    	
    	return inputList;
    	
    	//return new CWebInput(getWebElement().findElement(byConstraint), _driver);
    }
    
    public CWebButton getWebButton(final By byConstraint){
    	return new CWebButton(getWebElement().findElement(byConstraint), _driver);
    }

    public List<CWebButton> getWebButtons(){
    	final String elementName = "button";
    	final List<CWebButton> buttonList = new ArrayList<CWebButton>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		buttonList.add(new CWebButton(element, _driver));
    	}
    	
    	return buttonList;
    	
    	//return new CWebInput(getWebElement().findElement(byConstraint), _driver);
    }
    
    public CWebSelect getWebSelect(final By byConstraint){
    	return new CWebSelect(getWebElement().findElement(byConstraint), _driver);
    }

    public List<CWebSelect> getWebSelects(){
    	final String elementName = "select";
    	final List<CWebSelect> selectList = new ArrayList<CWebSelect>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		selectList.add(new CWebSelect(element, _driver));
    	}
    	
    	return selectList;   	
    }
    
    
    public WebElement getWebElement(final By byConstraint){
        return  _webElement.findElement(byConstraint);   	
    }

    public WebElement getCurrentWebElement() {
    	return getWebElement();
    }
    
}
