package PageObjectBase;

import Browsers.CWebBrowser;

abstract public class CControlBase {
	
	private CWebBrowser _browser;
    
	public CControlBase(CWebBrowser browser){
		this._browser = browser;
	}
	
	protected abstract FrameIdProvider getIdProvider();

	

	protected CWebBrowser getMainWindow(){
		_browser.detacheFrame();
		_browser.refreshDocument();
		return _browser;
	}
	
	protected CWebBrowser getFrame(){
		_browser.detacheFrame();
		_browser.attachToFrame(getIdProvider().getFrameId());
		_browser.refreshDocument();
		return _browser;
	}
	
	protected CWebBrowser getBrowser() {
		return _browser;
	}
	
}
