package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.BasePage;
import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasesActions
{
    private BasePage currentPage;
    WebDriver driver = getDriver();

    @Step( "Enters '{1}' in field {0}" )
    protected void fillsFieldWithData( WebElementFacade fieldElement,
                                       String data )
    {
        if ( data != null )
        {
            fieldElement.waitUntilEnabled()
                        .type( data );
        }
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByValue( WebElementFacade dropDownElement,
                                                     String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByValue( itemValue );
        }
    }

    protected void fillsFieldWithData( By fieldElement,
                                       String data )
    {
        fillsFieldWithData( (WebElementFacade) currentPage.find( fieldElement ),
                            data );
    }

    protected void selectsFromDropDownAnItemByValue( By dropDownLocator,
                                                     String itemValue )
    {
        this.selectsFromDropDownAnItemByValue( (WebElementFacade) currentPage.find( dropDownLocator ),
                                               itemValue );
    }

    protected void selectsFromDropDownAnItemByVisibleText( By dropDownLocator,
                                                           String itemValue )
    {
        this.selectsFromDropDownAnItemByVisibleText( (WebElementFacade) currentPage.find( dropDownLocator ),
                                                     itemValue );
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByVisibleText( WebElementFacade dropDownElement,
                                                           String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByVisibleText( itemValue );
        }
    }

    @Step
    public void clicksOn( WebElementFacade buttonOrLink ) throws InterruptedException {
        buttonOrLink.waitUntilClickable()
                    .click();
        Thread.sleep(3000);
    }

    @Step
    public boolean canSeeElement( WebElementFacade webElement )
    {
        return webElement.isVisible();
    }

    @Step
    public String readsTextFrom( WebElementFacade webElement )
    {
        return webElement.waitUntilVisible()
                         .getText()
                         .trim();
    }

    @Step
    public void clicksOn( final By locator ) throws InterruptedException {
        currentPage.find( locator )
                   .waitUntilClickable()
                   .click();
        Thread.sleep(3000);
    }

    public String readsTextFrom( By locator )
    {
        return readsTextFrom( (WebElementFacade) currentPage.find( locator ) );
    }

    @Step
    public List<String> readsTextFromList( By listItemsLocator )
    {
        List<WebElementFacade> errorsItemsElements = currentPage.findAll( listItemsLocator );
        List<String> errorMessages = new ArrayList<>( errorsItemsElements.size() );

        for ( WebElementFacade item : errorsItemsElements )
        {
            errorMessages.add( item.getText()
                                   .trim() );
        }
        return errorMessages;
    }
    @Step
    public void shouldBeOnPage(String pageURL) {

        String urlToCompareTo = driver.getCurrentUrl();

        Assert.assertEquals(pageURL, urlToCompareTo);
    }
    @Step
    public void shouldSeePageTitle(String pageTitle) {

        String titleToCompareTo = driver.getTitle();

        Assert.assertEquals(pageTitle, titleToCompareTo);
    }

    @Step
    public List<WebElementFacade> getsElementList(By locator) {

        List<WebElementFacade> listOfElements = currentPage.findAll(locator);
        //System.out.println("Number of elements found: " +(listOfElements.size() ) );

        return listOfElements;
    }

    @Step
    public void movesPointerToElement(WebElementFacade element) throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(element).perform();
        Thread.sleep(3000);
    }

    public void scrollsDownThePage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
    }

    public int getsRandomIntegerFromRange(int min, int max) {

        int range = (max - min) + 1;
        int result = (int)(Math.random() * range) + min;
        System.out.println("Random number is generated between: " +min +" and " +max +" :" +result);
        return result;
    }

}
