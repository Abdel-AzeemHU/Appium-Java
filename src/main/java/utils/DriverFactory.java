package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class DriverFactory {
    private static AppiumDriver driver = null;

    public static AppiumDriver getDriver() {
        String browser = PropertyReader.getProperty("browser");

        //AppiumDriver(java.net.URL remoteAddress, org.openqa.selenium.Capabilities desiredCapabilities)
        if (driver == null) {
            driver = new AppiumDriver();
        }
        driver.manage().timeouts().implicitlyWait(
                Long.parseLong(PropertyReader.getProperty("default-wait")), SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        driver.manage().timeouts().setScriptTimeout(100,SECONDS);
        return driver;
    }

    public static void stopDriver() {
        driver.quit();
        driver = null;
    }

    private static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension",false);
        return options;
    }

    private static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        //option.addPreference("browser.download.folderList", 2);
        //option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        //option.addPreference("browser.download.manager.showWhenStarting", false);
        //option.addPreference("pdfjs.disabled", true);
        return option;
    }
}
