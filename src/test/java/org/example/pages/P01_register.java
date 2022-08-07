package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement name ()
    {
        return  Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName () {return  Hooks.driver.findElement(By.id("LastName"));}

    public WebElement firstPassword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmationPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement email()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement dropdownElementsFinder(String name)
    {
        return Hooks.driver.findElement(By.name(name));
    }

    public WebElement registrationButton()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement successMessage()
    {
        return Hooks.driver.findElement(By.className("result"));
    }
}
