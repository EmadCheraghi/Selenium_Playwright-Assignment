package com.saucedemo.automation;

/**
 * Test configuration. Values can be overridden via system properties or env.
 */
public class Config {
    public final String baseUrl;
    public final String browser;
    public final boolean headless;
    public final int timeoutS;

    public Config() {
        this.baseUrl = get("BASE_URL", "https://www.saucedemo.com");
        this.browser = get("BROWSER", "firefox").toLowerCase();
        this.headless = "true".equalsIgnoreCase(get("HEADLESS", "true"));
        this.timeoutS = Integer.parseInt(get("TIMEOUT_S", "15"));
    }

    private static String get(String key, String defaultValue) {
        String v = System.getProperty(key);
        if (v != null && !v.isEmpty()) return v;
        v = System.getenv(key);
        return v != null ? v : defaultValue;
    }
}
