package org.example.pages;


import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement navigateToLogin()
    {
        return Hooks.driver.findElement(By.className("ico-login"));
    }
    public void loginSteps(String mail , String password)
    {
        Hooks.driver.findElement(By.id("Email")).sendKeys(mail);
        Hooks.driver.findElement(By.id("Password")).sendKeys(password);
    }
    public void clicker(){
        Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
    }
}
