package mavenTestNGHomework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    WebDriver chromeBrowseris;

    @BeforeSuite
    public void pirmsTestaInfo() {
        System.out.println("Tiks pārbaudītas mājas lapu Title");
    }

    @BeforeTest
    public void pirmsTestaPageOpen() {
        chromeBrowseris = new ChromeDriver();
    }

    @AfterTest
    public void pecTestaPageClose() {
        chromeBrowseris.quit();
    }

    @BeforeMethod
    public void pirmsTestaTeksts() {
        System.out.println("Sākas tests");
    }

    @AfterClass
    public void pecTesta() {
        System.out.println("Visi testi pabeigti!");
    }

    @Test
    public void CheckPageTitle1(){
        String url = "https://latvija.lv/";
        chromeBrowseris.get(url);
        String expectedTitle = "Latvijas valsts portāls";
        String actualTitle = chromeBrowseris.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @Test
    public void CheckPageTitle2(){
        String url = "https://www.google.com/";
        chromeBrowseris.get(url);
        String expectedTitle = "Google";
        String actualTitle = chromeBrowseris.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
