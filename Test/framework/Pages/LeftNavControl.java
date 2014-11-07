package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlLink;
import PageObjectBase.CControlBase;
import PageObjectBase.FrameIdProvider;
import PageObjectBase.PageLoader;

public class LeftNavControl extends CControlBase {

	public LeftNavControl(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	
	
	private HtmlLink getDeploymentLink() {
		return  getMainWindow().getDocument().getControls().getLinks(By.id("deployment"));
	}
	
	public DeploymentPage goToDeploymentPage(){
		getDeploymentLink().click();
		return PageLoader.loadPage(DeploymentPage.class, getBrowser());
	}
	
	public boolean isDeploymentLinkDisplayed() {
		getBrowser().refreshDocument();
		return getDeploymentLink().isDisplayed();
	}
	
	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}
}
