package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.CartPage;
import pageObjectsHomework.CheckoutPage;
import pageObjectsHomework.InventoryPage;
import pageObjectsHomework.LoginPage;

import java.time.Duration;

public class sauceDemoTests {

    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser() {
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa");
        driver.quit();
    }

    @Test
    public void LoginTest() throws InterruptedException {
        System.out.println("Login TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");

    }

    @Test
    public void CartItemTest() throws InterruptedException {
        System.out.println("Cart TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getAddToCartBackpack().click();
        inventoryPage.getGoToCart().click();
        //Thread.sleep(5000);
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemInCart().getText(), "Sauce Labs Backpack");
    }


    @Test
    public void OrderCheckoutTest() throws InterruptedException {
        System.out.println("Checkout overview TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getAddToCartBackpack().click();
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "Stepanovs", "LV-1019");

        Assert.assertEquals(checkoutPage.getCheckoutItem().getText(),"Sauce Labs Backpack");
        Assert.assertEquals(checkoutPage.getCheckoutItemQty().getText(),"1");

        //Thread.sleep(5000);

    }

    @Test
    public void SuccessfulOrderTest() throws InterruptedException {
        System.out.println("Successful order TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getAddToCartBackpack().click();
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "Stepanovs", "LV-1019");
        checkoutPage.getFinishButton().click();
        Thread.sleep(5000);

        //Assert.assertEquals(checkoutPage.getCheckoutItem().getText(),"Sauce Labs Backpack");
        //Assert.assertEquals(checkoutPage.getCheckoutItemQty().getText(),"1");

        //Thread.sleep(5000);

    }

}
