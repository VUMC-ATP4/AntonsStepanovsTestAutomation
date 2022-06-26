import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeTest
    public void pirmsTests() {
        System.out.println("Sakas tests");
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        int actualResult = calculator.sum(13, 25);
        int expectedResult = 38;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(5, 5), 25);
    }
}