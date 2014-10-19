import org.junit.*;
import org.openqa.selenium.*;

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