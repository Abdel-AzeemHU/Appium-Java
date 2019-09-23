package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationScreen extends PageMaster {
    public UserRegistrationScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id="io.selendroid.testapp:id/inputUsername")
    AndroidElement txtUserName;

    @AndroidFindBy(id="io.selendroid.testapp:id/inputEmail")
    AndroidElement txtEmail;

    @AndroidFindBy(id="io.selendroid.testapp:id/inputPassword")
    AndroidElement txtPassword;

    @AndroidFindBy(id="io.selendroid.testapp:id/inputName")
    AndroidElement txtName;

    @AndroidFindBy(id="io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    AndroidElement listProgrammingLang;

    public void selectLanguage(String lang) {
        clickButton(listProgrammingLang);
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.CheckedTextView\")" +
                ".text(\"" + lang+ "\")").click();
    }

}

