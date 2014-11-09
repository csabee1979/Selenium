package Controls;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlControlBuilder {
	
	private WebElement _webElement;
	private WebDriver _driver;
	
	public HtmlControlBuilder(WebElement webElement, WebDriver driver){
		setWebElement(webElement);
		setDriver(driver);
	}
	
	private void setWebElement(WebElement webElement){
		_webElement = webElement;
	}

	private WebElement getWebElement(){
		return _webElement;
	}

	private void setDriver(WebDriver driver) {
		_driver = driver;
	}

	private WebDriver getDriver() {
		return _driver;
	}

    public HtmlBody getBody(final By byLocator) {
    	return getElement(HtmlBody.class, byLocator);	    		
    }
    
    public HtmlForm getForm(final By byLocator) {
    	return getElement(HtmlForm.class, byLocator);	    		
    }

    public HtmlDiv getDiv(final By byLocator) {
    	return getElement(HtmlDiv.class, byLocator);	    		
    }
   
    public HtmlButton getButton(final By byLocator) {
    	return getElement(HtmlButton.class, byLocator);	    		
    }
	    
	public HtmlInput getInput(final By byLocator){
		return getElement(HtmlInput.class, byLocator);	    		
	}
	
	public HtmlImage getImage(final By byLocator){
		return getElement(HtmlImage.class, byLocator);	    		
	}
	 
    public HtmlSelect getSelect(final By byLocator){
    	return getElement(HtmlSelect.class, byLocator);	    		
    }
	    
    public HtmlOption getOptions(final By byLocator){
    	return getElement(HtmlOption.class, byLocator);	    		
    }
    
    public HtmlLink getLink(final By byLocator){
    	return getElement(HtmlLink.class, byLocator);	    		
    }
	
    public HtmlCheckBox getCheckBox(final By byLocator){
    	return getElement(HtmlCheckBox.class, byLocator);	    		
    }
    
    public List<HtmlBody> getBodys(){
    	return getAllElements(HtmlBody.class);	    		
    }
    
    public List<HtmlForm> getForms(){
    	return getAllElements(HtmlForm.class);	    		
    }
    
    public List<HtmlDiv> getDivs(){
    	return getAllElements(HtmlDiv.class);	    		
    }
    
    public List<HtmlButton> getButtons(){
    	return getAllElements(HtmlButton.class);	    		
    }
	    
	public List<HtmlInput> getInputs(){
		return getAllElements(HtmlInput.class);	    		
	}
	
	public List<HtmlImage> getImages(){
		return getAllElements(HtmlImage.class);	    		
	}
	
    public List<HtmlSelect> getSelects(){
    	return getAllElements(HtmlSelect.class);	    		
    }
	    
    public List<HtmlOption> getOptions(){
    	return getAllElements(HtmlOption.class);	    		
    }
    
    public List<HtmlLink> getLinks(){
    	return getAllElements(HtmlLink.class);	    		
    }
    
    public List<HtmlCheckBox> getCheckBoxes(){
    	return getAllElements(HtmlCheckBox.class);	    		
    }
    
    public WebElement getWebElement(final By byConstraint){
        return  _webElement.findElement(byConstraint);   	
    }
    

    private <T extends HtmlElementBase> List<T> getAllElements(Class<T> element) {
    	String className = element.getName();   	
        By defaultLocating = WebElementsUtils.getDefaultLocator(className);
    	
    	return getElements(element, defaultLocating);
    }
	    
    private <T extends HtmlElementBase> List<T> getElements(Class<T> element, final By byConstraint)  { //Todo: elegánsabb hiba kezelés   	
		System.out.println(element.getName());
		
		List<WebElement> webElementList = getWebElement().findElements(byConstraint);
		List<T> htmlElementList = new ArrayList<T>();
		
		for (WebElement webElement : webElementList){
			htmlElementList.add(getElementWithWait(element, webElement, byConstraint));
		}
		
		return htmlElementList;
	}
	
	private <T extends HtmlElementBase> T getElement(Class<T> element, final By byConstraint)  { //Todo: elegánsabb hiba kezelés   	
	    	System.out.println(element.getName());
	    	return getElementWithWait(element, getWebElement().findElement(byConstraint) ,byConstraint);
	    }
	   
		private <T extends HtmlElementBase> T getElementWithWait(Class<T> element, WebElement webElement, final By byConstraint) {
			try {
	    		for (int i = 0; i < 10; i++) {
	    			try {
	    				Constructor<T> constructor = element.getConstructor(WebElement.class, WebDriver.class, By.class);
	    				return constructor.newInstance( webElement, getDriver(), byConstraint);
	    			}
	    			catch (Exception e) {
	    				Thread.sleep(1000);
	    			}
	    		}
	    		
		    	Constructor<T> constructor = element.getConstructor(WebElement.class, WebDriver.class, By.class);
		    	return constructor.newInstance( webElement, getDriver(), byConstraint);
	
	    	}
	    	catch (Exception e) {
	    		System.err.println("Element not find: " + byConstraint.toString());
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	        }
	}

}
