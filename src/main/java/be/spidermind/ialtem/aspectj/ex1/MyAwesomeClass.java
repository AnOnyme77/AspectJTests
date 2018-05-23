package be.spidermind.ialtem.aspectj.ex1;

import java.util.stream.IntStream;

/**
 * Give an example of time profiling of public methods
 *
 * Explain also the difference between call and execution :
 * Logs show that call is called (and from the caller) before execution for each method.
 * Execution is called in executor object.
 *
 * There may have problems with static methods and call.
 */

public class MyAwesomeClass {

    private int adder = 0;

    public MyAwesomeClass(int maxLimit) {
        assert maxLimit > 0 : "maxLimit should be positive";

        IntStream.range(0, maxLimit).filter(i -> i %2 == 0).forEach(j -> {
            adder += addOne(j);
            updateAdder();
            multByThree();
        });
    }

    public int getValue() {
        return adder;
    }

    public void multByThree() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adder *= 3;
    }

    private void updateAdder() {
        adder /= 2;
    }

    public static Integer addOne(int a) {
        return a + 1;
    }

    public static void main(String[] args) {
        MyAwesomeClass mAC = new MyAwesomeClass(100);
        System.out.println(mAC.getValue());
    }
}
