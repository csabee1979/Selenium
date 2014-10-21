package Controls;

import org.openqa.selenium.WebElement;

public class CStyle
{
    private WebElement _element;


    public CStyle(WebElement element)
    {
        _element = element;
    }

    public String isDisplay()
    {
        return _element.getCssValue("display");
    }

    public String getZIndex()
    {
        return _element.getCssValue("z-index"); 
    }

    public String getTop()
    {
        return _element.getCssValue("top"); 
    }

    public String getColor()
    {
         return _element.getCssValue("color"); 
    }

    public String getWidth()
    {
        return _element.getCssValue("width");
    }


    public String GetAttributeValue(String attributeName)
    {
        return _element.getCssValue(attributeName);
    }
}

