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
		return getMainWindow().getControls().getSelect(By.tagName("select"));
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		return true;
	}

}
