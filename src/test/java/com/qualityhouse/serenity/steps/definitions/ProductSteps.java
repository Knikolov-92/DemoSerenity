package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.page_objects.ProductPage;
import com.qualityhouse.serenity.steps.libraries.BasesActions;
import com.qualityhouse.serenity.steps.libraries.CartActions;
import com.qualityhouse.serenity.steps.libraries.ProductActions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class ProductSteps {

    ProductPage productPage;

    @Steps
    private ProductActions bob;
    @Steps
    private BasesActions yakim;
    private CartActions valio;

    @When("^John adds the product to the cart:$")
    public void johnAddsTheProductToTheCart(DataTable productInfo) throws InterruptedException {

        List<Map<String, String>> data = productInfo.asMaps(String.class, String.class);
        //String name = data.get(0).get("name");
        //String price = data.get(0).get("price");
        String quantity = data.get(0).get("quantity");
        String size = data.get(0).get("size");
        String color = data.get(0).get("color");

        bob.setsProductQuantity(quantity);
        Thread.sleep(1000);
        bob.selectsProductSize(size);
        bob.picksProductColor(color);
        yakim.clicksOn(productPage.addToCartButton);
    }

    @Then("^The successful adding\\-product\\-to\\-cart\\-message \"([^\"]*)\" is displayed$")
    public void theSuccessfulAddedProductMessageIsDisplayed(String expectedMessage) {

        SoftAssertions softly = new SoftAssertions();

        String actualMessage = productPage.successfulMessageText.getTextContent().trim();
        softly.assertThat(actualMessage).isEqualTo(expectedMessage);
        System.out.println(actualMessage);
        softly.assertAll();
    }

    @When("^John proceeds to the Cart page$")
    public void johnProceedsToTheCartPage() throws InterruptedException {

        yakim.clicksOn(productPage.proceedToCheckoutButton);
    }



}
