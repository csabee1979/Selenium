package Controls;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class CDialog {
	private WebDriver _driver;
	
	public CDialog(WebDriver driver) {
		setDriver(driver);
	}

	private WebDriver getDriver() {
		return _driver;
	}

	private void setDriver(WebDriver driver) {
		this._driver = driver;
	}
	
	/**
	 * @return  The text of alert dialog
	 */
	public String getText(){
		return getDriver().switchTo().alert().getText();
	}
	
    /**
     * @return Indicating whether Dialog exists
     */
    public boolean isDialogExists()
    {
        try
        {
        	getDriver().switchTo().alert().getText();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    /**
     * Press the OK
     */
    public void ok()
    {
    	getDriver().switchTo().alert().accept();
    }

    /**
     * Press the Cancel
     */
    public void cancel()
    {
    	getDriver().switchTo().alert().dismiss();
    }
}
