package Browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;

import Controls.CAlertDialog;
import Controls.CConfirmDialog;
import Controls.CWebAutomationElement;
import Controls.CWebInput;

public class CWebBrowser extends CWebAutomationElement implements WebBrowser {

	private CWebBrowser(WebElement webElement, WebDriver driver) {
		super(webElement, driver);
		// TODO Auto-generated constructor stub
	}

	private WebDriver driver;
    private Actions actions;
    private JavascriptExecutor scriptExecutor;
    private Mouse mouse;
    private Keyboard keyboard;
    private CAlertDialog _alertDialog;
    private CConfirmDialog _confirmDialog;
	
	
	public CWebBrowser(WebDriver driver){
		this(driver.findElement(By.xpath("/*")), driver);
		this.setDriver(driver);
		setActions(new Actions(getDriver()));
		setMouse(((HasInputDevices)getDriver()).getMouse());
		setKeyboard(((HasInputDevices)getDriver()).getKeyboard());
		setScriptExecutor(((JavascriptExecutor)getDriver()));
		setAlertDialog(new CAlertDialog(getDriver()));
		setConfirmDialog(new CConfirmDialog(getDriver()));
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}
	

   //Properties
	public CAlertDialog getAlertDialog() {
		return _alertDialog;
	}


	private void setAlertDialog(CAlertDialog _alertDialog) {
		this._alertDialog = _alertDialog;
	}


	public CConfirmDialog getConfirmDialog() {
		return _confirmDialog;
	}


	private void setConfirmDialog(CConfirmDialog _confirmDialog) {
		this._confirmDialog = _confirmDialog;
	}


	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebDriver getDriver() {
		return driver;
	}

	public Actions getActions() {
		return actions;
	}


	public void setActions(Actions actions) {
		this.actions = actions;
	}


	public JavascriptExecutor getScriptExecutor() {
		return scriptExecutor;
	}

	private void setScriptExecutor(JavascriptExecutor javascriptExecutor){
		scriptExecutor = javascriptExecutor;
	}	

	private void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}


	private void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	// Properties End
	
	//Functions
	
	public String getHtml(){
		return getDriver().getPageSource();
	}
	
	public String getTitle(){
		return getDriver().getTitle();
	}
	
	public String getUrl(){
		return getDriver().getCurrentUrl();
	}
	
    public void goTo(String url)
    {
    	this.driver.navigate().to(url);
    	this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    	this.refreshDocument();
    }

    /// <summary>
    /// Calles back on browser.
    /// </summary>
    public void back()
    {
    	this.driver.navigate().back();
    }

    /// <summary>
    /// Calles forward on browser.
    /// </summary>
    public void forward()
    {
    	this.driver.navigate().forward();
    }

    /// <summary>
    /// Calles refresh on browser.
    /// </summary>
    public void refresh()
    {
        this.driver.navigate().refresh();
    }
	
	public void close(){
		this.driver.close();
	}
	
	public CWebAutomationElement getDocument()
	{
		return new CWebAutomationElement(driver.findElement(By.xpath("/*")), driver);
	}
	
	public void refreshDocument()
	{
		super.refreshDocument();
	}

    public CWebInput getWebInput(By byConstraint)
    {
    	refreshDocument();
    	return new CWebInput(getWebElement().findElement(byConstraint), driver);
    }
	
}
