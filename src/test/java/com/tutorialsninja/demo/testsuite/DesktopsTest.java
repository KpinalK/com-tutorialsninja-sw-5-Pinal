package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DeskTopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DeskTopPage deskTopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
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
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 Click on “Show All Desktops”
        homePage.clickOnShoeAllDesktops();

        //1.3 Select Sort By position "Name: Z to A"
        List<String> productsNameBefore = deskTopPage.getListOfProductsName();
        Collections.sort(productsNameBefore, Collections.reverseOrder());
        System.out.println(productsNameBefore);

        //Select Sort By position "Name: Z to A"
        deskTopPage.selectSortByFilter("Name (Z - A)");

        // 1.4 Verify the Product will arrange in Descending order.
        List<String> productsNameAfter = deskTopPage.getListOfProductsName();
        verifyText(productsNameAfter, productsNameBefore, "Product is not display in descending order");
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrency();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverAndClickOnPoundCurrency();

        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktop();

        //2.4 Click on “Show All Desktops”
        homePage.clickOnShoeAllDesktops();

        //2.5 Select Sort By position "Name: A to Z"
        deskTopPage.selectSortByFilter("Name (A - Z)");

        //2.6 Select product <product>
        deskTopPage.clickOnHPLP3065Product();

        //2.7 Verify the Text "HP LP3065"
        String actualProductName = productPage.getProductNameFromProductPage();
        String expectedProductName = "HP LP3065";
        verifyText(actualProductName, expectedProductName, "The product Name is not display");


        //2.8 Select Delivery Date "2024-11-27"
        productPage.selectDateFromDatePicker("November", "2024", "27");

        //2.9.Enter Qty "1” using Select class.
        productPage.productQty("1");

        //2.10 Click on the “Add to Cart” button
        productPage.clickOnTheAddToCart();

        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualShoppingCartMessage = productPage.getShoppingCartMessage();
        String expectedShoppingCartMessage = "Success: You have added HP LP3065 to your shopping cart!";
        verifyText(actualShoppingCartMessage, expectedShoppingCartMessage, "Shopping cart message is not displayed");

        //2.12 Click on the link “shopping cart” displayed in a success message
        productPage.clickOnTheShoppingCartLink();

        //2.13 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCartPage.getShoppingCartText();
        String expectedShoppingCartText = "Shopping Cart";
        Assert.assertTrue(actualShoppingCartText.contains(expectedShoppingCartText), "Shopping cart text is not displayed");

        //2.14 Verify the Product name "HP LP3065"
        String actualAddedProductName = shoppingCartPage.getProductName();
        String expectedAddedProductName = "HP LP3065";
        verifyText(actualAddedProductName, expectedAddedProductName, "Product name is not displayed");

        //2.15 Verify the Delivery Date "2024-11-27"
        String actualDeliveryDate = shoppingCartPage.getDeliveryDate()[1];
        String expectedDeliveryDate = "2024-11-27";
        verifyText(actualDeliveryDate, expectedDeliveryDate, "The date is not displayed");

        //2.16 Verify the Model "Product21"
        String actualProductModel = shoppingCartPage.getProductModel();
        String expectedProductModel = "Product21";
        verifyText(actualProductModel, expectedProductModel, "Product model is not displayed");

        //2.17 Verify the Total "£74.73"
        String actualProductPrice = shoppingCartPage.getPrice();
        String expectedProductPrice = "£74.73";
        verifyText(actualProductPrice, expectedProductPrice, "Product model is not displayed");
    }


}
