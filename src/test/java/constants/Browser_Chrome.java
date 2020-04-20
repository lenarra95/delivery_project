package constants;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Browser_Chrome{
    public WebDriver driver;

    @Before
    public void setUp() {
        String path = "/Users/lenar-mac/Documents/chromedriver"; // указываем путь до драйвера
        String name = "webdriver.chrome.driver"; // указываем уникальное имя файла
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "Nexus 5");
        System.setProperty(name, path);
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications"); // устанавливаем настройки для оповещений
//        options.setExperimentalOption("mobileEmulation", mobileEmulation); // эмуляция мобильного устройства


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
