package Controls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TypeExtensions.CStringExtension;

public class CWebAutomationElement {
	private WebElement _webElement;
	private WebDriver _driver;

	public CWebAutomationElement(WebElement webElement, WebDriver driver){
		this._webElement = webElement;
		this._driver = driver;
	}
	
    public String getId()
    {
        return _webElement.getAttribute("id"); 
    }

    /// <summary>
    /// Gets the parent.
    /// </summary>
    public CWebAutomationElement getParent()
    {
        return new CWebAutomationElement(_webElement.findElement(By.xpath("..")), _driver);
    }

    /// <summary>
    /// Gets the ClassName.
    /// </summary>
    public String getClassName()
    {
        return _webElement.getAttribute("class").trim();
    }

    /// <summary>
    /// Gets the style.
    /// </summary>
    public CStyle getStyle()
    {
        return new CStyle(_webElement); 
    }

    /// <summary>
    /// Gets a value indicating whether the element is displayed.
    /// </summary>
    public boolean isDisplayed()
    {
            try
            {
                return isExists() ? _webElement.isDisplayed() : false;
            }
            catch (NoSuchElementException  e)
            {
                return false;
            }
    }

    /// <summary>
    /// Gets a value indicating whether the element is enabled.
    /// </summary>
    public boolean isEnabled()
    {
        return _webElement.isEnabled(); 
    }

    /// <summary>
    /// Gets a value indicating whether the element is disabled.
    /// </summary>
    public boolean isDisabled()
    {
        return !isEnabled();
    }

    /// <summary>
    /// Gets a value indicating whether the element exists.
    /// </summary>
    public boolean isExists()
    {
        return _webElement != null;
    }

    /// <summary>
    /// Gets the tagname.
    /// </summary>
    public String getTagName()
    {
        return _webElement.getTagName(); 
    }

    /// <summary>
    /// Gets the text of the element.
    /// </summary>
    public String getText()
    {
    	return (_webElement.getText() != null) ? _webElement.getText() : _webElement.getAttribute("text"); 
    }

    /// <summary>
    /// Gets a value indicating whether the element is read only.
    /// </summary>
    public boolean isReadOnly()
    {
        return getClassName().contains("readonly") || !CStringExtension.isNullOrEmpty(_webElement.getAttribute("readOnly")); 
    }

    /// <summary>
    /// Gets a value indicating whether the element is selected.
    /// </summary>
    public boolean getSelected()
    {
        return _webElement.isSelected();
    }

    /// <summary>
    /// Gets or sets a value indicating whether the element is checked.
    /// </summary>
    /*
    public boolean getChecked()
    {
        return getClassName.trim().EndsWith("checked");
   }
*/
    /// <summary>
    /// Gets the Siye.
    /// </summary>
    public Dimension getSize()
    {
        return _webElement.getSize(); 
    }

    /// <summary>
    /// Gets the location.
    /// </summary>
    public Point getLocation()
    {
        return _webElement.getLocation();
    }

    /// <summary>
    /// Gets the InnerHtml. 
    /// </summary>

    public String getInnerHtml()
    {
    		//return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", _webElement);
    	return _webElement.getAttribute("innerHTML");
    }

    /// <summary>
    /// Gets the Title.
    /// </summary>
    public String getTitle()
    {
        return _webElement.getAttribute("title");
    }

    /// <summary>
    /// Gets the Name.
    /// </summary>
    public String getName()
    {
        return _webElement.getAttribute("name");
    }

    /// <summary>
    /// Gets the Value.
    /// </summary>
    public String getValue()
    {
        return _webElement.getAttribute("value");
    }
    
    public <T extends CWebAutomationElement> T GetElement(By byContraint){
    	T element = (T)_webElement.findElement(byContraint);
    	//Todo: megnézni, ha nem találja mi legyen
    	
    	if (element == null){
    		element = (T) new CWebAutomationElement(null, _driver);    	  		
        }
    
    	return element;
    }
    
    public <T extends CWebAutomationElement> List<T> GetElements(By byContraint){
    	
    	//Todo: megnézni, ha nem találja mi legyen
    	return (List<T>)_webElement.findElements(byContraint);
    }
}
