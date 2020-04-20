package tests;

import actions.Actions;
import constants.Browser_Chrome;
import constants.Variables;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyTests extends Browser_Chrome {
    @Test
    public void addSomethingToCart() throws InterruptedException {
        int numRestorant = Actions.randomNumber(1, 3);
        int numProduct = Actions.randomNumber(1, 3);
        String xpathToProduct = "//li[@class='menu-product'][" + numProduct + "]";
        String address = "Свердловская область, Екатеринбург, улица Крауля, 10, подъезд 5 ";
        String xpathToSugAddress = "//div[@class='address-suggest-item__title address-suggest-item__title--selected' and contains (text(), '" + address + "')]";
        String nameOfProduct;

        driver.get(Variables.baseUrl);
        Actions.elementIsVisible(By.cssSelector("a.webim-button-corner.webim_button"), driver);
        Actions.click(By.cssSelector("div.address-input.is-empty"), driver);
        Actions.setText(By.cssSelector("input.address-suggest__search-input"), address, driver);
        Thread.sleep(1000); //в будущем буду использовать selenide
        Actions.click(By.xpath(xpathToSugAddress), driver);
        Thread.sleep(1000); //в будущем буду использовать selenide
        String selectedAddress = driver.findElement(By.className("address-input__wrap")).getAttribute("innerHTML");
        selectedAddress.trim().equals(address.trim());
        Actions.click(By.xpath("//li[@class='vendor-item'][" + numRestorant + "]"), driver);
        Actions.click(By.xpath(xpathToProduct), driver);
        if (Actions.elementIsInDOM(By.cssSelector("div.popup__body.popup__body--wide"), driver)){
            nameOfProduct = driver.findElement(By.className("product-popup__name")).getAttribute("innerHTML");
            Actions.click(By.cssSelector("button.green-btn--md.product-popup__add"), driver);
        } else
            nameOfProduct = driver.findElement(By.xpath(xpathToProduct + "//div[@class='menu-product__title']")).getAttribute("innerHTML");
        Actions.elementIsVisible(By.className("basket-product__name"), driver);
        String productInFrame = driver.findElement(By.xpath("//ul[@class='basket__list']//div[@class='basket-product__name']")).getAttribute("innerHTML");
        productInFrame.trim().equals(nameOfProduct.trim());
    }
}