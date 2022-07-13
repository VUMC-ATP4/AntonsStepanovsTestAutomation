package classRoomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;

    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv/";

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {

        System.out.println("Pirms testa");

        InternetExplorerOptions browserOptions = new InternetExplorerOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "11");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<W10 IE11>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

//        InternetExplorerOptions browserOptions = new InternetExplorerOptions();
//        browserOptions.setCapability("platformName", "Windows 7");
//        browserOptions.setCapability("browserVersion", "10");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);

//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setCapability("platformName", "macOS 12");
//        browserOptions.setCapability("browserVersion", "15");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "<Antons build 123>");
//        sauceOptions.put("name", "Regression test run");
//        browserOptions.setCapability("sauce:options", sauceOptions);


        //uz servera saucedemo
        driver = new RemoteWebDriver(new URL("https://oauth-asempaj-9e406:8c1aa342-a785-4391-8404-04a5077cba4e@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);

        //uz datora servera
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), chromeOptions);
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchForItemTest()  {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("a");
        System.out.println("Search results count:" + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(),12);
        List<WebElement> searchResults = mainPage.getSearchResults();
//        for (WebElement element : searchResults) {
//            System.out.println(element.findElement(By.cssSelector("h2")).getText());
//        }
        for (int i = 0; i < mainPage.getSearchResults().size(); i++) {
            System.out.println(mainPage.getSearchResults().get(i).findElement(By.cssSelector("h2")).getText());
            System.out.println(mainPage.getSearchResults().get(i).findElement(By.className("price")).getText());
        }


    }

    @Test
    public void searchForItemTestTwo()  {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Hoodie");
        System.out.println("Search results count:" + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(),3);

    }

    @Test
    public void switchTabsTest(){
        driver.get("https://www.w3schools.com/");
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        System.out.println();

    }


    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        WebElement consentButton = driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']"));
        wait.until(ExpectedConditions.visibilityOf(consentButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", consentButton);
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();

        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        WebElement menu = driver.findElement(By.className("menuContainer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", menu);
        Thread.sleep(2000);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement hoverMeButton = driver.findElement(By.cssSelector("div.dropdown2 button"));
        new Actions(driver).moveToElement(hoverMeButton).perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Link 1")).click();
    }

    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();

        Thread.sleep(3000);

    }

    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .sendKeys("J")
                .sendKeys("U")
                .sendKeys("R")
                .sendKeys("I")
                .sendKeys("S")
                .perform();
        Thread.sleep(5000);
    }

    @Test
    public void remoteTest(){

    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pēc testa");
        driver.quit();
    }


}
