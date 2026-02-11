package com.saucedemo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Creates WebDriver instances based on Config.
 */
public final class DriverFactory {

    public static WebDriver createDriver(Config cfg) {
        WebDriver driver;
        if ("firefox".equals(cfg.browser)) {
            FirefoxOptions opts = new FirefoxOptions();
            if (cfg.headless) opts.addArguments("-headless");
            driver = new FirefoxDriver(opts);
        } else {
            ChromeOptions opts = new ChromeOptions();
            if (cfg.headless) opts.addArguments("--headless=new");
            opts.addArguments("--window-size=1280,900", "--disable-notifications");
            driver = new ChromeDriver(opts);
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(cfg.timeoutS));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        return driver;
    }

    private DriverFactory() {}
}
