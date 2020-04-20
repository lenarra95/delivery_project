package constants;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

public class Browser_Safari {
    public WebDriver driver;

    @Before
    public void setUp() {
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "Nexus 5");

        SafariOptions options = new SafariOptions();

//        options.setCapability("mobileEmulation", mobileEmulation);

        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
