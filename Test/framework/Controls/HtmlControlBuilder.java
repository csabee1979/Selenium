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
    
    public HtmlRadioButton getRadioButton(final By byLocator){
    	return getElement(HtmlRadioButton.class, byLocator);	    		
    }
    
    public HtmlTable getTable(final By byLocator){
    	return getElement(HtmlTable.class, byLocator);	    		
    }
    
    public HtmlTableBody getTableBody(final By byLocator){
    	return getElement(HtmlTableBody.class, byLocator);	    		
    }

    public HtmlTableRow getTableRow(final By byLocator){
    	return getElement(HtmlTableRow.class, byLocator);	    		
    }

    public HtmlTableCell getTableCell(final By byLocator){
    	return getElement(HtmlTableCell.class, byLocator);	    		
    }

    public HtmlTableHeaderCell getTableHeaderCell(final By byLocator){
    	return getElement(HtmlTableHeaderCell.class, byLocator);	    		
    }
    
    public HtmlTextArea getTextArea(final By byLocator){
    	return getElement(HtmlTextArea.class, byLocator);
    }
    
    public HtmlDefinitionList getDefinitionList(final By byLocator){
    	return getElement(HtmlDefinitionList.class, byLocator);
    }
    
    public HtmlDefinitionListElement getDefinitionListElement(final By byLocator){
    	return getElement(HtmlDefinitionListElement.class, byLocator);
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
    
    public List<HtmlRadioButton> getRadioButtons(){
    	return getAllElements(HtmlRadioButton.class);	    		
    }

    public List<HtmlTable> getTables(){
    	return getAllElements(HtmlTable.class);	    		
    }
    
    public List<HtmlTableBody> getTableBodys(){
    	return getAllElements(HtmlTableBody.class);	    		
    }

    public List<HtmlTableRow> getTableRows(){
    	return getAllElements(HtmlTableRow.class);	    		
    }
    
    public List<HtmlTableCell> getTableCells(){
    	return getAllElements(HtmlTableCell.class);	    		
    }
    
    public List<HtmlTableHeaderCell> getTableHeaderCells(){
    	return getAllElements(HtmlTableHeaderCell.class);	    		
    }
    
    public List<HtmlTextArea> getTextAreas(){
    	return getAllElements(HtmlTextArea.class);
    }
    
    public List<HtmlDefinitionList> getDefinitionLists(){
    	return getAllElements(HtmlDefinitionList.class);
    }
    
    public List<HtmlDefinitionListElement> getDefinitionListElements(){
    	return getAllElements(HtmlDefinitionListElement.class);
    }
    
    public WebElement getWebElement(final By byConstraint){
        return  _webElement.findElement(byConstraint);   	
    }
    

    private <T extends HtmlElementBase> List<T> getAllElements(Class<T> element) {
    	String className = element.getName();   	
        List<By> defaultLocatingList = WebElementsUtils.getDefaultLocator(className);
    	
    	return getElements(element, defaultLocatingList);
    }
	    
    private <T extends HtmlElementBase> List<T> getElements(Class<T> element, final List<By> byLocatorList)  { //Todo: elegánsabb hiba kezelés   	
		System.out.println(element.getName());
		List<T> htmlElementList = new ArrayList<T>();
		
		for(By byLocator :  byLocatorList) {		
			List<WebElement> webElementList = getWebElement().findElements(byLocator);
			
			for (WebElement webElement : webElementList){
				htmlElementList.add(getElementWithWait(element, webElement, byLocator));
			}
		}
		
		return htmlElementList;
	}
	
	private <T extends HtmlElementBase> T getElement(Class<T> element, final By byLocator)  { //Todo: elegánsabb hiba kezelés   	
	    	System.out.println(element.getName());
	    	return getElementWithWait(element, getWebElement().findElement(byLocator) ,byLocator);
	    }
	   
	private <T extends HtmlElementBase> T getElementWithWait(Class<T> element, WebElement webElement, final By byLocator) {
		try {
    		for (int i = 0; i < 10; i++) {
    			try {
    				Constructor<T> constructor = element.getConstructor(WebElement.class, WebDriver.class, By.class);
    				return constructor.newInstance( webElement, getDriver(), byLocator);
    			}
    			catch (Exception e) {
    				Thread.sleep(1000);
    			}
    		}
    		
	    	Constructor<T> constructor = element.getConstructor(WebElement.class, WebDriver.class, By.class);
	    	return constructor.newInstance( webElement, getDriver(), byLocator);

    	}
    	catch (Exception e) {
    		System.err.println("Element not find: " + byLocator.toString());
    		e.printStackTrace();
    		throw new RuntimeException(e);
        }
	}

}
