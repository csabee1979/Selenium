package Controls;

import java.security.InvalidKeyException;

import org.openqa.selenium.By;

public class WebElementsUtils {

	private  WebElementsUtils(){
	
	}
	
	public static By getDefaultLocator(String elementClassName) {
		switch (elementClassName){
			case "Controls.HtmlBody" : return By.tagName("body");
			case "Controls.HtmlForm" : return By.tagName("form");
			case "Controls.HtmlFrame" : return By.tagName("frame");
			case "Controls.HtmlInput" : return By.tagName("input"); 
			case "Controls.HtmlButton" : return By.tagName("button");
			case "Controls.HtmlCheckBox" : return By.cssSelector("input[type='checkbox']");
			case "Controls.HtmlRadioButton" : return By.cssSelector("input[type='radio']");
			case "Controls.HtmlLink" : return By.tagName("a");
			case "Controls.HtmlOption" : return By.tagName("option");
			case "Controls.HtmlSelect" : return By.tagName("select");
			case "Controls.HtmlDiv" : return By.tagName("div");
			case "Controls.HtmlImage" : return By.tagName("img");
			case "Controls.HtmlTable" : return By.tagName("table");
			case "Controls.HtmlTableBody" : return By.tagName("tbody");
			case "Controls.HtmlTableRow" : return By.tagName("tr");
			case "Controls.HtmlTableCell" : return By.tagName("td");
			case "Controls.HtmlTableHeaderCell" : return By.tagName("th");
			case "Controls.HtmlTextArea" : return By.tagName("textarea");
			
		default:
			throw new RuntimeException("Unknown element!");
		}
	}
}
