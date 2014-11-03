package Browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CBrowserFactory {
	static public CWebBrowser GetBrowser() throws InterruptedException{	
		WebDriver driver =getIE();
		Thread.sleep(3000);
		return new CWebBrowser(driver);
	}
	
	private static WebDriver getFireFox(){
		return new FirefoxDriver();
	}
	
	private static WebDriver getChrome() {
		String currentDir = System.getProperty("user.dir");
		//String chromeDriverPath = currentDir + /*File.separator +*/  "\\Framework\\Drivers\\chromedriver.exe";
		
		
		String chromeDriverRelativePath = String.format("%sFramework%sDrivers%schromedriver.exe", File.separator, File.separator, File.separator);	
		//String path = String.join(currentDir, chromeDriverRelativePath);
		String path = currentDir + chromeDriverRelativePath;
		System.setProperty("webdriver.chrome.driver", path);
		return new ChromeDriver(); 
	}
	
	private static WebDriver getIE() {
		String currentDir = System.getProperty("user.dir");
		//String chromeDriverPath = currentDir + /*File.separator +*/  "\\Framework\\Drivers\\chromedriver.exe";
	
		String ieDriverRelativePath = String.format("%sFramework%sDrivers%sIEDriverServer.exe", File.separator, File.separator, File.separator);	
		//String path = String.join(currentDir, chromeDriverRelativePath);
		String path = currentDir + ieDriverRelativePath;
		System.setProperty("webdriver.ie.driver", path);
		return new InternetExplorerDriver();
	}
}
