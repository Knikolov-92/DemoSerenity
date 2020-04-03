package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.CartPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import static org.assertj.core.api.Assertions.assertThat;

public class CartActions {

    CartPage cartPage;

    @Step
    public void checksProductNameInCart(String expectedName) {

        String actualName = cartPage.productName.getText().trim();

        assertThat(actualName).isEqualTo(expectedName);
        System.out.println("Name is: " +actualName);
    }

    @Step
    public void checksProductColorInCart(String expectedColor) {

        String actualColor = cartPage.productColorSizeText.getTextContent();

        assertThat(actualColor).contains("Color : " +expectedColor);
        System.out.println("Color is: " +actualColor);
    }

    @Step
    public void checksProductSizeInCart(String expectedSize) {

        String actualSize = cartPage.productColorSizeText.getTextContent();

        assertThat(actualSize).contains("Size : " +expectedSize);
        System.out.println("Size is: " +actualSize);
    }

    @Step
    public void checksProductPriceInCart(String expectedPrice) {

        String actualPrice = cartPage.productUnitPrice.getText().substring(1);

        assertThat(actualPrice).isEqualTo(expectedPrice);
        System.out.println("Price is: " +actualPrice);
    }

    @Step
    public void checksProductQuantityInCart(String expectedQuantity) {

        String actualQuantity = cartPage.productQuantity.getValue();

        assertThat(actualQuantity).isEqualTo(expectedQuantity);
        System.out.println("Quantity is: " +actualQuantity);
    }

    @Step
    public void checksTotalProductPrice(float expectedTotalProductPrice) {

        SoftAssertions softly = new SoftAssertions();
        float actualTotalProductPrice = Float.parseFloat(
                cartPage.totalProductPrice.getTextContent().trim().substring(1) );
        float actualTotalProductSPrice = Float.parseFloat(
                cartPage.totalProductSPrice.getText().substring(1) );

        softly.assertThat(actualTotalProductPrice).isEqualTo(expectedTotalProductPrice);
        System.out.println("Actual total product price is: " +actualTotalProductPrice);
        softly.assertThat(actualTotalProductPrice).isEqualTo(actualTotalProductSPrice);
        System.out.println("Actual total productS price is: " +actualTotalProductSPrice);

        softly.assertAll();
    }

    @Step
    public void checksTotalPriceInCart(float expectedPriceWithoutShippingOrTax) {

        float expectedTotalPrice = expectedPriceWithoutShippingOrTax +
                Float.parseFloat(cartPage.shippingCost.getText().substring(1) ) +
                Float.parseFloat(cartPage.taxCost.getText().substring(1) );
        float actualTotalPrice = Float.parseFloat(
                cartPage.totalPrice.getText().substring(1) );

        assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
        System.out.println("Total price is: " +actualTotalPrice);
    }
}
