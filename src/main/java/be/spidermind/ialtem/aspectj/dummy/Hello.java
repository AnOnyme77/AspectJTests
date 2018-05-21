package be.spidermind.ialtem.aspectj.dummy;

public class Hello {
    /**
     * Dummiest example ever, trace calls to factorial method + try to access private method
     */

    private static void sleepTen() {
        /**
         * Simple method to check if a aspect can interact with private method
         */

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int factorial(int n) {
        sleepTen();
        if (n == 2) {
            return 2;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        factorial(5);
    }
}
