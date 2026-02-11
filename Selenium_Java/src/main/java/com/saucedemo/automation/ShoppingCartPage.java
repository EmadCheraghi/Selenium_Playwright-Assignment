package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    private static final By CHECKOUT_BTN = By.id("checkout");

    public ShoppingCartPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public boolean isLoaded() {
        return waitVisible(CHECKOUT_BTN).isDisplayed();
    }

    public void goToCheckout() {
        waitClickable(CHECKOUT_BTN).click();
    }
}
