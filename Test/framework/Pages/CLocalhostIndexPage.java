package Pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlSelect;
import PageObjectBase.CPageBase;

public class CLocalhostIndexPage extends CPageBase{

	public CLocalhostIndexPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean IsDisplayed() {
		return getSelect().isDisplayed();
	}
	
	public void selectByName(String name) {
		getSelect().selecOptiontByVisibleText(name);
	}

	private HtmlSelect getSelect() {
		return browser.getElement(HtmlSelect.class, By.tagName("select"));
	}

}
