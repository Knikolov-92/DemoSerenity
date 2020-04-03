package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    public final static By COLOR_PICK_LIST = By.cssSelector("#color_to_pick_list li a");
    public final static By SIZE_SELECT_LIST = By.cssSelector(".form-control.attribute_select.no-print [value");

    @FindBy(id = "quantity_wanted")
    public WebElementFacade quantityField;

    @FindBy(id = "uniform-group_1")
    public WebElementFacade sizeSelectBox;

    @FindBy(name = "Submit")
    public WebElementFacade addToCartButton;

    @FindBy(css = ".layer_cart_product h2")
    public WebElementFacade successfulMessageText;

    @FindBy(css = ".btn.btn-default.button.button-medium")
    public WebElementFacade proceedToCheckoutButton;



}
