package Pages;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import Controls.HtmlLink;
import PageObjectBase.CControlBase;
import PageObjectBase.CPageBase;
import PageObjectBase.CentralFrameIdProvider;
import PageObjectBase.FrameIdProvider;

public class DeploymentPage extends CPageBase {

	private FrameIdProvider frameIdProvider = new CentralFrameIdProvider();
	public DeploymentPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		
		return frameIdProvider;
	}
	
	private HtmlButton AddInstallationPackage(){
		return getFrame().getDocument().getElement(HtmlButton.class, By.cssSelector("#toolbar > div > a"));
	}

	public void goToNewDeploymentPackage() {
		AddInstallationPackage().click();	
	}

	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		getBrowser().refreshDocument();
		return AddInstallationPackage().isDisplayed();
	}
}
