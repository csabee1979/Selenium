import org.junit.Test;
import org.testng.Assert;

import Configuration.DefaultConfigurationSettings;
import PageObjectBase.PageLoader;
import Pages.CentralPage;
import Pages.DeploymentPage;
import Pages.LoginPage;


public class TestDeployment extends CTestBase {
	@Test
	public void checkDeploymentpage () throws Exception{
		browser.goTo("https://secure.logmein.com/");
		LoginPage loginPage = PageLoader.loadPage(LoginPage.class, browser);
		CentralPage centralPage = loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword()); 
		centralPage.goToDeployment().goToNewDeploymentPackage();
	}
}
