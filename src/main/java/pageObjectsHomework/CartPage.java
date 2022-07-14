package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;

    private By itemInCart = By.className("inventory_item_name");
    private By cartPageCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemInCart(){
        return driver.findElement(itemInCart);
    }
    public WebElement getCartPageCheckout(){
        return driver.findElement(cartPageCheckout);
    }


}
