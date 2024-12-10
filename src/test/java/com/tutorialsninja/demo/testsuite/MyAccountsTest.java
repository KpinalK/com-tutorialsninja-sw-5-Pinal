package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CommonElementPage commonElementPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        commonElementPage = new CommonElementPage();

    }

    /*===============================================================*/
    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    public void verifyText(List<String> actualText, List<String> expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }
    /*===============================================================*/


    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //1.3 Verify the text “Register Account”.
        String actualRegisterText = registerPage.getRegisterText();
        String expectedRegisterText = "Register Account";
        verifyText(actualRegisterText, expectedRegisterText, "Register Account text is not displayed");
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //2.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        commonElementPage.selectMyAccountOption("Login");

        //2.3 Verify the text “Returning Customer”.
        String actualLoginText = loginPage.getLoginText();
        String exceptedLoginText = "Returning Customer";
        verifyText(actualLoginText, exceptedLoginText, "Returning Customer is not displayed");
    }

    @Test(groups = {"smoke", "regression1"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //3.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //3.3 Enter the First Name
        registerPage.enterFirstName("pinal");

        //3.4 Enter the Last Name
        registerPage.enterLastName("kamani");

        //3.5 Enter the Email
        registerPage.enterEmail("pinal159@gmail.com");

        //3.6 Enter the Telephone
        registerPage.enterTelephone("565689899");

        //3.7 Enter the Password
        registerPage.enterPassword("pinal159");

        //3.8 Enter the Password Confirm
        registerPage.enterConfirmPassword("pinal159");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnTheYesRadioButton();

        //3.10 Click on the Privacy Policy check box
        registerPage.clickOnThePrivacyCheckbox();

        //3.11 Click on the Continue button
        registerPage.clickOnContinueButton();

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualSuccessMessage = registerPage.getRegisterSuccessfulText();
        String expectedSuccessMessage = "Your Account Has Been Created!";
        verifyText(actualSuccessMessage, expectedSuccessMessage, "The message your account has been created is not displayed");

        //3.13 Click on the Continue button
        registerPage.clickOnContinueButtonAfterSuccessfulAccountCreated();

        //3.14 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String actualLogoutText = commonElementPage.getLogoutText();
        String expectedLogoutText = "Account Logout";
        verifyText(actualLogoutText, expectedLogoutText, "The logout message is not displayed");

        //3.17 Click on the Continue button
        commonElementPage.clickOnContinueButton();
    }

    @Test(groups = {"smoke", "regression1"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //4.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        commonElementPage.selectMyAccountOption("Login");

        //4.3 Enter the Email address
        loginPage.enterEmail("pinal159@gmail.com");

        //4.4 Enter the Last Name
        //loginPage.enterPassword("pinal159");

        //4.5 Enter the Password
        loginPage.enterPassword("pinal159");

        //4.6 Click on the Login button
        loginPage.clickOnLoginButton();

        //4.7 Verify text “My Account”
        String actualMyAccountText = myAccountPage.getMyAccountText();
        String expectedMyAccountText = "My Account";
        verifyText(actualMyAccountText, expectedMyAccountText, "My account text is not displayed");

        //4.8 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();
        //4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        commonElementPage.selectMyAccountOption("Logout");
        //4.11 Click on the Continue button
        commonElementPage.clickOnContinueButton();
    }
}
