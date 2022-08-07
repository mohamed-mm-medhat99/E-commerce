package org.example.stepDefs;
import io.cucumber.java.en.And;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D03_currenciesStepDef {
  P03_homePage homepage = new P03_homePage();


  @And("Select Euro currency from the dropdown list on the top left of home page")
  public void chooseAnotherCurrency()
  {
    Hooks.driver.findElement(By.id("customerCurrency")).click();
    Hooks.driver.findElement(By.xpath("//*[@value='https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F']")).click();
  }

  @And("verify that Euro Symbol \\(€) is shown on the 4 products displayed in Home page")
  public void euroSymbolAssertion()
  {

    for (WebElement element : homepage.searchForCurrency()) {
      String texts = element.getText();
      System.out.println(texts);
      Assert.assertTrue("No euro sign found" , texts.startsWith("€"));
    }
  }
}