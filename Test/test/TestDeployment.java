import org.junit.Test;
import org.testng.Assert;

import Configuration.DefaultConfigurationSettings;
import PageObjectBase.PageLoader;
import Pages.CentralPage;
import Pages.DeploymentPage;
import Pages.LoginPage;
import TestRunnerUtils.TestRunner;
import TestRunnerUtils.TestRunnerFrame;


public class TestDeployment extends CTestBase {
	@Test
	public void verifyDeploymentPage(){
		TestRunnerFrame.runTest(new TestRunner() {		
			@Override
			public void run() throws Exception {
				checkDeploymentpage();				
			}
		});
	}
	
	private  void checkDeploymentpage () throws Exception{
		browser.goTo(DefaultConfigurationSettings.getDefaultUrl());
		LoginPage loginPage = PageLoader.loadPage(LoginPage.class, browser);
		CentralPage centralPage = loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword()); 
		centralPage.goToDeployment().goToNewDeploymentPackage();
	}
}
