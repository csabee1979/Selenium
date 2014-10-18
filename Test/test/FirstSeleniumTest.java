import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSeleniumTest extends CTestBase {
// Search using keyword through Google search
	  @Test
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
	  
	  /*
	  @Test
	  public void OnlyTest(){
		  final String dir = System.getProperty("user.dir");
	       System.out.println("current dir = " + dir);
	  }
	  */
  }