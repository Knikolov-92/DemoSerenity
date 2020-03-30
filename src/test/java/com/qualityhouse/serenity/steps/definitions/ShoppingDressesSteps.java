package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.ShoppingDressesPage;
import com.qualityhouse.serenity.steps.libraries.BasesActions;
import com.qualityhouse.serenity.steps.libraries.RegistrationActions;
import com.qualityhouse.serenity.steps.libraries.ShoppingActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.qualityhouse.serenity.page_objects.ShoppingDressesPage.SHOP_DRESSES_PAGE_TITLE;
import static com.qualityhouse.serenity.page_objects.ShoppingDressesPage.SHOP_DRESSES_PAGE_URL;

public class ShoppingDressesSteps {

    ShoppingDressesPage dressPage;
    BasePage basePage;
    private ShoppingActions yakimcho;

    @Steps
    private BasesActions yakim;

    @Given("^John is on the Base page$")
    public void johnIsOnTheBasePage() throws InterruptedException {
        
        basePage.open();
        Thread.sleep(3000);
    }

    @When("^John clicks on \"Dresses\" button$")
    public void johnClicksOnButton() throws InterruptedException {

        yakim.clicksOn(dressPage.dressesLink);
    }

    @Then("^John should be on the Dresses-shopping page$")
    public void johnShouldBeOnTheDressesShoppingPage() {

        yakim.shouldBeOnPage(SHOP_DRESSES_PAGE_URL);
        yakim.shouldSeePageTitle(SHOP_DRESSES_PAGE_TITLE);
    }

    @Given("^John is on the dresses-shopping page$")
    public void johnIsOnTheDressesShoppingPage() throws InterruptedException {

        dressPage.open();
        Thread.sleep(3000);
    }

    @When("^John clicks on a product to add$")
    public void johnClicksOnaProductToAdd() throws InterruptedException {

        WebElementFacade product;
        WebElementFacade addToCart;
        String productLocator = "div.left-block div.product-image-container";
        String buttonAddLocator = ".btn-default.btn.ajax_add_to_cart_button.button";

        ArrayList<WebElementFacade> productList = yakim.getsElementList(productLocator);
        ArrayList<WebElementFacade> buttonAddList = yakim.getsElementList(buttonAddLocator);

        int i = yakim.getsRandomIntegerFromRange(0, productList.size() - 1);
        product = productList.get(i);
        addToCart = buttonAddList.get(i);

        yakim.movesPointerToElement(product);
        yakim.clicksOn(addToCart);

    }

    @Then("^John should see the products in cart$")
    public void johnShouldSeeTheProductsInCart() {
    }
}
