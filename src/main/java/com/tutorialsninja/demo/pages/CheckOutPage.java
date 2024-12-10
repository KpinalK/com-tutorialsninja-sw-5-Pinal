package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephoneNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonGuest;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement continueButtonDelivery;

    @CacheLookup
    @FindBy(xpath = "continueButtonDelivery")
    WebElement continueButtonPayment;

    @CacheLookup
    @FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']")
    WebElement textBox;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement notAvailableMessage;


    /**
     * This method will get the text from check out page
     */
    public String getTextOfCheckOut() {
        CustomListeners.test.log(Status.PASS,"get Text Of CheckOut");
        return getTextFromElement(checkOutText);
    }

    /**
     * This method will get the new customer text
     */
    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS,"get NewCustomer Text");
        return getTextFromElement(newCustomer);
    }

    /**
     * This method will click onGuest radio button
     */
    public void clickOnGuestRadioButton() {
        CustomListeners.test.log(Status.PASS,"click On Guest RadioButton");
        clickOnElement(guestRadioButton);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinue() {
        CustomListeners.test.log(Status.PASS,"click On Continue");
        clickOnElement(continueButton);
    }

    /**
     * This method will enter name
     */
    public void enterFirstName(String fName) {
        CustomListeners.test.log(Status.PASS,"enter FirstName" + fName);
        sendTextToElement(firstName, fName);
    }

    /**
     * This method will enter last name
     */
    public void enterLastName(String lName) {
        CustomListeners.test.log(Status.PASS,"enter LastName" + lName);
        sendTextToElement(lastName, lName);
    }

    /**
     * This method will enter email
     */
    public void enterEmailAddress(String email) {
        CustomListeners.test.log(Status.PASS," enter EmailAddress" + email);
        sendTextToElement(emailAddress, email);
    }

    /**
     * This method will enter telephone
     */
    public void enterTelephone(String phone) {
        CustomListeners.test.log(Status.PASS,"enter Telephone" + phone);
        sendTextToElement(telephoneNumber, phone);
    }

    /**
     * This method will enter address
     */
    public void enterAddress(String add) {
        CustomListeners.test.log(Status.PASS,"enter Address" +add);
        sendTextToElement(address, add);
    }

    /**
     * This method will enter city
     */
    public void enterCityName(String cty) {
        CustomListeners.test.log(Status.PASS,"enter CityName" + cty);
        sendTextToElement(city, cty);
    }

    /**
     * This method will enter Post code
     */
    public void enterPostCode(String pCode) {
        CustomListeners.test.log(Status.PASS,"enter PostCode" +pCode);
        sendTextToElement(postCode, pCode);
    }

    /**
     * This method will select country
     */
    public void selectCountry(String cnty) {
        CustomListeners.test.log(Status.PASS,"select Country" +cnty);
        selectByVisibleTextFromDropDown(country, cnty);
    }

    /**
     * This method will select region
     */
    public void selectRegion(String rgn) {
        CustomListeners.test.log(Status.PASS,"select Region" +rgn);
        selectByVisibleTextFromDropDown(region, rgn);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinueButtonForGuest() {
        CustomListeners.test.log(Status.PASS,"click On Continue Button For Guest");
        clickOnElement(continueButtonGuest);
    }

    public void clickOnContinueButtonForDelivery() {
        CustomListeners.test.log(Status.PASS,"click On Continue Button Fo rDelivery");
        clickOnElement(continueButtonDelivery);
    }

    /**
     * This method will enter data in textfield
     */
    public void enterCommentInTextBox(String message) {
        CustomListeners.test.log(Status.PASS,"enter Comment In TextBox" + message);
        sendTextToElement(textBox, message);
    }

    /**
     * This method will accept terms
     */
    public void clickOnTerms() {
        CustomListeners.test.log(Status.PASS,"click On Terms");
        clickOnElement(agree);
    }

    public void clickOnContinueButtonForPayment() {
        CustomListeners.test.log(Status.PASS,"click On Continue Button ForPayment");
        clickOnElement(continueButtonPayment);
    }


    /**
     * This method will get error message (if product is not available)
     */
    public String getProductNotAvailableMessage() {
        CustomListeners.test.log(Status.PASS,"get Product Not Available Message");
        return getTextFromElement(notAvailableMessage).split("\n")[0];
    }
}
