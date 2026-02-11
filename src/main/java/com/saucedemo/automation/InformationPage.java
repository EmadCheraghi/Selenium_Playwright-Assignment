package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage extends BasePage {
    private static final By TITLE = By.className("title");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BTN = By.id("continue");

    public InformationPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public boolean isLoaded() {
        return "Checkout: Your Information".equals(waitVisible(TITLE).getText().strip());
    }

    public void fillAndContinue(String firstName, String lastName, String postalCode) {
        waitVisible(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        waitVisible(LAST_NAME).clear();
        driver.findElement(LAST_NAME).sendKeys(lastName);
        waitVisible(POSTAL_CODE).clear();
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        waitClickable(CONTINUE_BTN).click();
    }
}
