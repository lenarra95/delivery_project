package actions;

import constants.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Actions {

    public static void elementIsVisible(By element, WebDriver driver, int time)
    {
        WebDriverWait Time = new WebDriverWait(driver, time);
        Time.until(ExpectedConditions.visibilityOfElementLocated(element)); // проверка на видимость элемента
    }
    public static void elementIsVisible(By element, WebDriver driver)
    {
        elementIsVisible(element, driver, Variables.longTime);
    }

    public static boolean elementIsInDOM(By element, WebDriver driver) {

        try {
            elementIsVisible(element, driver, Variables.longTime);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void click(By element, WebDriver driver, int time) //БЕСПОЛЕЗНО
    {
        WebDriverWait Time = new WebDriverWait(driver, time);
        Time.until(ExpectedConditions.elementToBeClickable(element)).click(); // проверка на клик-сть элемента
    }
    public static void click(By element, WebDriver driver)
    {
        click(element, driver, Variables.longTime);
    }

    public static void setText(By element, String value, WebDriver driver, int time)
    {
        WebDriverWait Time = new WebDriverWait(driver, time);
        Time.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element)); // проверка на видимость элемента
        driver.findElement(element).click();
        driver.findElement(element).sendKeys(value);
    }
    public static void setText(By element, String value, WebDriver driver)
    {
        setText(element, value, driver, Variables.longTime);
    }

    public static int randomNumber(int min, int max)
    {
        // диапазон будет [min; --max]
        Random rnd = new Random();
        //.nextInt() от 0 до --max
        int number = rnd.nextInt(++max) + min; //max будет входит в диапазон, так как значения max = ++max
        return number;
    }
}
