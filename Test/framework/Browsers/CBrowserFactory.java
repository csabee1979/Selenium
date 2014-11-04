package Browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CBrowserFactory {
	static public CWebBrowser GetBrowser() throws InterruptedException{	
		WebDriver driver = getIE();
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
		String ieDriverRelativePath;
		/*
		if (is64Bit()){
			ieDriverRelativePath = String.format("%sFramework%sDrivers%sx64%sIEDriverServer.exe", File.separator, File.separator, File.separator, File.separator);
		}
		else {
			ieDriverRelativePath = String.format("%sFramework%sDrivers%sIEDriverServer.exe", File.separator, File.separator, File.separator);
		}
		*/
		ieDriverRelativePath = String.format("%sFramework%sDrivers%sIEDriverServer.exe", File.separator, File.separator, File.separator);
        DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
        capab.setCapability(
            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
            true);
		
		//String path = String.join(currentDir, chromeDriverRelativePath);
		String path = currentDir + ieDriverRelativePath;
		System.setProperty("webdriver.ie.driver", path);
		return new InternetExplorerDriver(capab);
	}
	
	
	private static boolean is64Bit(){
		boolean is64bit = false;
		if (System.getProperty("os.name").contains("Windows")) {
		    is64bit = (System.getenv("ProgramFiles(x86)") != null);
		} else {
		    is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
		}
		
		return is64bit;
	}
}
