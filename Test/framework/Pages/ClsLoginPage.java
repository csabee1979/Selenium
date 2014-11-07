package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import Controls.HtmlInput;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;
import PageObjectBase.PageLoader;

public class ClsLoginPage extends CPageBase {

	public ClsLoginPage(CWebBrowser browser) {
		super(browser);
	}

	private HtmlInput getEmail() {
		return getMainWindow().getDocument().getControls().getInput(By.id("email"));
	}

	private HtmlInput getPassword() {
		return getMainWindow().getDocument().getControls().getInput(By.id("password"));
	}

	private HtmlButton getLoginButton() {
		return getMainWindow().getDocument().getControls().getButton(By.id("btnSubmit"));
	}

	public CentralPage login(String email, String password){
		getLoginButton().waitForElementToBeVisible();
		getEmail().TypeText(email);
		getPassword().TypeText(password);
		getLoginButton().click();
		return PageLoader.loadPage(CentralPage.class, getBrowser());
	}
	
	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		return getLoginButton().isDisplayed();
	}	

}

