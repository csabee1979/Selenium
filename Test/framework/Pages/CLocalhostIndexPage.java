package Pages;

import java.util.List;

import org.openqa.selenium.By;

import Browsers.CWebBrowser;
import Controls.HtmlCheckBox;
import Controls.HtmlRadioButton;
import Controls.HtmlSelect;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class CLocalhostIndexPage extends CPageBase{

	public CLocalhostIndexPage(CWebBrowser browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}


	public void selectByName(String name) {
		getSelect().selecOptiontByVisibleText(name);
	}

	public void selectAllCheckboxes() throws InterruptedException{
		List<HtmlCheckBox> checkBoxes = getMainWindow().getDocument().getControls().getDivs().get(2).getControls().getCheckBoxes();
		
		for (HtmlCheckBox cb : checkBoxes){
			cb.setChecked();
			
			Thread.sleep(2000);
		}
		
	}
	
	private HtmlSelect getSelect() {
		return getMainWindow().getControls().getSelect(By.tagName("select"));
	}

	@Override
	protected FrameIdProvider getIdProvider() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected boolean until() {
		// TODO Auto-generated method stub
		return true;
	}


	public void setRadioButtons() throws InterruptedException {
		// TODO Auto-generated method stub
		List<HtmlRadioButton> radioButtons = getMainWindow().getDocument().getControls().getRadioButtons();
		
		for (HtmlRadioButton rb : radioButtons){
			rb.setChecked(true);
			
			Thread.sleep(2000);
		}
	}

}
