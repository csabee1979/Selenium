import org.junit.Test;
import org.testng.Assert;

import Configuration.DefaultConfigurationSettings;
import Pages.CentralPage;
import Pages.DeploymentPage;
import Pages.LoginPage;


public class TestDeployment extends CTestBase {
	@Test
	public void checkDeploymentpage () throws Exception{
		browser.goTo("https://secure.logmein.com/");
		LoginPage loginPage = new LoginPage(browser);
		loginPage.WaitForComplete();
		loginPage.goToClsLogin().login(DefaultConfigurationSettings.getDefaultEmail(), DefaultConfigurationSettings.getDefaultPassword());
		CentralPage centralPage = new CentralPage(browser);
		centralPage.WaitForComplete();
		DeploymentPage deploymentPage = centralPage.goToDeployment();
		deploymentPage.WaitForComplete();
		deploymentPage.goToNewDeploymentPackage();
	}
}
