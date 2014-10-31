import org.junit.Test;

import Browsers.CWebBrowser;
import Configuration.DefaultConfigurationSettings;
import Pages.ClsLoginPage;
import Pages.LoginPage;


public class TestLogin extends CTestBase {
	@Test
	public void login () throws Exception{
		browser.goTo("https://secure.logmein.com/");
		LoginPage loginPage = new LoginPage(browser);
		loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword());
	}
}
