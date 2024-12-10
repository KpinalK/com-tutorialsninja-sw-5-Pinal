package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonElementPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;

//    @CacheLookup
//    @FindBy(xpath = "//li[@class='dropdown open']//li/a")
//    WebElement selectMyAccountOption;
    By selectMyAccountOption = By.xpath("//li[@class='dropdown open']//li/a");

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logoutMessageElement;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueButton;


    /**
     * This method will select option from my account link
     */
    public void selectMyAccountOption(String option) {
        CustomListeners.test.log(Status.PASS," select MyAccount Option" + option);
        List<WebElement> options = findElements(selectMyAccountOption);
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    /**
     * This method will click on my account link.
     */
    public void clickOnMyAccountLink() {
        CustomListeners.test.log(Status.PASS,"click On MyAccount Link");
        clickOnElement(myAccountLink);
    }

    /**
     * This method will get the logout message
     */
    public String getLogoutText() {
        CustomListeners.test.log(Status.PASS,"get Logout Text");
        return getTextFromElement(logoutMessageElement);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS,"click On Continue Button");
        clickOnElement(continueButton);
    }

}
