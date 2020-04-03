package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.ProductPage;
import cucumber.api.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

import static com.qualityhouse.serenity.page_objects.ProductPage.*;

public class ProductActions {

    ProductPage productPage;

    @Steps
    private BasesActions yakim;


    public void setsProductQuantity(String quantity) {

        productPage.quantityField.type(quantity);
    }


    public void selectsProductSize(String sizeToSelect) throws InterruptedException {

        yakim.clicksOn(productPage.sizeSelectBox);
        List<WebElementFacade> listOfSizes = yakim.getsElementList(SIZE_SELECT_LIST);
        String currentSizeInList;


        for (int n = 0; n < listOfSizes.size(); n++) {

            currentSizeInList = listOfSizes.get(n).getAttribute("title");

            if (currentSizeInList.equals(sizeToSelect) ) {

                yakim.clicksOn(listOfSizes.get(n) );
                break;
            }
        }
    }


    public void picksProductColor(String colorToPick) throws InterruptedException {

        List<WebElementFacade> listOfColors = yakim.getsElementList(COLOR_PICK_LIST);
        String currentColorInList;

        for (int n = 0; n < listOfColors.size(); n++) {

            currentColorInList = listOfColors.get(n).getAttribute("title");

            if (currentColorInList.equals(colorToPick)) {

                yakim.clicksOn(listOfColors.get(n) );
                break;
            }
        }
    }

}
