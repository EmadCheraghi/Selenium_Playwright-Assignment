# Selenium + Java

## Requirements

- Java 17+
- Maven 3.6+
- Chrome or Firefox (for WebDriver; ChromeDriver/GeckoDriver are managed by Selenium Manager)

## Setup

```bash
cd Selenium_Java
mvn clean compile
```

## Run tests

```bash
mvn test
```

- Run a single test class: `mvn test -Dtest=LoginTest`

## Configuration

System properties or environment variables:

- `BASE_URL` – default `https://www.saucedemo.com`
- `BROWSER` –  `Firefox`
- `HEADLESS` – `true` 
- `TIMEOUT_S` – wait timeout in seconds (default `15`)

## Test user

Tests use **standard_user** (password: `secret_sauce`) for login and checkout.
