package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement cPassword;

    @CacheLookup
    @FindBy(xpath = "input[value='1'][name='newsletter']")
    WebElement yesRadio;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement registerSuccessMessageElement;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueSuccess;


    /**
     * This method will get the Register text
     */
    public String getRegisterText() {
        CustomListeners.test.log(Status.PASS,"get Register Text");
        return getTextFromElement(registerText);
    }

    /**
     * This method will get the Register successful text
     */
    public String getRegisterSuccessfulText() {
        CustomListeners.test.log(Status.PASS,"get Register Successful Text");
        return getTextFromElement(registerSuccessMessageElement);
    }


    /**
     * This method will enter firstname
     */
    public void enterFirstName(String fName) {
        CustomListeners.test.log(Status.PASS,"enter FirstName" + fName);
        sendTextToElement(firstName, fName);
    }

    /**
     * This method will enter firstname
     */
    public void enterLastName(String lName) {
        CustomListeners.test.log(Status.PASS,"enter LastName" +lName);
        sendTextToElement(lastName, lName);
    }

    /**
     * This method will enter email
     */
    public void enterEmail(String emailAddress) {
        CustomListeners.test.log(Status.PASS,"enter Email" +emailAddress);
        sendTextToElement(email, emailAddress);
    }

    /**
     * This method will enter telephone
     */
    public void enterTelephone(String phone) {
        CustomListeners.test.log(Status.PASS,"enter Telephone" + phone);
        sendTextToElement(telephone, phone);
    }

    /**
     * This method will enter password
     */
    public void enterPassword(String passwordText) {
        CustomListeners.test.log(Status.PASS,"enter Password" + passwordText);
        sendTextToElement(password, passwordText);
    }

    /**
     * This method will enter confirmPassword
     */
    public void enterConfirmPassword(String passwordText) {
        CustomListeners.test.log(Status.PASS,"enter Confirm Password" + passwordText);
        sendTextToElement(cPassword, passwordText);
    }

    /**
     * This method will click on the Yes radio button
     */
    public void clickOnTheYesRadioButton() {
        CustomListeners.test.log(Status.PASS,"click On The Yes RadioButton");
        clickOnElement(yesRadio);
    }

    /**
     * This method will click on privacy checkbox
     */
    public void clickOnThePrivacyCheckbox() {
        CustomListeners.test.log(Status.PASS,"click On The Privacy Checkbox");
        clickOnElement(privacyCheckBox);
    }

    /**
     * This method will click on the continue button
     */
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS,"click On Continue Button");
        clickOnElement(continueButton);
    }

    /**
     * This method will click on the continue successful button
     */
    public void clickOnContinueButtonAfterSuccessfulAccountCreated() {
        CustomListeners.test.log(Status.PASS,"clickOn Continue Button AfterSuccessfulAccountCreated");
        clickOnElement(continueSuccess);
    }

}
