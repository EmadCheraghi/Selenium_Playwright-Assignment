package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR = By.cssSelector("[data-test=\"error\"]");

    public LoginPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public LoginPage load() {
        open("/");
        waitVisible(USERNAME);
        return this;
    }

    public void login(String username, String password) {
        waitVisible(USERNAME).clear();
        driver.findElement(USERNAME).sendKeys(username);
        waitVisible(PASSWORD).clear();
        driver.findElement(PASSWORD).sendKeys(password);
        waitClickable(LOGIN_BTN).click();
    }

    public String getErrorText() {
        try {
            return waitVisible(ERROR).getText().strip();
        } catch (Exception e) {
            return null;
        }
    }
}
