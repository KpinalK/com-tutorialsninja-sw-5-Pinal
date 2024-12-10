package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']//button[@type='button']")
    WebElement deliveryDatePicker;

    @CacheLookup
    @FindBy(css = "div[class='datepicker-days'] th[class='picker-switch']")
    WebElement monthYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")
    WebElement clickNextButton;

//    @CacheLookup
//    @FindBy(xpath = "//tbody/tr/td[@class='day']")
//    WebElement dateList;
    By dateList = By.xpath("//tbody/tr/td[@class='day']");

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement productQty;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement shoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    /**
     * This method will get the product name
     */
    public String getProductNameFromProductPage() {
        CustomListeners.test.log(Status.PASS,"get ProductName From ProductPage");
        return getTextFromElement(productName);
    }

    /**
     * This method will select the date from the dropdown
     */
    public void selectDateFromDatePicker(String month, String year, String date) {
        //click on the element
        CustomListeners.test.log(Status.PASS,"select Date FromDatePicker" + month + year + date);
        clickOnElement(deliveryDatePicker);

        while (true) {
            String[] monthAndYear = getTextFromElement(monthYear).split(" ");
            String currentMonth = monthAndYear[0];
            String currentYear = monthAndYear[1];

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            } else {
                clickOnElement(clickNextButton);
            }
        }

        List<WebElement> listOfDate = findElement(dateList);
        for (WebElement d : listOfDate) {
            if (d.getText().equals(date)) {
                d.click();
                break;
            }
        }
    }

    private List<WebElement> findElement(By dateList) {
        return null;
    }

    /**
     * This method will change the qty of the product
     */
    public void productQty(String qty) {
        CustomListeners.test.log(Status.PASS,"productQty" + qty);
        sendTextToElement(productQty, qty);
    }

    /**
     * This method will get the shopping cart message
     */
    public String getShoppingCartMessage() throws InterruptedException {
        // Thread.sleep(3000);
        CustomListeners.test.log(Status.PASS,"get ShoppingCart Message");
        return getTextFromElement(shoppingCartMessage).split("\n")[0];
    }

    /**
     * This method will click on the shopping cart link
     */
    public void clickOnTheShoppingCartLink() {
        CustomListeners.test.log(Status.PASS,"click On The ShoppingCartLink");
        //waitUntilVisibilityOfElementLocated(shoppingCartLink,4);
        clickOnElement(shoppingCartLink);
    }

    /**
     * This method will click on the add to cart button
     */
    public void clickOnTheAddToCart() {
        CustomListeners.test.log(Status.PASS,"click On The AddToCart");
        clickOnElement(addToCart);
    }
}
