package be.spidermind.ialtem.aspectj.exempleCours;

public class ExempleCours {
    /**
     * Dummiest example ever, trace calls to factorial method + try to access private method
     */


    public static int factorial(int n) {
        if (n == 2) {
            return 2;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        factorial(5);
        factorial(5);
        factorial(3);
        factorial(4);
        factorial(3);
    }
}
