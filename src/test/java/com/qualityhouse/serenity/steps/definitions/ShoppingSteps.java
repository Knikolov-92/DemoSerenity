package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.DressesPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.steps.libraries.BasesActions;
import com.qualityhouse.serenity.steps.libraries.ShoppingActions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.*;

import static com.qualityhouse.serenity.page_objects.DressesPage.*;
import static org.assertj.core.api.Assertions.assertThat;



public class ShoppingSteps {

    DressesPage dressPage;
    BasePage basePage;
    WomenPage womenPage;
    @Steps
    private BasesActions yakim;
    @Steps
    private ShoppingActions jakim;

    @Given("^John is on the dresses-shopping page$")
    public void johnIsOnTheDressesShoppingPage() throws InterruptedException {

        dressPage.open();
        Thread.sleep(3000);
    }

    @Given("^John is on the women-shopping page$")
    public void johnIsOnTheWomenShoppingPage() throws InterruptedException {

        womenPage.open();
        Thread.sleep(3000);
    }

    @When("^John adds the first ([3]) products to cart$")
    public void johnClicksOnaProductToAdd(String numberOfProductsToAdd) throws InterruptedException {

        WebElementFacade productElement;
        WebElementFacade addToCartButton;
        int elementNumber = 1;

        List<WebElementFacade> productList = yakim.getsElementList(PRODUCT_LIST_LOCATOR);
        List<WebElementFacade> buttonAddList = yakim.getsElementList(BUTTON_ADD_TO_CART_LIST_LOCATOR);

        while (elementNumber <= Integer.parseInt(numberOfProductsToAdd)) {

            productElement = productList.get(elementNumber - 1);
            addToCartButton = buttonAddList.get(elementNumber - 1);

            yakim.movesPointerToElement(productElement);
            yakim.clicksOn(addToCartButton);
            yakim.clicksOn(dressPage.buttonContinueShopping);

            elementNumber++;
        }
    }

    @When("^John selects a product:$")
    public void johnSelectsAProduct(DataTable productInfo) throws InterruptedException {

       jakim.selectsAProductByNameAndPrice(productInfo);
    }

    @Then("^John should be on the Dresses-shopping page$")
    public void johnShouldBeOnTheDressesShoppingPage() {

        yakim.shouldBeOnPage(DRESSES_PAGE_URL);
        yakim.shouldSeePageTitle(DRESSES_PAGE_TITLE);
    }

    @Then("^John should see the ([3]) added products in cart$")
    public void johnShouldSeeTheThreeProductsInCart(String numberOfProducts) throws InterruptedException {

        SoftAssertions softly = new SoftAssertions();

        yakim.movesPointerToElement(dressPage.cartProductQuantity);

        jakim.checksCartProductsQuantity(numberOfProducts);
        jakim.checksCartProductsText(Integer.parseInt(numberOfProducts));

        for (int n = 1; n <= Integer.parseInt(numberOfProducts); n++) {

            jakim.checksCartProductName(n, n);
            jakim.checksCartProductPrice(n, n);
        }
        //------Check CART TOTAL PRICE------
        jakim.checksCartTotalPrice();

        softly.assertAll();
    }

    @Then("^John should see the empty cart on page$")
    public void johnShouldSeeTheEmptyCartOnPage() {

        String expectedNumberOfProductsInCart = "0";

        jakim.checksCartProductsText(Integer.parseInt(expectedNumberOfProductsInCart));
    }






}
