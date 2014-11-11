import org.junit.Test;

import Configuration.DefaultConfigurationSettings;
import PageObjectBase.PageLoader;
import Pages.CentralPage;
import Pages.LoginPage;


public class TestUser extends CTestBase {
	@Test
	public void checkUserPage () throws Exception{
		browser.goTo(DefaultConfigurationSettings.getDefaultUrl());
		LoginPage loginPage = PageLoader.loadPage(LoginPage.class, browser);
		CentralPage centralPage = loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword()); 
		centralPage.goToUsers().getCheckBoxes();
		Thread.sleep(5000);
	}
}
