package cc.xpbootcamp.warmup.fibonacci;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciCalculatorTest {
    FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        int fibonacciNumber = fibonacciCalculator.getFibonacciByPosition(1);
        Assertions.assertEquals(1,fibonacciNumber);
    }
}
