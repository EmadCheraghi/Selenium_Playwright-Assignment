package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    private static final By TITLE = By.className("title");
    private static final By FINISH_BTN = By.id("finish");

    public OverviewPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public boolean isLoaded() {
        return "Checkout: Overview".equals(waitVisible(TITLE).getText().strip());
    }

    public void finishCheckout() {
        waitClickable(FINISH_BTN).click();
    }
}
