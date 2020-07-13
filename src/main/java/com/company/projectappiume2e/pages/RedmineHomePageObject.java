package com.company.projectappiume2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedmineHomePageObject extends Page{

    private By menuMyPage = By.xpath("//a[@href='/my/page']");
    private By menuProjects = By.xpath("//a[@href='/projects']");
    private By menuAdmin = By.xpath("//a[@href='/admin']");
    private By menuHelp = By.xpath("//a[@href='https://www.redmine.org/guide']");
    private By menuMobileEmulationMenuButton = By.xpath("//*[@id='header']/a");
    private By menuMobileEmulationlblUserLogged = By.xpath("//*[@id='wrapper']/div[1]/div[2]/a");
    private By lblUserLogged = By.id("loggedas");

    public RedmineHomePageObject(WebDriver driver) {
        super(driver);
    }

    public String getUserLogged() {
        return driver.findElement(lblUserLogged).getText();
    }

    public String getUserLoggedMobileEmulation(){
        return driver.findElement(menuMobileEmulationlblUserLogged).getText();
    }

    public void clickOnMobileMenu(){  //método para que se haga click en el navicon y ver el usuario logeado (líneas horizontales)
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(menuMobileEmulationMenuButton));
        driver.findElement(menuMobileEmulationMenuButton).click();
    }

    public RedmineProjectPageObject clickOnLink(String option) {
        switch (option.toLowerCase()) {
            case "my page":
                driver.findElement(menuMyPage).click();
                break;
            case "projects":
                driver.findElement(menuProjects).click();
                break;
            case "administration":
                driver.findElement(menuAdmin).click();
                break;
            case "help":
                driver.findElement(menuHelp).click();
                break;
            default:
                throw new IllegalStateException("The option " + option.toLowerCase() + " is not present");
        }

        return new RedmineProjectPageObject(driver);
    }

}
