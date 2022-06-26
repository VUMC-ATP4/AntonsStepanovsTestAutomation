package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTestNG {

    Calculator calculator;

    @BeforeSuite
    public void pirmsTestaInfo() {
        System.out.println("Tiks testēta klase Calculator");
    }


    @BeforeTest
    public void pirmsTestaObjekts() {
        calculator = new Calculator();
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
    public void testAdd() {
         Assert.assertEquals(calculator.add(13, 25), 38);
    }

    @Test
    public void testSubstract() {
        Assert.assertEquals(calculator.substract(10, 5), 5);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(5, 5), 25);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(calculator.divide(10, 5), 2);
    }

}
