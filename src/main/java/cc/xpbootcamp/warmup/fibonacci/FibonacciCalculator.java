package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
    public long getFibonacciByPosition(int position) {
        if (position <= 0 || position > 50)
            throw new IllegalArgumentException();
        if (position == 1 || position == 2)
            return 1;
        return getFibonacciByPosition(position - 1) + getFibonacciByPosition(position - 2);
    }
}
