package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.steps.libraries.CartActions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class CartSteps {

    @Steps
    private CartActions jimmy;


    @Then("^The selected item should be displayed in the cart:$")
    public void theSelectedItemShouldBeAddedToTheCart(DataTable selectedProductInfo) {

        List<Map<String, String>> data = selectedProductInfo.asMaps(String.class, String.class);
        String name = data.get(0).get("name");
        String price = data.get(0).get("price");
        String quantity = data.get(0).get("quantity");
        String size = data.get(0).get("size");
        String color = data.get(0).get("color");

        System.out.println(name +"," +price +"," +quantity +"," +size +"," +color);
        float totalProductPrice = Float.parseFloat(price) * Float.parseFloat(quantity);

        jimmy.checksProductNameInCart(name);
        jimmy.checksProductColorInCart(color);
        jimmy.checksProductSizeInCart(size);
        jimmy.checksProductPriceInCart(price);
        jimmy.checksProductQuantityInCart(quantity);
        jimmy.checksTotalProductPrice(totalProductPrice);
        jimmy.checksTotalPriceInCart(totalProductPrice);
    }

}
