package com.company.projectappiume2e.pages;

import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver){  //se recibe en el constructor para poder instanciarla
        this.driver = driver;
    }
}
