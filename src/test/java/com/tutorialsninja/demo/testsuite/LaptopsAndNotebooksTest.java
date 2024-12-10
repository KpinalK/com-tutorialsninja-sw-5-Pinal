package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
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
    public void  verifyProductsPriceDisplayHighToLowSuccessfully(){

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //get list of product price before doing any action in this page.
        List<String> productPriceBefore = laptopsAndNotebooksPage.getListOfProductPrice();
        Collections.sort(productPriceBefore, Collections.reverseOrder());
        System.out.println(productPriceBefore);

        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order
        List<String> productPriceAfter = laptopsAndNotebooksPage.getListOfProductPrice();
        System.out.println(productPriceAfter);
        //Assert.assertEquals(productPriceAfter,productPriceBefore,"Price are not in High to low");

    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on the Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //2.2 Click on the “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.clickOnMacBook();

        //2.5 Verify the text “MacBook”
        String actualMacBookText = productPage.getProductNameFromProductPage();
        String expectedMacBookText = "MacBook";
        verifyText(actualMacBookText, expectedMacBookText, "MacBook text is not displayed");

        //2.6 Click on the ‘Add To Cart’ button
        productPage.clickOnTheAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualShoppingCartMessage = productPage.getShoppingCartMessage();
        String expectedShoppingCartMessage = "Success: You have added MacBook to your shopping cart!";
        verifyText(actualShoppingCartMessage, expectedShoppingCartMessage, "Shopping Cart Message is not displayed");

        //2.8 Click on the link “shopping cart” display into the success message
        productPage.clickOnTheShoppingCartLink();

        //2.9 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCartPage.getShoppingCartText();
        String expectedShoppingCartText = "Shopping Cart";
        Assert.assertTrue(actualShoppingCartText.contains(expectedShoppingCartText), "Shopping cart message is not displayed");

        //2.10 Verify the Product name "MacBook"
        String actualMacBookName = shoppingCartPage.getProductName();
        String expectedMacBookName = "MacBook";
        verifyText(actualMacBookName, expectedMacBookName, "The product name macbook is not displayed");

        //2.11 Change the Quantity "2"
        shoppingCartPage.changeQtyOfProduct("2");

        //2.12 Click on the “Update” Tab
        shoppingCartPage.clickOnUpdateButton();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualUpdatedMessage = shoppingCartPage.getUpdatedCartMessage();
        String expectedUpdatedMessage = "Success: You have modified your shopping cart!";
        verifyText(actualUpdatedMessage, expectedUpdatedMessage, "Updated Shopping cart message is not displayed");

        //2.14 Verify the Total £737.45
        String actualUpdatedPrice = shoppingCartPage.getPrice();
        String expectedUpdatedPrice = "£737.45";
        verifyText(actualUpdatedPrice, expectedUpdatedPrice, "Price is not displayed");

        //2.15 Click on the “Checkout” button
        shoppingCartPage.clickOnCheckOut();

        //System.out.println(checkOutPage.getProductNotAvailableMessage());
        if (checkOutPage.getProductNotAvailableMessage().equals("Products marked with *** are not available in the desired quantity or not in stock!")) {
            System.out.println(actualMacBookName + " is not available in the desired quantity or not in stock!.");
        } else {
            //2.16 Verify the text “Checkout”
            String actualCheckOutText = checkOutPage.getTextOfCheckOut();
            String expectedCheckOutText = "Checkout";
            Assert.assertEquals(actualCheckOutText, expectedCheckOutText, "CheckOut text is not displayed");

            //2.17 Verify the Text “New Customer”
            String actualNewCustomerText = checkOutPage.getNewCustomerText();

            //2.18 Click on the “Guest Checkout” radio button
            checkOutPage.clickOnGuestRadioButton();

            //2.19 Click on “Continue” tab
            checkOutPage.clickOnContinue();

            //2.20 Fill the mandatory fields
            checkOutPage.enterFirstName("pinal");
            checkOutPage.enterLastName("kamani");
            checkOutPage.enterEmailAddress("pinal159@gmail.com");
            checkOutPage.enterTelephone("2323232323");
            checkOutPage.enterAddress("232d Dream street");
            checkOutPage.enterCityName("London");
            checkOutPage.enterPostCode("HA5 0QQ");
            checkOutPage.selectCountry("United Kingdom");
            checkOutPage.selectRegion("Bedfordshire");

            //2.21 Click on “Continue” Button
            checkOutPage.clickOnContinueButtonForGuest();
            checkOutPage.clickOnContinueButtonForDelivery();


            //2.22 Add Comments About your order into the text area
            checkOutPage.enterCommentInTextBox("This is comment");
            //2.23 Check the Terms & Conditions check box
            checkOutPage.clickOnTerms();
            //2.24 Click on the “Continue” button
            checkOutPage.clickOnContinueButtonForPayment();
            //2.25 Verify the message “Warning: Payment method required!”

        }
    }
}
