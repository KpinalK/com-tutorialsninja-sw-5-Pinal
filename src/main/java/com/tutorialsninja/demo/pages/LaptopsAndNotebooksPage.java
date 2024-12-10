package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement verifyLaptopsAndNotebooks;

//    @CacheLookup
//    @FindBy(xpath = "//div[@id='content']//div//div[1]//div[2]//div[1]//p[2]")
//    WebElement listOfProductName;
    By listOfProductName = By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//p[2]");

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement selectSort;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    WebElement macBookProduct;
    //By macBookProduct = By.xpath("//a[normalize-space()='HP LP3065']");

    public String verifyTheTextLaptopsAndNotebooks() {
        CustomListeners.test.log(Status.PASS,"verify The Text LaptopsAndNotebooks");
        return getTextFromElement(verifyLaptopsAndNotebooks);
    }
    /**
     * This method will get name of all products
     */
    public List<String> getListOfProductPrice() {
        CustomListeners.test.log(Status.PASS,"getListOfProductPrice");
        List<WebElement> priceList = findElements(listOfProductName);

        List<String> priceListBefore = new ArrayList<>();
        for (WebElement e : priceList) {
            String price = e.getText().split("\n")[0].replace("$", "").trim();
            priceListBefore.add(price);
        }
        return priceListBefore;
    }

    /**
     * This method will sort the list of product
     */
    public void sortProductByPrice(String option) {
        CustomListeners.test.log(Status.PASS,"sort Product ByPrice" + option);
        selectByVisibleTextFromDropDown(selectSort, option);
    }

    /**
     * This method will click on macBook product
     */
    public void clickOnMacBook() {
        CustomListeners.test.log(Status.PASS,"click On MacBook");
        clickOnElement(macBookProduct);
    }

}
