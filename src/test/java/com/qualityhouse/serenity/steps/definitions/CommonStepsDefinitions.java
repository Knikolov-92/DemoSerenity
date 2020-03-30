package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.steps.libraries.BasesActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.BasePage.ERROR_MESSAGES_LIST;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yakimfb
 * @since 25.03.20
 **/
public class CommonStepsDefinitions
{

    @Steps
    private BasesActions pesho;

    @Then( "^the following error messages should display:$" )
    public void validateTheErrorMassages( List<String> errorMessages )
    {
        assertThat( pesho.readsTextFromList( ERROR_MESSAGES_LIST ) ).containsExactlyInAnyOrderElementsOf( errorMessages );
    }

}

