package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement components;

    public String verifyTheTextComponents(){
        CustomListeners.test.log(Status.PASS,"verify The Text Components");
        return getTextFromElement(components);
    }
}
