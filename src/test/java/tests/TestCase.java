package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCase {

    protected AndroidDriver driver;

    @BeforeSuite
    public void startDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "OS version of your test device/simulator");
        capabilities.setCapability(MobileCapabilityType.APP, "/path/to/.apk/file");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Name of your test device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        AppiumDriver<MobileElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
