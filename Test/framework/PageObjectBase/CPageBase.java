package PageObjectBase;

import java.lang.reflect.Constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Browsers.CWebBrowser;
import Controls.HtmlElementBase;

abstract public class CPageBase extends CControlBase {
	private final int timeoutInMilliseconds = 60000;
	
	public CPageBase(CWebBrowser browser){
		super(browser);
	}
	
	protected abstract boolean until();
	
	public void WaitForComplete() throws Exception{
	   long start = System.currentTimeMillis();
	    long end = start + timeoutInMilliseconds;
	    while (System.currentTimeMillis() < end)
	    {
	      if (until()) {
	        return;
	      }
	      try
	      {
	        Thread.sleep(1000);
	      }
	      catch (InterruptedException e)
	      {
	        throw new RuntimeException(e);
	      }
	    }
	    throw new RuntimeException("The page has not loaded!");
	}
	
}
