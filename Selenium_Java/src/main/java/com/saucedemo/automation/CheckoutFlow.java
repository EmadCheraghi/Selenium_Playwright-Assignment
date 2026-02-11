package com.saucedemo.automation;

import org.openqa.selenium.WebDriver;

/**
 * Reusable checkout flow helpers. Encapsulates login → add item → cart → information → overview → confirmation.
 */
public final class CheckoutFlow {
    public static final String DEFAULT_ADD_TO_CART_ID = "add-to-cart-sauce-labs-backpack";

    private CheckoutFlow() {}

    public static void loginAndAddItemGoToCart(WebDriver driver, Config cfg) {
        loginAndAddItemGoToCart(driver, cfg, DEFAULT_ADD_TO_CART_ID);
    }

    public static void loginAndAddItemGoToCart(WebDriver driver, Config cfg, String addToCartId) {
        new AuthFlow(driver, cfg).loginStandardUser();
        InventoryPage inv = new InventoryPage(driver, cfg.baseUrl, cfg.timeoutS);
        inv.addItemById(addToCartId);
        inv.openCart();
        ShoppingCartPage cart = new ShoppingCartPage(driver, cfg.baseUrl, cfg.timeoutS);
        if (!cart.isLoaded()) throw new AssertionError("Cart page did not load");
    }

    public static void goToInformationPage(WebDriver driver, Config cfg) {
        new ShoppingCartPage(driver, cfg.baseUrl, cfg.timeoutS).goToCheckout();
        InformationPage info = new InformationPage(driver, cfg.baseUrl, cfg.timeoutS);
        if (!info.isLoaded()) throw new AssertionError("Information page did not load");
    }

    public static void fillInformationAndGoToOverview(WebDriver driver, Config cfg,
            String firstName, String lastName, String postalCode) {
        new InformationPage(driver, cfg.baseUrl, cfg.timeoutS)
                .fillAndContinue(firstName, lastName, postalCode);
        OverviewPage ov = new OverviewPage(driver, cfg.baseUrl, cfg.timeoutS);
        if (!ov.isLoaded()) throw new AssertionError("Overview page did not load");
    }

    public static void finishAndGoToConfirmation(WebDriver driver, Config cfg) {
        new OverviewPage(driver, cfg.baseUrl, cfg.timeoutS).finishCheckout();
        ConfirmationPage conf = new ConfirmationPage(driver, cfg.baseUrl, cfg.timeoutS);
        if (!conf.isLoaded()) throw new AssertionError("Confirmation page did not load");
    }

    public static void loginAndCompleteCheckout(WebDriver driver, Config cfg) {
        loginAndCompleteCheckout(driver, cfg, "John", "Doe", "12345");
    }

    public static void loginAndCompleteCheckout(WebDriver driver, Config cfg,
            String firstName, String lastName, String postalCode) {
        loginAndAddItemGoToCart(driver, cfg);
        goToInformationPage(driver, cfg);
        fillInformationAndGoToOverview(driver, cfg, firstName, lastName, postalCode);
        finishAndGoToConfirmation(driver, cfg);
    }
}
