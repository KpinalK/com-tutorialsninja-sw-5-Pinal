package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeskTopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopText;

    //@CacheLookup
//    @FindBy(xpath = "//div[@id='content']//div//div[1]//div[2]//div[1]//h4")
//    WebElement productNames;
    By productNames = By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//h4");

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectFilter;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement hpDesktop;


    /**
     * This method will get desktop text from desktop page
     */
    public String getDesktopText() {
        CustomListeners.test.log(Status.PASS,"get Desktop Text");
        return getTextFromElement(desktopText);
    }

    /**
     * This method will return list of product names
     */
    public List<String> getListOfProductsName() {
        CustomListeners.test.log(Status.PASS,"get List Of ProductsName");
        return getListOfTextFromElement(productNames);
    }

    /**
     * This method will get the product name
     *//*
    public String getProductName() {
        return getTextFromElement()
    }
*/

    /**
     * This method will click on the HP LP3065
     */
    public void clickOnHPLP3065Product() {
        CustomListeners.test.log(Status.PASS,"click On HPLP3065 Product");
        clickOnElement(hpDesktop);
    }

    /**
     * This Method will sort the data in selected filter
     */
    public void selectSortByFilter(String option) {
        CustomListeners.test.log(Status.PASS,"select Sort ByFilter");
        selectByVisibleTextFromDropDown(selectFilter, option);
    }

}
