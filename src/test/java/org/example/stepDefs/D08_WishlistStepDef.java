package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("press on the wishlist button.")
    public void pressWishListButton()
    {
        homePage.pressTheWlButton().click();
    }

    @Then("the wishlist message appears and its colo is green.")
    public void assertionOfTheWishListMessage() throws InterruptedException {
        Thread.sleep(1000);
       Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")).isDisplayed();
        String color = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        System.out.println("The color is :: " + color);
        String actualColor = Color.fromString(color).asHex();
        String expectedBackgroundColor = "#4bb07a";

        Assert.assertEquals(expectedBackgroundColor , actualColor);

    }

    @Given("press the wishlist button.")
    public void pressTheWlButton()
    {
        homePage.pressTheWlButton().click();
    }

    @And("open wishlist screen and check the quantity")
    public void openWlScreen() throws InterruptedException {
        Thread.sleep(10000);
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-wishlist\"]")).click();
        WebElement qtyField = Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
        String valueOfTheTextField = qtyField.getAttribute("value");
        System.out.println("the value of thr qty field = "+ valueOfTheTextField);
        int assertTheValue = Integer.parseInt(valueOfTheTextField);
        Assert.assertTrue("its equal to zero" , assertTheValue!=0);
    }
}
