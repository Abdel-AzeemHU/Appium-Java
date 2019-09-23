package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.UserRegistrationScreen;

public class UserRegistrationTest extends TestCase{

    HomeScreen homeScreen;
    UserRegistrationScreen userRegistrationScreen;

    @BeforeClass
    public void setup() {
        homeScreen = new HomeScreen(driver);
    }

    @Test
    public void userCanRegisterTest() {
        userRegistrationScreen = homeScreen.openUserRegistration();
        userRegistrationScreen.selectLanguage("PHP");
    }
}
