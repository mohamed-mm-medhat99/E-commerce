package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class D04_searchStepDef {


    P03_homePage p03_homePage = new P03_homePage();


    @Given("^writes the search word \"([^\"]*)\"$")
    public void searchBar(String word)
    {
        p03_homePage.searchKeyWord().sendKeys(word);
    }

    @When("click on the search button")
    public void clickOnSearchButton()
    {
        p03_homePage.Click().click();
    }

    @Then("the url should be changed")
    public void urlCheck()
    {
        SoftAssert soft = new SoftAssert();
        String partialuRl = "https://demo.nopcommerce.com/search?q=";
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains(partialuRl));
        System.out.println("url changed");
        soft.assertAll();
    }

    @And("^search show relevant results \"([^\"]*)\"$")
    public void numberAndKeyWordChecker(String searchWord)
    {
        int size = p03_homePage.relevantResults().size();
        System.out.println("the size of the results list =" + size);


            List<WebElement> name = Hooks.driver.findElements(By.xpath("//*[@class='product-title']"));
            for (WebElement names : name) {
                String texts = names.getText().toLowerCase();
                System.out.println(texts);
                Assert.assertTrue("the search word is not shown" , texts.contains(searchWord));
            }

    }

    @When("^write the search sku \"([^\"]*)\"$")
    public void search(String skuNumber)
    {
       p03_homePage.searchKeyWord().sendKeys(skuNumber);
    }
    @And("click on the search button.")
    public void buttonClick()
    {
        p03_homePage.Click().click();
    }

    @And("navigate to the product details screen")
    public void detailsScreen()
    {
        p03_homePage.navigateToDetails().click();
    }

    @Then("check that the search number equals the number appears on the page {string}")
    public void skuChecker(String skuNumber) {         //the sku number retrieved from the features file
       String editedSku = "\"" + skuNumber + "\"";     //the sku number after add double quotes to it to be able to locate the sku number from the product details screen and get its text to apply the assertion.
       String retrivedSku = Hooks.driver.findElement(By.xpath("//*[text()="+editedSku+"]")).getText();
      Assert.assertEquals(skuNumber , retrivedSku);    //assertion applied on the original sku number came which form the features file and the retrived sku number from the product details screen
    }
}
