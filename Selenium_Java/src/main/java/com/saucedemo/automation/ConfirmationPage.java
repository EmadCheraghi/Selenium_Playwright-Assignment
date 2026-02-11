package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {
    private static final By COMPLETE_MESSAGE = By.cssSelector(".complete-header, .complete-text");
    private static final By BACK_TO_PRODUCTS = By.id("back-to-products");

    public ConfirmationPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public boolean isLoaded() {
        String text = waitVisible(COMPLETE_MESSAGE).getText();
        return text != null && (text.contains("Thank you") || text.contains("Complete") || text.toLowerCase().contains("order"));
    }

    public void backToInventory() {
        waitClickable(BACK_TO_PRODUCTS).click();
    }
}
