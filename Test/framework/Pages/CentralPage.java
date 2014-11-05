package Pages;

import Browsers.CWebBrowser;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class CentralPage  extends CPageBase {

	public CentralPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	

	private LeftNavControl getLeftNavControl(){
		return new LeftNavControl(getBrowser());
	}

	public DeploymentPage goToDeployment(){
		return getLeftNavControl().goToDeploymentPage();
	}
	
	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		return getLeftNavControl().isDeploymentLinkDisplayed();
	}

}
