package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login login = new P02_login();

    @When("user go to login page")
    public void loginPage()
    {
        login.navigateToLogin().click();
    }


    @And("^user login with valid \"(.*)\" and \"(.*)\"$")
    public void validLogin(String mail , String password)
    {
        login.loginSteps(mail , password);
    }


    @And("user press on login button")
    public void loginButton() {
        login.clicker();
    }

    @And("user login to the system successfully")
    public void loginSuccessfully()
    {
        SoftAssert soft = new SoftAssert();
        //assertion of URL
        String expectedLink = "https://demo.nopcommerce.com/";
        soft.assertEquals( Hooks.driver.getCurrentUrl() ,expectedLink);
        //assert that my account tab displayed
//        String select = "//*[@class='ico-account']";
        soft.assertTrue(Hooks.driver.findElement(By.xpath("//*[@class='ico-account']")).isDisplayed(), "correct");
        soft.assertAll();
    }



    @Then("^user login with invalid \"(.*)\" and \"(.*)\"$")
    public void loginInvalid(String mail , String password)
    {
       login.loginSteps(mail , password);
    }

    @And("user click on login button")
    public void buttonLoginClick()
    {
        login.clicker();
    }

    @And("user could not login to the system")
    public void loginFailedMessage()
    {
     SoftAssert soft = new SoftAssert();
     String expectedMessage = "Login was unsuccessful.";
     soft.assertTrue(Hooks.driver.findElement(By.xpath("//*[@class='message-error validation-summary-errors']")).getText().contains(expectedMessage), "notContain" );
//     soft.assertEquals(, );
        String messageColor = Hooks.driver.findElement(By.xpath("//*[@class='message-error validation-summary-errors']")).getCssValue("color"); //RGBA
        String expectedMessageColor = "#e4434b";
        System.out.println("the convirted color :" + Color.fromString(messageColor).asHex());
        soft.assertEquals(Color.fromString(messageColor).asHex(), expectedMessageColor);

        soft.assertAll();

    }
}
