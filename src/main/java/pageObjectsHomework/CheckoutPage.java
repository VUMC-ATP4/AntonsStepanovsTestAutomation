package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {


    public WebDriver driver;
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");

    private By continueButton = By.id("continue");
    private By checkoutItem = By.className("inventory_item_name");
    private By checkoutItemQty = By.cssSelector("div[class=cart_quantity]");
    private By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameInputField(){
        return driver.findElement(firstNameInputField);
    }

    public WebElement getLastNameInputField(){
        return driver.findElement(lastNameInputField);
    }
    public WebElement getZipCodeInputField(){
        return driver.findElement(zipCodeInputField);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement getCheckoutItem(){
        return driver.findElement(checkoutItem);
    }

    public WebElement getCheckoutItemQty(){
        return driver.findElement(checkoutItemQty);
    }

    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

    public void checkoutData(String firstname, String lastname, String zipcode){
        getFirstNameInputField().sendKeys(firstname);
        getLastNameInputField().sendKeys(lastname);
        getZipCodeInputField().sendKeys(zipcode);
        getContinueButton().click();
    }

}
