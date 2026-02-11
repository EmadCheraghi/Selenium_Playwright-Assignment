package com.saucedemo.automation;

import org.openqa.selenium.WebDriver;

/**
 * Reusable login/auth flows. Core library component for tests.
 */
public final class AuthFlow {
    private final WebDriver driver;
    private final Config cfg;

    public AuthFlow(WebDriver driver, Config cfg) {
        this.driver = driver;
        this.cfg = cfg;
    }

    public void loginStandardUser() {
        loginExpectingSuccess("standard_user", "secret_sauce");
    }

    public void loginExpectingSuccess(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, cfg.baseUrl, cfg.timeoutS).load();
        loginPage.login(username, password);
        dismissAlertIfPresent();
        InventoryPage inventory = new InventoryPage(driver, cfg.baseUrl, cfg.timeoutS);
        if (!inventory.isLoaded()) {
            throw new AssertionError("Inventory page did not load after login as " + username);
        }
    }

    private void dismissAlertIfPresent() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {}
    }
}
