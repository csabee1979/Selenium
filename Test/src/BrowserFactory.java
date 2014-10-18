import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
	protected BrowserFactory(){	
	}
	
	public static WebDriver GetBrowser() {
		// TODO Auto-generated method stub
		WebDriver driver = GetChrome();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	private static WebDriver GetFireFox(){
		return new FirefoxDriver();
	}
	
	private static WebDriver GetChrome() {
		String currentDir = System.getProperty("user.dir");
		String chromeDriverPath = currentDir + /*File.separator +*/  "\\Framework\\Drivers\\chromedriver.exe";
		
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		return new ChromeDriver(); 
	}
}
