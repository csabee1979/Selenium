import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Browsers.CBrowserFactory;
import Browsers.CWebBrowser;

public class CTestBase {
	protected WebDriver driver;
	protected CWebBrowser browser;
	  @Before
	  public void setUp() throws Exception {	  
		  //driver = BrowserFactory.GetBrowser();
		  browser = CBrowserFactory.GetBrowser();
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    //driver.quit();
		  browser.close();
	  }
}
