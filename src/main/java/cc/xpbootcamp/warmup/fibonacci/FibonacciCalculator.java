package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
    public int getFibonacciByPosition(int position) {
        if (position == 1 || position == 2)
            return 1;

        return getFibonacciByPosition(position-1) + getFibonacciByPosition(position-2);
    }
}
