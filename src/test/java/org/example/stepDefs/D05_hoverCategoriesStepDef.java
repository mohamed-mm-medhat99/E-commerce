package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();
    Actions action = new Actions(Hooks.driver);

    @When("hover on one of the categories and choose sub-category.")
    public void hoverOnMenu() {
        homePage.hover(); //locate and save the elements
        int size = homePage.hover().size()-4;
//        System.out.println("the size of the bar = " + size);

        int min = 1;
        int max = size-1 ;
        Random r = new Random();
        int selectedMenu =  r.nextInt(size-min) + min;
//        System.out.println("selected Menu" + selectedMenu);
        action.moveToElement( homePage.hover().get(selectedMenu)).perform();
//        System.out.println("the selected category " + menuText);



        selectedMenu = selectedMenu+1;
        String elementLocator = "(//ul[@class='top-menu notmobile']//ul)["+selectedMenu+"]/li";
//        System.out.println("locator "+ elementLocator);
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(elementLocator));
        String selectedSubCat_Text ;
        int low = 1;
        int high = 3;
        if(!subCategoryLinks.isEmpty()) {
            int selectedSubCat =  r.nextInt(3-1) + 1;
            selectedSubCat_Text = subCategoryLinks.get(selectedSubCat).getText().toLowerCase().trim();
//            System.out.println("selected sub category title : " + selectedSubCat_Text);
            subCategoryLinks.get(selectedSubCat).click();

            String actualSubCategoryTitle = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")).getText().toLowerCase().trim();
            Assert.assertEquals(selectedSubCat_Text , actualSubCategoryTitle);
        }
        else
        {
            System.out.println("there is a problem in the if condition");
            selectedMenu = selectedMenu -1;
            homePage.hover().get(selectedMenu).click();
//            System.out.println("i pressed and added 1");
        }
    }
}
