import org.junit.Test;

import PageObjectBase.PageLoader;
import Pages.CLocalhostIndexPage;
import TestRunnerUtils.TestRunner;
import TestRunnerUtils.TestRunnerFrame;


public class CheckBoxTest extends CTestBase {
	
	@Test
	public void verifyControlsTest(){
		
		TestRunnerFrame.runTest(new TestRunner() {		
			@Override
			public void run() throws Exception {
				verifyControls();			
			}
		});
	}
	
	private void verifyControls() throws InterruptedException{
		browser.goTo("http://localhost");
		CLocalhostIndexPage local = PageLoader.loadPage(CLocalhostIndexPage.class, browser);
		local.selectAllCheckboxes();
		local.setRadioButtons();
		local.selectTableHeaders();
		local.setTextArea("Az anyja mindenit!\n Azt hát!");
		local.selectDefinitions();
	}
}
