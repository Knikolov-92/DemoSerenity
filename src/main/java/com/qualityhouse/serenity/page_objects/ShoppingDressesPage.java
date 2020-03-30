package com.qualityhouse.serenity.page_objects;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DefaultUrl( "http://automationpractice.com/index.php?id_category=8&controller=category" )
public class ShoppingDressesPage extends PageObject {

    public final static String SHOP_DRESSES_PAGE_URL = "http://automationpractice.com/index.php?id_category=8&controller=category";
    public final static String SHOP_DRESSES_PAGE_TITLE = "Dresses - My Store";

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElementFacade dressesLink;

    @FindBy(css = "div.product-container")
    public WebElementFacade dressContainer;

    @FindBy(css = ".btn-default.btn.ajax_add_to_cart_button.button")
    public WebElementFacade productButtonContainer;

}
