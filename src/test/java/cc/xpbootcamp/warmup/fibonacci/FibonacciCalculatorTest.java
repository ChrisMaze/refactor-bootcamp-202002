package cc.xpbootcamp.warmup.fibonacci;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciCalculatorTest {
    FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        assertEquals(1, fibonacciCalculator.getFibonacciByPosition(1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        assertEquals(1, fibonacciCalculator.getFibonacciByPosition(2));
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3() {
        assertEquals(2,fibonacciCalculator.getFibonacciByPosition(3));
    }
    
    @Test
    public void should_return_3_when_calculate_given_position_is_4() {
        assertEquals(3,fibonacciCalculator.getFibonacciByPosition(4));
    }
}
