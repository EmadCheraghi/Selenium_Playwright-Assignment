package com.saucedemo.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    WebDriver driver;

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void loginAsStandardUser_loadsInventory() {
        Config cfg = new Config();
        driver = DriverFactory.createDriver(cfg);
        new AuthFlow(driver, cfg).loginStandardUser();
        assertTrue(new InventoryPage(driver, cfg.baseUrl, cfg.timeoutS).isLoaded());
    }
}
