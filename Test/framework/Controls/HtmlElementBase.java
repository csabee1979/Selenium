package Controls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
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

public class HtmlElementBase {
	protected WebElement _webElement;
	private final WebDriver _driver;
	private final Actions _action;
	private final Mouse _mouse;
	private By locator;
	
	public HtmlElementBase(final WebElement webElement, final WebDriver driver) {
		this.setWebElement(webElement);
		this._driver = driver;
		_action = new Actions(_driver);
		_mouse = ((HasInputDevices)_driver).getMouse();
	}
	
	protected WebElement getWebElement() {
		return _webElement;
	}

	protected void setWebElement(final WebElement webElement) {
		this._webElement = _webElement;
	}
	
    public String getId() {
        return getWebElement().getAttribute("id"); 
    }

    public HtmlElementBase getParent() {
        return new HtmlElementBase(getWebElement().findElement(By.xpath("..")), _driver);
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

    public void dragAndDrop(final HtmlElementBase sourceElement) {
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
       
    public HtmlInput getWebInput(final By byConstraint){
    	return new HtmlInput(getWebElement().findElement(byConstraint), _driver);
    }

    public List<HtmlInput> getWebInputs(){
    	final String elementName = "input[type='text']";
    	final List<HtmlInput> inputList = new ArrayList<HtmlInput>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		inputList.add(new HtmlInput(element, _driver));
    	}
    	
    	return inputList;
    	
    	//return new CWebInput(getWebElement().findElement(byConstraint), _driver);
    }
    
    public HtmlButton getWebButton(final By byConstraint){
    	return new HtmlButton(getWebElement().findElement(byConstraint), _driver);
    }

    public List<HtmlButton> getWebButtons(){
    	final String elementName = "button";
    	final List<HtmlButton> buttonList = new ArrayList<HtmlButton>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		buttonList.add(new HtmlButton(element, _driver));
    	}
    	
    	return buttonList;
    	
    	//return new CWebInput(getWebElement().findElement(byConstraint), _driver);
    }
    
    public HtmlSelect getWebSelect(final By byConstraint){
    	return new HtmlSelect(getWebElement().findElement(byConstraint), _driver);
    }

    public List<HtmlSelect> getWebSelects(){
    	final String elementName = "select";
    	final List<HtmlSelect> selectList = new ArrayList<HtmlSelect>(); 
    	final List<WebElement> elementList = _webElement.findElements(By.cssSelector(elementName));
    	
    	for (final WebElement element: elementList){
    		selectList.add(new HtmlSelect(element, _driver));
    	}
    	
    	return selectList;   	
    }
    
    
    public WebElement getWebElement(final By byConstraint){
        return  _webElement.findElement(byConstraint);   	
    }

    public <T extends HtmlElementBase> T getElement(Class<T> element, final By byConstraint) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{        
    	try {
	    	Constructor<T> constructor = element.getConstructor(WebElement.class, WebDriver.class);
	    	return constructor.newInstance( _webElement.findElement(byConstraint), getDriver());
    	}
    	catch (NoSuchMethodException e) {
    		return element.newInstance();
    	}
    }
    
    public WebElement getCurrentWebElement() {
    	return getWebElement();
    }
    
    public String getElementName(){
    	return "";
    }
    
}
