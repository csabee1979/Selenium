package Controls;

import java.security.InvalidKeyException;

import org.openqa.selenium.By;

public class WebElementsUtils {

	private  WebElementsUtils(){
	
	}
	
	public static By getDefaultByConstraint(String elementClassName) {
		switch (elementClassName){
			case "Controls.HtmlBody" : return By.tagName("body");
			case "Controls.HtmlForm" : return By.tagName("form");
			case "Controls.HtmlInput" : return By.tagName("input"); 
			case "Controls.HtmlButton" : return By.tagName("button");
			case "Controls.HtmlLink" : return By.tagName("a");
			case "Controls.HtmlOption" : return By.tagName("option");
			case "Controls.HtmlSelect" : return By.tagName("select");
			case "Controls.HtmlDiv" : return By.tagName("div");

		default:
			throw new RuntimeException("Unknown element!");
		}
	}
}
