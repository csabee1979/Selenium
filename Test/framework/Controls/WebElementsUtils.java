package Controls;

import java.security.InvalidKeyException;

import org.openqa.selenium.By;

public class WebElementsUtils {

	private  WebElementsUtils(){
	
	}
	
	public static By getDefaultByConstraint(String elementClassName) {
		switch (elementClassName){
			case "Controls.HtmlInput" : return By.tagName("input"); 
			case "Controls.HtmlButton" : return By.tagName("button");
			case "Controls.HtmlLink" : return By.tagName("a");
			case "Controls.Option" : return By.tagName("option");
			case "Controls.Select" : return By.tagName("select");

		default:
			throw new RuntimeException("Unknown element!");
		}
	}
}
