package be.spidermind.ialtem.aspectj.ex5;

import java.util.stream.IntStream;

public class Ex5 {
    public void myAwesomeMethod(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        Ex5 runner = new Ex5();

        IntStream.range(0, 1000).parallel().forEach(runner::myAwesomeMethod);
    }


}
