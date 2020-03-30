package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.AddressDetails;
import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.LoginPage;
import com.qualityhouse.serenity.page_objects.RegistrationPage;
import com.qualityhouse.serenity.utils.MonthsEnum;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.components.RegistrationFormComponent.*;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class RegistrationActions
        extends BasesActions
{
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Step( "Enters his/her personal details in the registration form {0}" )
    public void entersHisPersonalDetails( User user )
    {
        selectGender( user.getTitle() );

        fillsFieldWithData( FIRST_NAME_FIELD,
                            user.getFirstName() );
        fillsFieldWithData( LAST_NAME_FIELD,
                            user.getLastName() );
        fillsFieldWithData( EMAIL_FIELD,
                            user.getEmail() );
        fillsFieldWithData( PASSWORD_FIELD,
                            user.getPassword() );

        enterBirthDate( user.getDataOfBirth() );
    }

    @Step( "Enters his/her address details in the registration form {0}" )
    public void entersHisAddressDetails( AddressDetails addressDetails )
    {
        fillsFieldWithData( registrationPage.address1Field,
                            addressDetails.getAddress() );

        fillsFieldWithData( registrationPage.addressCityField,
                            addressDetails.getCity() );

        selectsFromDropDownAnItemByVisibleText( ADDRESS_STATE_DROP_DOWN_LOCATOR,
                                                addressDetails.getState() );

        fillsFieldWithData( registrationPage.addressZipCodeField,
                            addressDetails.getZip() );

        selectsFromDropDownAnItemByVisibleText( ADDRESS_COUNTRY_DROP_DOWN_LOCATOR,
                                                addressDetails.getCountry() );

        fillsFieldWithData( registrationPage.addressMobilePhoneField,
                            addressDetails.getMobilePhone() );

        fillsFieldWithData( registrationPage.addressAliasField,
                            addressDetails.getAddressAlias() );
    }

    @Step
    public void startsRegistrationWithEmail( String email ) throws InterruptedException {
        fillsFieldWithData( loginPage.registrationMailField,
                            email );
        clicksOn( loginPage.createAnAccountButton );
    }

    private void selectGender( String gender )
    {
        if ( gender != null )
        {
            if ( gender.toLowerCase()
                       .contains( "mrs" ) )
            {
                registrationPage.mrsRadioButton.click();
            } else
            {
                registrationPage.mrRadioButton.click();
            }
        }
    }

    private void enterBirthDate( String dataOfBirth )
    {
        if ( dataOfBirth != null )
        {
            String[] tokenizedDateOfBirth = dataOfBirth
                    .split( "-" );
            String day = tokenizedDateOfBirth[0];
            String monthValue = MonthsEnum.valueOf( tokenizedDateOfBirth[1].toUpperCase() )
                                          .getValue();
            String year = tokenizedDateOfBirth[2];

            selectsFromDropDownAnItemByValue( DAY_OF_BIRTH_DROP_DOWN_LOCATOR,
                                              day );
            selectsFromDropDownAnItemByValue( MONTH_OF_BIRTH_DROP_DOWN_LOCATOR,
                                              monthValue );
            selectsFromDropDownAnItemByValue( YEAR_OF_BIRTH_DROP_DOWN_LOCATOR,
                                              year );
        }
    }
}