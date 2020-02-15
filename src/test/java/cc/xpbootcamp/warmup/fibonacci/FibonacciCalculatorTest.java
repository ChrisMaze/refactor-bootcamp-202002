package cc.xpbootcamp.warmup.fibonacci;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(2, fibonacciCalculator.getFibonacciByPosition(3));
    }

    @Test
    public void should_return_3_when_calculate_given_position_is_4() {
        assertEquals(3, fibonacciCalculator.getFibonacciByPosition(4));
    }

    @Test
    public void should_return_5_when_calculate_given_position_is_5() {
        assertEquals(5, fibonacciCalculator.getFibonacciByPosition(5));
    }

    @Test
    public void should_return_12586269025L_when_calculate_given_position_is_50() {
        assertEquals(12586269025L, fibonacciCalculator.getFibonacciByPosition(50));
    }

    @Test
    public void should_throw_when_calculate_given_position_is_0() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciCalculator.getFibonacciByPosition(0);
        });
    }

    @Test
    public void should_throw_when_calculate_given_position_is_less_than_0() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciCalculator.getFibonacciByPosition(-1);
        });
    }
}
