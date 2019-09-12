package utilities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PropertyUtilsTest {

    @BeforeAll
    public void setupClass() {

    }

    @Test
    void getProperty() {
        String os = PropertyUtils.getProperty("OS");
        System.out.println("OS: " + os);
        assertEquals("WINDOWS",os);
    }

    @Test
    void getIntegerProperty() {
    }

    @Test
    void getPropertyFromOtherFile() {
        PropertyUtils.loadPropertiesFromFile("browser.properties");
        String browser = PropertyUtils.getProperty("BROWSER");
        System.out.println("Browser: " + browser);
        assertEquals("Chrome",browser);
    }

    @Test
    void loadPropertiesFromFile() {
    }

    @Test
    void getProps() {
    }
}