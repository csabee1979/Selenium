import org.junit.Test;

import Pages.CLocalhostIndexPage;


public class SelectTests extends CTestBase {
	@Test
	public void SelectTest() throws InterruptedException{
		browser.goTo("http://localhost");
		CLocalhostIndexPage indexPage = new CLocalhostIndexPage(browser);
		indexPage.selectByName("Negyedik");
		Thread.sleep(20000);
	}
}
