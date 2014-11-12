package Controls;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class WebElementsUtils {

	private  WebElementsUtils(){
	
	}
	
	public static List<By> getDefaultLocator(String elementClassName) {
		
		List<By> elementLocators = new ArrayList<By>();
		
		switch (elementClassName){
			case "Controls.HtmlBody" :
				elementLocators.add(By.tagName("form"));
				break;
			case "Controls.HtmlForm" : 
				elementLocators.add(By.tagName("form"));
				break;
			case "Controls.HtmlFrame" :
				elementLocators.add(By.tagName("frame"));
				break;
			case "Controls.HtmlInput" :
				elementLocators.add(By.tagName("input"));
				break;
			case "Controls.HtmlButton" :
				elementLocators.add(By.tagName("button"));
				break;
			case "Controls.HtmlCheckBox" :
				elementLocators.add(By.cssSelector("input[type='checkbox']"));
				break;
			case "Controls.HtmlRadioButton" : 
				elementLocators.add(By.cssSelector("input[type='radio']"));
				break;
			case "Controls.HtmlLink" :
				elementLocators.add(By.tagName("a"));
				break;
			case "Controls.HtmlOption" :
				elementLocators.add(By.tagName("option"));
				break;
			case "Controls.HtmlSelect" : 
				elementLocators.add(By.tagName("select"));
				break;
			case "Controls.HtmlDiv" :
				elementLocators.add(By.tagName("div"));
				break;
			case "Controls.HtmlImage" : 
				elementLocators.add(By.tagName("img"));
				break;
			case "Controls.HtmlTable" : 
				elementLocators.add(By.tagName("table"));
				break;
			case "Controls.HtmlTableBody" : 
				elementLocators.add(By.tagName("tbody"));
				break;
			case "Controls.HtmlTableRow" : 
				elementLocators.add(By.tagName("tr"));
				break;
			case "Controls.HtmlTableCell" : 
				elementLocators.add(By.tagName("td"));
				break;
			case "Controls.HtmlTableHeaderCell" : 
				elementLocators.add(By.tagName("th"));
				break;
			case "Controls.HtmlTextArea" : 
				elementLocators.add(By.tagName("textarea"));
				break;
			case "Controls.HtmlListElement" : 
				elementLocators.add(By.tagName("li"));
				break;
			case "Controls.HtmlOrderedList" : 
				elementLocators.add(By.tagName("ol"));
				break;
			case "Controls.HtmlUnorderedList" :
				elementLocators.add(By.tagName("ul"));
				break;				
			case "Controls.HtmlDefinitionList" : 
				elementLocators.add(By.tagName("dl"));				
				break;
			case "Controls.HtmlDefinitionListElement" : 
				elementLocators.add(By.tagName("dd"));		
				elementLocators.add(By.tagName("dt"));	
				break;
				
			
		default:
			throw new RuntimeException("Unknown element!");
		}
		
		return  elementLocators;
	}
}
