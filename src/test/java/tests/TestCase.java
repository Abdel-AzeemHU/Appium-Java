package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCase {

    protected AndroidDriver driver;
    public static String userName = "testuser1114";
    public static String accessKey = "xBHYQ1ssVGrkK2w66ZYC";

    @BeforeSuite
    public void startDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        //capabilities.setCapability(MobileCapabilityType.APP, "/path/to/.apk/file");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        capabilities.setCapability("appPackage","io.selendroid.testapp");
        capabilities.setCapability("appActivity",".HomeScreenActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);*/
        capabilities.setCapability("device", "Samsung Galaxy Note 8");
        capabilities.setCapability("os_version", "7.1");
        capabilities.setCapability("name", "TestApp");
        capabilities.setCapability("app", "bs://b0d911da703aede113c340d8438ce891d3288c17");
        capabilities.setCapability("browserstack.debug", true);
        driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
