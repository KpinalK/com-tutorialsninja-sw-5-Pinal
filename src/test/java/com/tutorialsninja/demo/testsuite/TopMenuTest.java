package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DeskTopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;


@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DeskTopPage deskTopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
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
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Mouse hover on the “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();

        //call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //Verify the text ‘Desktops’
        String expectedDesktopText = "Desktops";
        String actualDesktopText = deskTopPage.getDesktopText();
        verifyText(actualDesktopText, expectedDesktopText, "Desktop text is not display");
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //Mouse hover on the “Laptop and Notebook” Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = laptopsAndNotebooksPage.verifyTheTextLaptopsAndNotebooks();
        verifyText(actualText, expectedText, "Laptops & Notebooks text is not display");
    }

    @Test(groups = {"smoke", "regression1"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on the “Component” Tab and click
        homePage.mouseHoverAndClickOnComponents();

        // call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");

        //Verify the text ‘Components'
        String expectedText = "Components";
        String actualText = componentsPage.verifyTheTextComponents();
        verifyText(actualText, expectedText, "Components text is not display");
    }
}
