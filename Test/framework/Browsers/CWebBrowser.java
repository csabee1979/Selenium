package Browsers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.thoughtworks.selenium.Wait;

import Controls.CAlertDialog;
import Controls.CConfirmDialog;
import Controls.HtmlElementBase;
import Controls.HtmlInput;

public class CWebBrowser extends HtmlElementBase implements WebBrowser {

	private CWebBrowser(WebElement webElement, WebDriver driver) {
		super(webElement, driver, By.xpath("/*"));
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

	@Override
	protected WebElement getWebElement() {
		refreshDocument();
		return _webElement;
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
    	waitForComplete(); 
        this.refreshDocument();
    }

    public void back()
    {
    	this.driver.navigate().back();
    }

    public void forward()
    {
    	this.driver.navigate().forward();
    }

    public void refresh()
    {
        this.driver.navigate().refresh();
    }
	
	public void close() {
		detacheFrame();
		this.driver.quit();
		
		try{
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");
		}
		catch (Exception e){
		}
	}
	
	public void waitForComplete() {
		try{
			waitForComplete(30);
		}
		catch(Exception e){
		}
	}
	
	public void waitForComplete(int timeout) throws Exception{

    	new FluentWait<WebDriver>(getDriver()).
        withTimeout(timeout, TimeUnit.SECONDS).
        pollingEvery(50, TimeUnit.MILLISECONDS).
        ignoring(NoSuchElementException.class).
        	until(new Predicate<WebDriver>() {
				@Override
				public boolean apply(WebDriver driver) {
			        JavascriptExecutor javascript = (JavascriptExecutor) getDriver();  
			        if (javascript == null)
			        {
			            try {
							throw new Exception("Driver must support javascript execution");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
					String readyState = javascript.executeScript("if (document.readyState) return document.readyState;").toString();
					System.out.println(readyState);
					
                    return readyState != "complete";
				}
		});
	
	}
	
	public HtmlElementBase getDocument()
	{
		return new HtmlElementBase(driver.findElement(By.xpath("/*")), driver, By.xpath("/*"));
	}
	
	public void refreshDocument()
	{
		setWebElement(driver.findElement(By.xpath("/*")));
	}

    public void attachToFrame(String frameId) {
    	getDriver().switchTo().frame(frameId);
    	refreshDocument();
    }
    
    public void detacheFrame() {
    	getDriver().switchTo().defaultContent();
    	refreshDocument();
    }
	
}
