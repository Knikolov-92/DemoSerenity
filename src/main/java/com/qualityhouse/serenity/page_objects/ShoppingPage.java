package com.qualityhouse.serenity.page_objects;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ShoppingPage extends PageObject {

    public final static By PRODUCT_LIST_LOCATOR = By.cssSelector(".product_list.grid.row .product-container");
    public final static By BUTTON_ADD_TO_CART_LIST_LOCATOR = By.cssSelector(".btn-default.btn.ajax_add_to_cart_button.button");
    public final static By CART_PRODUCT_LIST_NAME_LOCATOR = By.cssSelector(".cart_block_list .cart-info .product-name");
    public final static By CART_PRODUCT_LIST_PRICE_LOCATOR = By.cssSelector(".cart_block_list .cart-info .price");
    public final static By PRODUCT_NAME_LIST_LOCATOR = By.cssSelector(".product-container .product-name");
    public final static By PRODUCT_PRICE_LIST_LOCATOR = By.cssSelector(".product-container .right-block .price.product-price");

    @FindBy(css = "[title='View my shopping cart'] .ajax_cart_quantity")
    public WebElementFacade cartProductQuantity;

    @FindBy(css = "[title='View my shopping cart'] .ajax_cart_product_txt")
    public WebElementFacade cartProductsTextSingular;

    @FindBy(css = "[title='View my shopping cart'] .ajax_cart_product_txt_s")
    public WebElementFacade cartProductsTextPlural;

    @FindBy(css = "[title='View my shopping cart'] .ajax_cart_no_product")
    public WebElementFacade cartProductsTextEmpty;

    @FindBy(css = ".continue.btn[title='Continue shopping']")
    public WebElementFacade buttonContinueShopping;

    @FindBy(css = ".price.cart_block_total.ajax_block_cart_total")
    public WebElementFacade cartPriceTotal;

    @FindBy(css = ".price.cart_block_shipping_cost.ajax_cart_shipping_cost")
    public WebElementFacade cartShippingValue;




}


/*
    @When("^John adds first ([1-9]{1,2}) product\\(s\\) to cart$")
    public Map<Integer, Product> johnClicksOnaProductToAdd(String numberOfProductsToAdd) throws InterruptedException {

        WebElementFacade productElement;
        WebElementFacade addToCartButton;
        String productLocator = "div.left-block div.product-image-container";
        String buttonAddToCartLocator = ".btn-default.btn.ajax_add_to_cart_button.button";
        String productNameLocator;
        String productPriceLocator;
        String productName;
        String productPrice;

        List<WebElementFacade> productList = yakim.getsElementList(productLocator);
        List<WebElementFacade> buttonAddList = yakim.getsElementList(buttonAddToCartLocator);
        //Map<Integer, Product> productsMap = new HashMap<Integer, Product>();

        //int randomNumber = 0;
        int n = 1;
        int xpathIndex = 0;

        Map<Integer, Product> mapOfProducts = new HashMap<>();

        while (n <= Integer.parseInt(numberOfProductsToAdd)) {
            //generate random number 0-5
            //randomNumber = yakim.getsRandomIntegerFromRange(0, productList.size() - 1);
            //set the right name and price locators
            xpathIndex = n;
            productNameLocator = "//*[@id=\"center_column\"]/ul/li[" + xpathIndex + "]/div/div[2]/h5/a";
            productPriceLocator = "//*[@id=\"center_column\"]/ul/li[" + xpathIndex + "]/div/div[2]/div[1]/span";

            productName = basePage.find(productNameLocator).getTextContent().trim();
            productPrice = basePage.find(productPriceLocator).getTextContent().trim().substring(1);
            System.out.println("name of product " + n + " = " + productName);
            System.out.println("price of product " + n + " = " + productPrice);

            Product productN = new Product(productName, productPrice);

            mapOfProducts.put(n, productN);

            String mappedProductName;
            String mappedProductPrice;
            String mappedID;

            mappedID = mapOfProducts.get(n).toString();
            mappedProductName = mapOfProducts.get(n).name;
            mappedProductPrice = mapOfProducts.get(n).price;
            System.out.println("ID in map: " + mappedID);
            System.out.println("name in map: " + mappedProductName);
            System.out.println("price in map: " + mappedProductPrice);

            productElement = productList.get(n - 1);
            addToCartButton = buttonAddList.get(n - 1);

            yakim.movesPointerToElement(productElement);
            yakim.clicksOn(addToCartButton);
            yakim.clicksOn(dressPage.buttonContinueShopping);
            n++;
        }

        System.out.println("this is the map:");
        System.out.println(mapOfProducts);
        System.out.println("name = " +(mapOfProducts.get(1).name) +", price = " +(mapOfProducts.get(1).price) );
        System.out.println("name = " +(mapOfProducts.get(2).name) +", price = " +(mapOfProducts.get(2).price) );
        System.out.println("name = " +(mapOfProducts.get(3).name) +", price = " +(mapOfProducts.get(3).price) );
        //------------------------------Cart QUANTITY
        yakim.movesPointerToElement(dressPage.cartProductQuantity);
        Assert.assertEquals(numberOfProductsToAdd, dressPage.cartProductQuantity.getTextContent().trim() );
        Assert.assertEquals("Products", dressPage.cartProductsQuantityText.getTextContent().trim() );
        System.out.println("Cart has " +(dressPage.cartProductQuantity.getTextContent().trim()) +" " +(dressPage.cartProductsQuantityText.getTextContent().trim()) );
        //------------------------------Cart Product NAMES
        for (int iCount = 1; iCount <= 3; iCount++){

            String cartProductLocator = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt["+iCount+"]/div/div[1]/a";
            String expectedProductName = mapOfProducts.get(iCount).name;
            String actualProductName = basePage.find(cartProductLocator).getAttribute("title");

            System.out.println("Expected product number " +iCount +" is: " +expectedProductName);
            System.out.println("Actual product number " +iCount +" is: " +actualProductName);
            Assert.assertEquals(expectedProductName, actualProductName);

        }


        //------------------------------Cart TOTAL PRICE
        float sumOfProducts = (float) (Float.parseFloat(mapOfProducts.get(1).price) +
                Float.parseFloat(mapOfProducts.get(2).price) +
                Float.parseFloat(mapOfProducts.get(3).price) + 2.0);

        Assert.assertEquals(sumOfProducts, Float.parseFloat(dressPage.cartPriceTotal.getTextContent().trim().substring(1)) );
        System.out.println("Expected total price for first 3 products is: " +sumOfProducts);
        System.out.println("Actual total price is: " +(Float.parseFloat(dressPage.cartPriceTotal.getTextContent().trim().substring(1))) );
        return mapOfProducts;

    }
 */