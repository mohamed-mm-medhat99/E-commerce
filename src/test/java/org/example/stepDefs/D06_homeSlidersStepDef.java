package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D06_homeSlidersStepDef {

    @Given("click on the home slider first image and verify the link")
    public void ClickOnTheSliderAndAssertTheUrl() throws InterruptedException {
        WebElement imageOneSlider = Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]"));
        imageOneSlider.click();
        Thread.sleep(1000);
        System.out.println("successfully located");
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertSame("Not The Same Link", expectedUrl, actualUrl);
//        Assert.assertEquals(expectedUrl , actualUrl);
    }

    @Given("click on the home slider second image and verify the link")
    public void secondImage() throws InterruptedException {
        Thread.sleep(5000);
        WebElement imageTwoSlider = Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]"));
        imageTwoSlider.click();
        Thread.sleep(2000);
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        String actualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertSame("Not The Same Link", expectedUrl, actualUrl);
    }
}
/*https://demo.nopcommerce.com/nokia-lumia-1020*/