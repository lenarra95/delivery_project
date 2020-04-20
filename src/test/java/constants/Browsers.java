package constants;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Browsers {
    public static ChromeDriver Chrome() {
        String path = "/Users/lenar-mac/Documents/chromedriver"; // указываем путь до драйвера
        String name = "webdriver.chrome.driver"; // указываем уникальное имя файла
        System.setProperty(name, path);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // устанавливаем настройки для оповещений

        return new ChromeDriver(options);
    }
    public static FirefoxDriver FF() {
        String path = "/Users/lenar-mac/Documents/geckodriver"; // указываем путь до драйвера
        String name = "webdriver.gecko.driver"; // указываем уникальное имя файла
        System.setProperty(name, path);

        FirefoxProfile testprofile = new FirefoxProfile();
        testprofile.setPreference("dom.webnotifications.enabled", false);
        testprofile.setPreference("dom.push.enabled", false); // устанавливаем настройки для оповещений
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, testprofile);
        FirefoxOptions opt = new FirefoxOptions(dc); // применяем настройки для браузера

        return new FirefoxDriver(opt);
    }
    public static SafariDriver Safari() {
        return new SafariDriver();
    }

}
