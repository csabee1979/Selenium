import org.junit.Test;

import PageObjectBase.PageLoader;
import Pages.CLocalhostIndexPage;
import TestRunnerUtils.TestRunner;
import TestRunnerUtils.TestRunnerFrame;


public class CheckBoxTest extends CTestBase {
	
	@Test
	public void verifyChecboxesAndRadioButtonsTest(){
		
		TestRunnerFrame.runTest(new TestRunner() {		
			@Override
			public void run() throws Exception {
				verifyChecboxesAndRadioButtons();			
			}
		});
	}
	
	private void verifyChecboxesAndRadioButtons() throws InterruptedException{
		browser.goTo("http://localhost");
		CLocalhostIndexPage local = PageLoader.loadPage(CLocalhostIndexPage.class, browser);
		local.selectAllCheckboxes();
		local.setRadioButtons();
		local.selectTableHeaders();
	}
}
