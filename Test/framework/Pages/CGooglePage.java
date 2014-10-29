package Pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import Controls.HtmlInput;

public class CGooglePage extends CPageBase {

	public CGooglePage(CWebBrowser browser) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(browser);
		// TODO Auto-generated constructor stub
		init();
	}

	private HtmlInput searchBox;
	private HtmlButton searchButton;
	

	@Override
	boolean IsDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void search(String text){
		searchBox.TypeText(text);
		searchButton.click();
	}
	
	private void init() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		searchBox = browser.getElement(HtmlInput.class, By.name("q"));//browser.getWebInput(By.name("q"));
		searchButton = browser.getElement(HtmlButton.class, By.name("btnG"));//browser.getWebButton(By.name("btnG"));
	}
}
