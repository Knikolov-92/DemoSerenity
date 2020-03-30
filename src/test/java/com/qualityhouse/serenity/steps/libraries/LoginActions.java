package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class LoginActions
        extends BasesActions
{
    private LoginPage loginPage;
    private HomePage homePage;

    @Step
    public void logsInWithCredentials( User user ) throws InterruptedException {
        fillsFieldWithData( loginPage.emailField,
                            user.getEmail() );
        fillsFieldWithData( loginPage.passwordField,
                            user.getPassword() );
        clicksOn( loginPage.loginButton );
    }
}
