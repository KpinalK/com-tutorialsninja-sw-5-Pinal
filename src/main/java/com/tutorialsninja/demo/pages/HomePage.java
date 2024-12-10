package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopMenu;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotebookMenu;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentMenu;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement clickShowAllDesktops;


    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(css = "button[name='GBP']")
    WebElement poundCurrency;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;

//    @CacheLookup
//    @FindBy(xpath = "//li[@class='dropdown open']//li/a")
//    WebElement selectMyAccountOption;
    By selectMyAccountOption = By.xpath("//li[@class='dropdown open']//li/a");


    /**
     * This method will do mouse hover and click on teh desktop menu
     */
    public void mouseHoverAndClickOnDesktop() {
        CustomListeners.test.log(Status.PASS,"mouse Hover And Click On Desktop");
        mouseHoverToElementAndClick(desktopMenu);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnLaptopAndNoteBook() {
        CustomListeners.test.log(Status.PASS,"mouseHover And ClickOn LaptopAndNoteBook");
        mouseHoverToElementAndClick(laptopAndNotebookMenu);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnComponents() {
        CustomListeners.test.log(Status.PASS,"mouseHover And ClickOn Components");
        mouseHoverToElementAndClick(componentMenu);
    }

    /**
     * This method will do mouse hover and click on the Currency Tab
     */
    public void mouseHoverAndClickOnCurrency() {
        CustomListeners.test.log(Status.PASS,"mouseHover And ClickOn Currency");
        mouseHoverToElementAndClick(currencyTab);
    }

    /**
     * This method will do mouse hover and click on the pound currency
     */
    public void mouseHoverAndClickOnPoundCurrency() {
        CustomListeners.test.log(Status.PASS,"mouseHover And ClickOn PoundCurrency");
        mouseHoverToElementAndClick(poundCurrency);
    }

    /**
     * This method will click on selected Menu tab
     */
    public void selectMenu(String link) {
        CustomListeners.test.log(Status.PASS,"String link" + link);
        clickOnElement(By.linkText(link));
    }

    /**
     * This method will click on my account link.
     */
    public void clickOnMyAccountLink() {
        CustomListeners.test.log(Status.PASS,"click On MyAccount Link");
        clickOnElement(myAccountLink);
    }


    /**
     * This method will select option from my account link
     */
    public void selectMyAccountOption(String option) {
        CustomListeners.test.log(Status.PASS,"select MyAccount Option" +option);
        List<WebElement> options = findElements(selectMyAccountOption);
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnShoeAllDesktops() {
        CustomListeners.test.log(Status.PASS,"click On Shoe AllDesktops");
        clickOnElement(clickShowAllDesktops);
    }


}
