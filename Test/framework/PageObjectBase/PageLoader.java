package PageObjectBase;

import java.lang.reflect.Constructor;
import Browsers.CWebBrowser;


public class PageLoader {
	public static <T extends CPageBase> T loadPage(Class<T> page, final CWebBrowser browser) {
		try{
			Constructor<T> constructor = page.getConstructor(CWebBrowser.class);
	    	T newPage = constructor.newInstance(browser);
	    	newPage.WaitForComplete();
	    	
	    	return newPage;
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
