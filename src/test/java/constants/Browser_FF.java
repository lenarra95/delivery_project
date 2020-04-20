package constants;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser_FF {
    public WebDriver driver;

    @Before
    public void setUp() {
        String path = "/Users/lenar-mac/Documents/geckodriver"; // указываем путь до драйвера
        String name = "webdriver.gecko.driver"; // указываем уникальное имя файла
        System.setProperty(name, path);

        FirefoxProfile testprofile = new FirefoxProfile();
        testprofile.setPreference("dom.webnotifications.enabled", false);
        testprofile.setPreference("dom.push.enabled", false); // устанавливаем настройки для оповещений
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, testprofile);
        FirefoxOptions opt = new FirefoxOptions(dc); // применяем настройки для браузера
        driver = new FirefoxDriver(opt);

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
