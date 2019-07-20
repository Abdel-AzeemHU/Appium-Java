package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageMaster {
    protected AndroidDriver driver;
    protected Actions actions;

    public PageMaster(AndroidDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    protected WebElement getElement(By selector) {
        Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> {
            return driver.findElement(selector);
        });
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
