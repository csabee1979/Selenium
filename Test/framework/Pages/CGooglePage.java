package Pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Browsers.CWebBrowser;
import Controls.HtmlButton;
import Controls.HtmlElementBase;
import Controls.HtmlInput;
import PageObjectBase.CPageBase;
import PageObjectBase.FrameIdProvider;

public class CGooglePage extends CPageBase {

	public CGooglePage(CWebBrowser browser) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	
	//setIdProvider();
	

	public void search(String text){
		getSearchBox().TypeText(text);
		getFakeBox().waitUntilButtonToBeVisible(10);
		getSearchButton().click();
	}
	
	private HtmlElementBase getSearchButton() {
		// TODO Auto-generated method stub
		return getMainWindow().getDocument().getControls().getButton(By.name("btnG"));
	}

	private HtmlInput getSearchBox() {
		// TODO Auto-generated method stub
		return getMainWindow().getDocument().getControls().getInput(By.name("q"));
	}
	
	private HtmlInput getFakeBox() {
		// TODO Auto-generated method stub
		return getMainWindow().getDocument().getControls().getInput(By.name("aaaaa"));
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
}
