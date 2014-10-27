package Pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Browsers.CWebBrowser;
import Controls.CWebButton;
import Controls.CWebInput;

public class CGooglePage extends CPageBase {

	public CGooglePage(CWebBrowser browser) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(browser);
		// TODO Auto-generated constructor stub
		init();
	}

	private CWebInput searchBox;
	private CWebButton searchButton;
	

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
		searchBox = browser.getElement(CWebInput.class, By.name("q"));//browser.getWebInput(By.name("q"));
		searchButton = browser.getElement(CWebButton.class, By.name("btnG"));//browser.getWebButton(By.name("btnG"));
	}
}
