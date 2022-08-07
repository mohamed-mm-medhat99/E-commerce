package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage homePage = new P03_homePage();

    @When("user opens facebook link")
    public void clickOnLink()
    {

        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
    }

    @Then("^\"([^\"]*)\" is opened in new tab$")
    public void assertTheUrl(String url)
    {
       homePage.openTheNewTab(url);
    }

    @When("user opens twitter link")
    public void openTwitter ()
    {
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
    }

    @Then("^\"([^\"]*)\" is opened in a new tab$")
    public void assertTlink(String url)
    {
        homePage.openTheNewTab(url);
    }


    @When("user opens rss link")
    public void openRss ()
    {
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
    }

    @Then("^\"([^\"]*)\" is opened$")
    public void assertRssLink(String url)
    {
        homePage.openTheNewTab(url);
    }

    @When("user opens youtube link")
    public void openYouTube ()
    {
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
    }

    @Then("^\"([^\"]*)\" is opened successfully$")
    public void assertyoutubeLink(String url)
    {
        homePage.openTheNewTab(url);
    }
}
