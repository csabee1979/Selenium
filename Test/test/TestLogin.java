import org.junit.Test;

import Browsers.CWebBrowser;
import Configuration.DefaultConfigurationSettings;
import PageObjectBase.PageLoader;
import Pages.ClsLoginPage;
import Pages.LoginPage;


public class TestLogin extends CTestBase {
	@Test
	public void login () throws Exception{
		browser.goTo("https://secure.logmein.com/");
		LoginPage loginPage = PageLoader.loadPage(LoginPage.class, browser);
		loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword());
	}
}
