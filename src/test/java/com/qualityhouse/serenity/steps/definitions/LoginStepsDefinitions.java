package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.LoginPage;
import com.qualityhouse.serenity.steps.libraries.LoginActions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

/**
 * @author yakimfb
 * @since 12.03.20
 **/
public class LoginStepsDefinitions
{

    LoginPage loginPage;
    HomePage homePage;

    @Steps
    private LoginActions ivancho;

    @Given( "^(?:.*) is on the login page$" )
    public void loginPageIsOpen()
    {
        loginPage.open();
    }

    @Then( "^I should lend on my home page$" )
    public void iShouldLendOnMyHomePage()
    {
    }

    @When( "^(?:.*) logs in with:$" )
    public void johnLogsInWith( List<User> data ) throws InterruptedException {
        User user = data.get( 0 );
        ivancho.logsInWithCredentials( user );
    }

    @Then( "^I should see \"([^\"]*)\"$" )
    public void iShouldSee( String arg0 ) throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then( "^(.*) is logged in successfully$" )
    public void userShouldLoginSuccessfully( String userName )
    {
        SoftAssertions assertSoftly = new SoftAssertions();
        assertSoftly.assertThat( ivancho.canSeeElement( homePage.logOutMenu ) )
                    .as( "Logout menu should be visible, when user is logged in" )
                    .isTrue();

        assertSoftly.assertThat( ivancho.readsTextFrom( homePage.userMenu ) )
                    .as( "User Menu items should contain the user name" )
                    .containsIgnoringCase( userName );

        assertSoftly.assertAll();
    }
}
