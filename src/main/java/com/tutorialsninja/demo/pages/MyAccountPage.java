package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText;


    /**
     * This method will get the myAccount text
     */
    public String getMyAccountText(){
        CustomListeners.test.log(Status.PASS,"get MyAccount Text");
        return getTextFromElement(myAccountText);
    }
}
