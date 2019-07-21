package pages;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMaster {
    protected AndroidDriver driver;
    protected TouchAction touchAction;
    protected MultiTouchAction multiTouchAction;

    public PageMaster(AndroidDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        multiTouchAction = new MultiTouchAction(driver);
        PageFactory.initElements(driver,this);
    }

    protected void waitElement(By selector) {
        Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void clickButton(AndroidElement button) {
        button.click();
    }

    protected void setTextElementText(AndroidElement textElement, String value) {
        textElement.clear();
        textElement.sendKeys(value);
    }

}
