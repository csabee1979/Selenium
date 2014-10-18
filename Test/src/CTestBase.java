import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class CTestBase {
	protected WebDriver driver;
	  @Before
	  public void setUp() throws Exception {	  
		  driver = BrowserFactory.GetBrowser();
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
