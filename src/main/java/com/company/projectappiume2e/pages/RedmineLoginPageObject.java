package com.company.projectappiume2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

  public class RedmineLoginPageObject extends Page{

    private By txtUsername= By.id("username");
    private By txtPassword= By.name("password");
    private By btnLogin= By.xpath("//*[@id=\"login-submit\"]");

    public RedmineLoginPageObject(WebDriver driver){
        super(driver);
    }

    public RedmineHomePageObject login(String username, String password){
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
        return new RedmineHomePageObject(driver);
    }
}
