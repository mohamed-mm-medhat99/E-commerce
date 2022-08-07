package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }

    @And("user select gender type and enter first name \"automation\" and last name \"tester\"")
    public void select_Gender()
    {
        Hooks.driver.findElement(By.id("gender-male")).click();
        register.name().sendKeys("automation");
        register.lastName().sendKeys("tester");
    }

    @And("user enter date of birth")
    public void select_DOB()/*DateOfBirthYear*/
    {
        Select selectDayIndex = new Select(register.dropdownElementsFinder("DateOfBirthDay"));

        selectDayIndex.selectByValue("1");

        Select selectMonthIndex = new Select(register.dropdownElementsFinder("DateOfBirthMonth"));

        selectMonthIndex.selectByValue("10");

        Select selectYearIndex = new Select(register.dropdownElementsFinder("DateOfBirthYear"));

        selectYearIndex.selectByValue("1999");
    }

    @And("user enter email \"test@example.com\" field and password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void emailAndPassword()
    {
        register.email().sendKeys("test0@example.com");
        register.firstPassword().sendKeys("P@ssw0rd");
       register.confirmationPassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void registerButton()
    {
        register.registrationButton().click();
    }

    @And("success message is displayed")
    public void successMessageAssert()
    {
        SoftAssert soft = new SoftAssert();
        String expectedMessage = "Your registration completed";
        String expectedMessageColor = "rgba(76, 177, 124, 1)";

        soft.assertEquals(register.successMessage().getText(), expectedMessage);

        soft.assertEquals(register.successMessage().getCssValue("color") , expectedMessageColor);

        soft.assertAll();

    }

}
