package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import com.company.projectappiume2e.pages.RedmineHomePageObject;
import com.company.projectappiume2e.pages.RedmineLoginPageObject;
import com.company.projectappiume2e.util.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidEmulatorRedmineLoginWebUITest extends BaseTest {

    private static RedmineLoginPageObject redmineLoginPage;

    @Test
    public void testLoginRedmineEmulatorNexus6Android10(){

        DesiredCapabilities capabilities = new DesiredCapabilities();  //propiedades del aplicativo donde se va a probar
        //propiedades generales
        capabilities.setCapability("automationName", "UiAutomator2"); //dispositivo android, si fuera XCUITest=IOS
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Nexus6Android10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("chromedriverExecutableDir", "resources/drivers/chrome/windows/chromedriver244_chrome69_nexus5_A7.exe");

        //propiedades únicas de android
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("avd", "Nexus6Android10");
        capabilities.setCapability("avdArgs", "-port 5557");
        capabilities.setCapability("noSign", true);

        configAppiumDriver(capabilities); //llamar al método y enviar el capabilities

        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPageObject(driver);
        RedmineHomePageObject redmineHomePage = redmineLoginPage.login("jhurtado", "passw0rd");
        redmineHomePage.clickOnMobileMenu();
        assertEquals("user", redmineHomePage.getUserLoggedMobileEmulation());


    }
}
