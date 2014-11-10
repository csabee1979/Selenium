import org.junit.Test;

import Browsers.CWebBrowser;
import Configuration.DefaultConfigurationSettings;
import PageObjectBase.PageLoader;
import Pages.ClsLoginPage;
import Pages.LoginPage;
import TestRunnerUtils.TestRunner;
import TestRunnerUtils.TestRunnerFrame;


public class TestLogin extends CTestBase {
	@Test
	public void verifyLogin () throws Exception{
		TestRunnerFrame.runTest(new TestRunner() {			
			@Override
			public void run() throws Exception {
				login();	
			}
		});
	}
	
	
	private void login() throws Exception{ 
		browser.goTo(DefaultConfigurationSettings.getDefaultUrl());
		LoginPage loginPage = PageLoader.loadPage(LoginPage.class, browser);
		loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword());
	}
}
