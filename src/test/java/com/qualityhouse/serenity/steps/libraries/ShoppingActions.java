package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.BasePage;
import com.qualityhouse.serenity.page_objects.ShoppingPage;
import com.qualityhouse.serenity.steps.definitions.ShoppingSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static com.qualityhouse.serenity.page_objects.ShoppingPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingActions {

    private ShoppingPage dressPage;
    BasePage currentPage;
    private  SoftAssertions softly = new SoftAssertions();

    @Steps
    private BasesActions kolio;

    public String getsProductName(String locator) {

        return currentPage.find(locator).getTextContent().trim();
    }

    public String getsProductPrice(String locator) {

        return currentPage.find(locator).getTextContent().trim().substring(1);
    }
    @Step

    public void checksCartProductsQuantity(String expectedQuantity) {

        if (Integer.parseInt(expectedQuantity) != 0) {

            softly.assertThat(dressPage.cartProductQuantity.getTextContent().trim()).isEqualTo(expectedQuantity);
        }
        else {
            System.out.println("Expected quantity is '0', skipping check");
        }
    }

    @Step
    public void checksCartProductsText(int numberOfProductsAdded){

        if (numberOfProductsAdded == 0) {

            System.out.println("Check that Cart contains no products");
            softly.assertThat(dressPage.cartProductsTextEmpty.isVisible() )
                    .isTrue();
            softly.assertThat(dressPage.cartProductsTextEmpty.getTextContent().trim() )
                    .isEqualTo("(empty)");
        }
        else if (numberOfProductsAdded == 1) {

            System.out.println("Check that Cart contains 1 product");
            softly.assertThat(dressPage.cartProductsTextSingular.isVisible() )
                    .isTrue();
            softly.assertThat(dressPage.cartProductsTextSingular.getTextContent().trim() )
                    .isEqualTo("Product");
        }
        else {

            System.out.println("Check that Cart contains more than 1 products");
            softly.assertThat(dressPage.cartProductsTextPlural.isVisible() )
                    .isTrue();
            softly.assertThat(dressPage.cartProductsTextPlural.getTextContent().trim() )
                    .isEqualTo("Products");
        }
    }

    @Step
    public void checksCartProductName(int positionOnPage, int positionInCart) {

        SoftAssertions softly = new SoftAssertions();
        List<WebElementFacade> listOfProductNames = kolio.getsElementList(PRODUCT_NAME_LIST_LOCATOR);
        List<WebElementFacade> listOfCartProductNames = kolio.getsElementList(CART_PRODUCT_LIST_NAME_LOCATOR);

        softly.assertThat((listOfCartProductNames.get(positionInCart - 1)).getAttribute("title") )
                .isEqualTo(listOfProductNames.get(positionOnPage - 1).getAttribute("title") );
    }

    @Step
    public void checksCartProductPrice(int positionOnPage, int positionInCart) {

        SoftAssertions softly = new SoftAssertions();
        List<WebElementFacade> listOfProductPrices = kolio.getsElementList(PRODUCT_PRICE_LIST_LOCATOR);
        List<WebElementFacade> listOfCartProductPrices = kolio.getsElementList(CART_PRODUCT_LIST_PRICE_LOCATOR);

        softly.assertThat((listOfCartProductPrices.get(positionInCart - 1)).getTextContent().trim().substring(1) )
                .isEqualTo(listOfProductPrices.get(positionOnPage - 1).getTextContent().trim().substring(1) );
    }

    @Step
    public void checksCartTotalPrice() {

        float totalPrice = 0;
        float priceOfCurrentElement = 0;
        float shippingCost = 0;
        SoftAssertions softly = new SoftAssertions();

        List<WebElementFacade> listOfCartProductPrices = kolio.getsElementList(CART_PRODUCT_LIST_PRICE_LOCATOR);

        for (int i = 0; i < listOfCartProductPrices.size(); i++) {

            priceOfCurrentElement = Float.parseFloat(listOfCartProductPrices.get(i)
                    .getTextContent().trim().substring(1) );

            System.out.println("Price of current product is: " +priceOfCurrentElement);
            totalPrice += priceOfCurrentElement;
        }
        System.out.println("Total price of all products is: " +totalPrice);

        shippingCost = Float.parseFloat(dressPage.cartShippingValue.getTextContent().trim().substring(1));
        System.out.println("Shipping costs are: " +shippingCost);

        totalPrice += shippingCost;
        System.out.println("Expected total price of products + shipping is: " +totalPrice +" $");

        softly.assertThat(totalPrice)
                .isEqualTo(Float.parseFloat(dressPage.cartPriceTotal.getTextContent().trim().substring(1)) );
    }

}
