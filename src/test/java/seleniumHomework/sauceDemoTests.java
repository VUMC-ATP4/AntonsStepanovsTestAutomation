package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

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
        inventoryPage.addToCartAndGoToCart();

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
        inventoryPage.addToCartAndGoToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "Stepanovs", "LV-1019");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Assert.assertEquals(checkoutOverviewPage.getCheckoutItem().getText(),"Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemQty().getText(),"1");

    }

    @Test
    public void SuccessfulOrderTest() throws InterruptedException {
        System.out.println("Successful order TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCartAndGoToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "Stepanovs", "LV-1019");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(),"CHECKOUT: COMPLETE!");

        checkoutSuccessPage.getBackHomeButton().click();


        Thread.sleep(1000);

    }

    @Test
    public void errorMessageDataEmptyTest() throws InterruptedException {
        System.out.println("Firstname Empty TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("", "", "");
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");


        Thread.sleep(5000);

    }

    @Test
    public void errorMessageFirstNameEmptyTest() throws InterruptedException {
        System.out.println("Firstname Empty TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("", "Stepanovs", "LV-1019");
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");


        Thread.sleep(5000);

    }

    @Test
    public void errorMessageLastNameEmptyTest() throws InterruptedException {
        System.out.println("Firstname Empty TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "", "LV-1019");
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");


        Thread.sleep(5000);

    }

    @Test
    public void errorMessageZipCodeEmptyTest() throws InterruptedException {
        System.out.println("Firstname Empty TESTS");
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getGoToCart().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartPageCheckout().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutData("Antons", "Stepanovs", "");
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");


        Thread.sleep(5000);

    }

}
