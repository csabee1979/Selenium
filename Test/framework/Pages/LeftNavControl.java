package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlLink;
import PageObjectBase.CControlBase;
import PageObjectBase.FrameIdProvider;

public class LeftNavControl extends CControlBase {

	public LeftNavControl(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean getDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}
	
	private HtmlLink getDeploymentLink() {
		return  getMainWindow().getDocument().getElement(HtmlLink.class, By.id("deployment"));
	}
	
	public DeploymentPage goToDeploymentPage(){
		getDeploymentLink().click();
		return new DeploymentPage(getBrowser());
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}
}
