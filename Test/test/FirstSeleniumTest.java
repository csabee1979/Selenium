import java.util.List;

import junit.framework.Assert;

import org.junit.*;
import org.openqa.selenium.*;

import Browsers.CBrowserFactory;
import Browsers.CWebBrowser;
import Configuration.DefaultConfigurationSettings;
import Controls.HtmlButton;
import Controls.HtmlInput;
import Pages.CGooglePage;

public class FirstSeleniumTest extends CTestBase {
// Search using keyword through Google search
	 // @Test
	  public void testtestclass() throws Exception {
	        //Open Home Page
	        driver.get("http://www.google.com");
	        //Enter text in search box
	        driver.findElement(By.name("q")).sendKeys("selenium");
	        Thread.sleep(1000);
	        //Click Search button
	        driver.findElement(By.name("btnG")).click();
	        Thread.sleep(10000);
	  }
	  
	  //@Test
	  public void test2() throws Exception {
		  //CWebBrowser browser = CBrowserFactory.GetBrowser();
		  browser.goTo("http://www.google.com");
		  browser.refreshDocument();
		  //WebElement e = browser.getDriver().findElement(By.name("q"));
/*
		  HtmlInput el = browser.getDocument().getWebInput(By.name("q"));
		  el.TypeText("selenium");
		  
		  List<HtmlInput> inputs = browser.getDocument().getWebInputs();
		  Assert.assertEquals("selenium", el.getValue());
		  HtmlButton button = browser.getDocument().getWebButton(By.name("btnG"));
		  List<HtmlButton> buttons = browser.getDocument().getWebButtons();
		  button.click();
		  //CWebInput q = browser.<CWebInput>getElement(By.name("q"));
		  Thread.sleep(2000);
		  browser.close();
		  */
	  }
	  
	  @Test
	  public void test3() throws Exception {
		  try{
			  browser.goTo(DefaultConfigurationSettings.getDefaultUrl());
			  browser.refreshDocument();
			  //CWebInput input = browser.<CWebInput>getElement(By.name("q"));
			  /*CWebInput input = browser.getElement(CWebInput.class, By.name("q"));
			  input.TypeText("0");*/
			  CGooglePage page = new CGooglePage(browser);
			  page.search("index.hu");
		  }
		  catch(Exception e){
		  	e.printStackTrace();
		  }	  
	  }
	  
	  /*
	  @Test
	  public void OnlyTest(){
		  final String dir = System.getProperty("user.dir");
	       System.out.println("current dir = " + dir);
	  }
	  */
  }