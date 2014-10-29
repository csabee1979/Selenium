import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import Pages.CLocalhostIndexPage;


public class SelectTests extends CTestBase {
	@Test
	public void SelectTest() {
		browser.goTo("http://localhost");
		CLocalhostIndexPage indexPage = new CLocalhostIndexPage(browser);
		indexPage.selectByName("Negyedik");
	}
}
