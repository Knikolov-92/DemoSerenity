package com.qualityhouse.serenity.page_objects;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl( DressesPage.DRESSES_PAGE_URL )
public class DressesPage extends ShoppingPage {

    public final static String DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=8&controller=category";
    public final static String DRESSES_PAGE_TITLE = "Dresses - My Store";



}
