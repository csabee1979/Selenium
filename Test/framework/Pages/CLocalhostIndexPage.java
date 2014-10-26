package Pages;

import org.openqa.selenium.By;
import Browsers.CWebBrowser;
import Controls.CWebSelect;
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
	
	public void selectByName(String name)
	{
		getSelect().selecOptiontByVisibleText(name);
	}

	private CWebSelect getSelect(){
		return browser.getDocument().getWebSelect(By.tagName("select"));
	}

}
