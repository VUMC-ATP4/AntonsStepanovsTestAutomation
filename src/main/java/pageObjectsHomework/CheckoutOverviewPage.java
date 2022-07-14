package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    public WebDriver driver;

    private By checkoutItem = By.className("inventory_item_name");
    private By checkoutItemQty = By.cssSelector("div[class=cart_quantity]");
    private By finishButton = By.id("finish");

    public WebElement getCheckoutItem(){
        return driver.findElement(checkoutItem);
    }

    public WebElement getCheckoutItemQty(){
        return driver.findElement(checkoutItemQty);
    }

    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }


}
