package tdd.tdd;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void addTwoPlusTwoEqualsFour() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2 ,2);

        Assert.assertEquals("Blad: 4 nie rowna sie " + result,4, result);
    }

    @Test
    public void divideFiveByFiveEqualsOne() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(5, 5);

        Assert.assertEquals(1, result);
    }
}
