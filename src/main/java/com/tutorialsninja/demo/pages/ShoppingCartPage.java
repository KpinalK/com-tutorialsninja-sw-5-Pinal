package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productName;

    @CacheLookup
    @FindBy(css = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement productPrice;

    @CacheLookup
    @FindBy(css = "input[value='1']")
    WebElement productQty;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement updateMessage;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;


    /**
     * This Method will get the shopping cart text
     */
    public String getShoppingCartText() {
        CustomListeners.test.log(Status.PASS,"get ShoppingCart Text");
        return getTextFromElement(shoppingCartText);
    }

    /**
     * This Method will get the product name from the cart
     */
    public String getProductName() {
        CustomListeners.test.log(Status.PASS," get ProductName");
        return getTextFromElement(productName);
    }

    /**
     * This method will get the product delivery date
     */
    public String[] getDeliveryDate() {
        CustomListeners.test.log(Status.PASS,"get DeliveryDate");
        return getTextFromElement(deliveryDate).split(":");
    }

    /**
     * This method will get the product model
     */
    public String getProductModel() {
        CustomListeners.test.log(Status.PASS,"get ProductModel");
        return getTextFromElement(modelName);
    }

    /**
     * This method will get the price
     */
    public String getPrice() {
        CustomListeners.test.log(Status.PASS,"get Price");
        return getTextFromElement(productPrice);
    }

    /**
     * This method will update the qty
     */
    public void changeQtyOfProduct(String qty) {
        CustomListeners.test.log(Status.PASS,"change Qty Of Product" + qty);
        sendTextToElement(productQty, qty);
    }

    /**
     * click on the update cart button
     */
    public void clickOnUpdateButton() {
        CustomListeners.test.log(Status.PASS,"clickOn UpdateButton");
        clickOnElement(updateButton);
    }

    /**
     * This method will click on the checkout button
     */
    public void clickOnCheckOut() {
        CustomListeners.test.log(Status.PASS,"clickOnC heckOut");
        clickOnElement(checkOutButton);
    }

    /**
     * This method will get the updated cart message
     */
    public String getUpdatedCartMessage() {
        CustomListeners.test.log(Status.PASS,"get Updated CartMessage");
        return getTextFromElement(updateMessage).split("\n")[0];
    }
}
