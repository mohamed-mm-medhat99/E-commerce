package org.example.pages;

import org.example.stepDefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P03_homePage {

    public List<WebElement> searchForCurrency() {
        return Hooks.driver.findElements(By.xpath("//*[@class='price actual-price']"));

    }

    public WebElement searchKeyWord() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement Click() {
        return Hooks.driver.findElement(By.xpath("//*[@class='button-1 search-box-button']"));
    }

    public List<WebElement> relevantResults() {
        return Hooks.driver.findElements(By.xpath("//*[@class='item-box']"));
    }

    public WebElement navigateToDetails() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[1]/a/img"));

    }

    public List<WebElement> hover()
    {
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    public void openTheNewTab(String url)
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        String tabOne =  Hooks.driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        Assert.assertEquals(url , tabOne);

        Hooks.driver.close();
    }

    public WebElement pressTheWlButton()
    {
       return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }
}

/*"a[href=\"http://www.facebook.com/nopCommerce\"]"*/
/*"a[href="https://www.facebook.com/nopCommerce"]"*/
//  \"" + url + "\"
/*a[href="+url+"]*/
/*   //*[text()='Facebook']             */

