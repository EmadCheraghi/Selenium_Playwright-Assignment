package com.saucedemo.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutTest {

    WebDriver driver;
    Config cfg;

    @BeforeEach
    void setUp() {
        cfg = new Config();
        driver = DriverFactory.createDriver(cfg);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void checkoutButtonOnCart_isClickable() {
        CheckoutFlow.loginAndAddItemGoToCart(driver, cfg);
        assertTrue(driver.findElement(By.id("checkout")).isDisplayed());
    }

    @Test
    void checkoutClick_navigatesToInformationPage() {
        CheckoutFlow.loginAndAddItemGoToCart(driver, cfg);
        CheckoutFlow.goToInformationPage(driver, cfg);
        assertTrue(new InformationPage(driver, cfg.baseUrl, cfg.timeoutS).isLoaded());
    }

    @Test
    void fullCheckout_completesToConfirmationPage() {
        CheckoutFlow.loginAndCompleteCheckout(driver, cfg);
        assertTrue(new ConfirmationPage(driver, cfg.baseUrl, cfg.timeoutS).isLoaded());
    }

    @Test
    void backToHome_fromConfirmation_navigatesToInventory() {
        CheckoutFlow.loginAndCompleteCheckout(driver, cfg);
        new ConfirmationPage(driver, cfg.baseUrl, cfg.timeoutS).backToInventory();
        assertTrue(new InventoryPage(driver, cfg.baseUrl, cfg.timeoutS).isLoaded());
    }
}
