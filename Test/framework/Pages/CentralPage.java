package Pages;

import Browsers.CWebBrowser;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class CentralPage  extends CPageBase {

	public CentralPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	
	private LeftNavControl _leftNavControl;

	public DeploymentPage goToDeployment(){
		if (_leftNavControl == null){
			_leftNavControl = new LeftNavControl(getBrowser());
		}
		
		return _leftNavControl.goToDeploymentPage();
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
