package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Browsers.CWebBrowser;
import Controls.CWebButton;
import Controls.CWebInput;

public class CGooglePage extends CPageBase {

	public CGooglePage(CWebBrowser browser) {
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
	
	private void init(){
		searchBox = browser.getDocument().getWebInput(By.name("q"));
		searchButton = browser.getDocument().getWebButton(By.name("btnG"));
	}
}
