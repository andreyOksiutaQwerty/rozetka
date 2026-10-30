package ua.com.rozetka.extension;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SelenideExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://rozetka.com.ua";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.pollingInterval = 500;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        closeWebDriver();
    }
}
