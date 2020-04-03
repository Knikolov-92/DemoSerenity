package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {


    @FindBy(css = ".cart_description .product-name")
    public WebElementFacade productName;

    @FindBy(css = "td.cart_description small a")
    public WebElementFacade productColorSizeText;

    @FindBy(css = ".cart_unit .price .price")
    public WebElementFacade productUnitPrice;

    @FindBy(css = ".cart_quantity.text-center .cart_quantity_input.form-control")
    public WebElementFacade productQuantity;

    @FindBy(css = ".cart_total .price")
    public  WebElementFacade totalProductPrice;

    @FindBy(id = "total_product")
    public  WebElementFacade totalProductSPrice;

    @FindBy(id = "total_shipping")
    public WebElementFacade shippingCost;

    @FindBy(id = "total_tax")
    public WebElementFacade taxCost;

    @FindBy(id = "total_price")
    public WebElementFacade totalPrice;

}
