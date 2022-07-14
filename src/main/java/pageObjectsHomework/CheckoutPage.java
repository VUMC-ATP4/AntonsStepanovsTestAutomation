package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {


    public WebDriver driver;
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");

    private By errorMessage = By.cssSelector("h3[data-test=error]");

    private By continueButton = By.id("continue");


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
    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }


    public void checkoutData(String firstname, String lastname, String zipcode){
        getFirstNameInputField().sendKeys(firstname);
        getLastNameInputField().sendKeys(lastname);
        getZipCodeInputField().sendKeys(zipcode);
        getContinueButton().click();
    }

}
