package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    public WebDriver driver;
    private By pageTitle = By.cssSelector("div[id='header_container'] span[class='title']");

    private  By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private  By goToCart = By.className("shopping_cart_link");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }

    public WebElement getAddToCartBackpack(){
        return driver.findElement(addToCartBackpack);
    }

    public WebElement getGoToCart(){
        return driver.findElement(goToCart);
    }

    public void addToCartAndGoToCart() {
        getAddToCartBackpack().click();
        getGoToCart().click();
    }

}
