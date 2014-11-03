package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class LoginPage extends CPageBase{

	public LoginPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getDisplayed() {
		try {
			getLoginButton().waitForElementToBeVisible();
			return true;
		}
		catch(Exception e) {
			return false;
		}	
	}
	
	private HtmlButton getLoginButton(){
		return getMainWindow().getDocument().getElement(HtmlButton.class, By.className("btn-login"));
	}
	
	public ClsLoginPage goToClsLogin(){
		getLoginButton().waitForElementToBeVisible();
		getLoginButton().javaScriptClick();
		return new ClsLoginPage(getBrowser());
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}
}
