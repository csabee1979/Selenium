package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlSelect;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class CLocalhostIndexPage extends CPageBase{

	public CLocalhostIndexPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}


	public void selectByName(String name) {
		getSelect().selecOptiontByVisibleText(name);
	}

	private HtmlSelect getSelect() {
		return getMainWindow().getElement(HtmlSelect.class, By.tagName("select"));
	}

	@Override
	public boolean getDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}

}
