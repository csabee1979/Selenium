package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;
import PageObjectBase.PageLoader;

public class LoginPage extends CPageBase{

	public LoginPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	
	private HtmlButton getLoginButton(){
		return getMainWindow().getDocument().getElement(HtmlButton.class, By.className("btn-login"));
	}
	
	public ClsLoginPage goToClsLogin(){
		getLoginButton().waitForElementToBeVisible();
		getLoginButton().javaScriptClick();
		return PageLoader.loadPage(ClsLoginPage.class, getBrowser());
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		getBrowser().refreshDocument();
		return getLoginButton().isDisplayed();
	}
}
