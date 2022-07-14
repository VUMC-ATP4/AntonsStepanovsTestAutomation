package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    public WebDriver driver;

    private By pageTitle = By.cssSelector("div[id='header_container'] span[class='title']");

    private By backHomeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }

    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }


}
