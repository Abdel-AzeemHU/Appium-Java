package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends PageMaster{

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id="io.selendroid.testapp:id/startUserRegistration")
    AndroidElement buttonUserRegistration;

    public UserRegistrationScreen openUserRegistration() {
        clickButton(buttonUserRegistration);
        return new UserRegistrationScreen(driver);
    }
}
