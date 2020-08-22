package tdd.tdd;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void addTwoPlusTwoEqualsFour() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2 ,2);

        Assert.assertEquals(4, result);
    }

    @Test
    public void divideFiveByFiveEqualsOne() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(5, 5);

        Assert.assertEquals(1, result);
    }
}
