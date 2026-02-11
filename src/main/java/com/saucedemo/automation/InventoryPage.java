package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private static final By TITLE = By.className("title");
    private static final By CART_LINK = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver, String baseUrl, int timeoutSeconds) {
        super(driver, baseUrl, timeoutSeconds);
    }

    public boolean isLoaded() {
        return "Products".equals(waitVisible(TITLE).getText().strip());
    }

    public void addItemById(String itemId) {
        waitClickable(By.id(itemId)).click();
    }

    public void openCart() {
        waitClickable(CART_LINK).click();
    }
}
