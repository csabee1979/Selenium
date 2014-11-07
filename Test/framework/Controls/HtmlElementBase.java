package Controls;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.thoughtworks.selenium.Wait;

import TypeExtensions.CStringExtension;

public class HtmlElementBase {
	protected WebElement _webElement;
	private final WebDriver _driver;
	private final Actions _action;
	private final Mouse _mouse;
	private By _locator;
	private HtmlControlBuilder _controlBuilder;
	
	public HtmlElementBase(final WebElement webElement, final WebDriver driver, By locator) {
		this.setWebElement(webElement);
		this._driver = driver;
		_action = new Actions(_driver);
		_mouse = ((HasInputDevices)_driver).getMouse();
		_locator = locator;
		_controlBuilder = new HtmlControlBuilder(webElement, driver);
	}
	
	protected WebElement getWebElement() {
		return _webElement;
	}

	protected By getLocator() {
		return _locator;
	}
	
	protected void setWebElement(final WebElement webElement) {
		this._webElement = webElement;		
	}
	
    public String getId() {
        return getWebElement().getAttribute("id"); 
    }

    public HtmlElementBase getParent() {
        return new HtmlElementBase(getWebElement().findElement(By.xpath("..")), _driver, By.xpath(".."));
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
    
    public void javaScriptClick() {
        StringBuilder script = new StringBuilder();
        script.append("var evt = document.createEvent('MouseEvents');");
        script.append(String.format("evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"));
        script.append("arguments[0].dispatchEvent(evt);");
        
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();  
        javascriptExecutor.executeScript(script.toString(), getCurrentWebElement());
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
    
    public WebElement getCurrentWebElement() {
    	return getWebElement();
    }
        
    public void waitForElementToBeVisible() {
    	new FluentWait<WebDriver>(getDriver()).
                withTimeout(3, TimeUnit.SECONDS).
                pollingEvery(50, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                	until(new Predicate<WebDriver>() {
						@Override
						public boolean apply(WebDriver driver) {
							return getCurrentWebElement().isDisplayed();
						}
				});
    }
    
    public void waitUntilButtonToBeVisible(int sec) {
    	WebDriverWait wait = new WebDriverWait(getDriver(), sec);
        wait.until(new Function<WebDriver, WebElement>() {
    	     public WebElement apply(WebDriver driver) {
    	       return getCurrentWebElement();  	    		   
    	     }
    	   });

    }
    
    public HtmlControlBuilder getControls(){
    	return _controlBuilder;
    }
}
