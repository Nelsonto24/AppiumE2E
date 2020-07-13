package com.company.projectappiume2e.pages;

import com.company.projectappiume2e.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedmineProjectPageObject extends Page {

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtProjectName = By.id("project_name");
    private By txtProjectDescription = By.id("project_description");
    private By txtProjectHomePage = By.id("project_homepage");
    private By chkProjectPublic = By.id("project_is_public");
    private By btnCreateProject = By.name("commit");
    private By lblMessage = By.id("flash_notice");

    public RedmineProjectPageObject(WebDriver driver) {
        super(driver);
    }

    public void createProject(RedmineProject redmineProject) {
        driver.findElement(btnNewProject).click();
        driver.findElement(txtProjectName).sendKeys(redmineProject.getName());
        driver.findElement(txtProjectDescription).sendKeys(redmineProject.getDescription());
        driver.findElement(txtProjectHomePage).sendKeys(redmineProject.getHomePage());

        WebElement checkBoxProject = driver.findElement(chkProjectPublic);
        if (redmineProject.getPublic()) {      //si es true
            if (!checkBoxProject.isSelected())  // y no está marcado el casillero
                checkBoxProject.click();
        }
        else{                                   // para que sea false
            if (checkBoxProject.isSelected())
                checkBoxProject.click();
        }
        driver.findElement(btnCreateProject).click();
    }

    public String getUIMessage(){

        //Explicit wait -> si no aparece el label, espera 5 segundos por el elemento mensaje y luego retorna el texto del mensaje
        //WebDriverWait wait=new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblMessage)));
        return driver.findElement(lblMessage).getText();
    }
}

