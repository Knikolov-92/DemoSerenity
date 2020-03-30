package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
@DefaultUrl( "http://automationpractice.com/" )
public class BasePage
        extends PageObject
{

    public static final By ERROR_MESSAGES_LIST = By.cssSelector( "div.alert-danger li" );
}
