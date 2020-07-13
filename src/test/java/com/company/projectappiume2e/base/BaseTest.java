package com.company.projectappiume2e.base;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AppiumDriver driver; //sirve para IOS y Android

    public static void configAppiumDriver(DesiredCapabilities capabilities) {

        try {
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
        /*@AfterAll
        public static void tearDown(){
            driver.quit();
        }*/
    }
