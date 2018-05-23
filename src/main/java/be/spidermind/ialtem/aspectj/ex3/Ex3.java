package be.spidermind.ialtem.aspectj.ex3;

import java.util.Random;

public class Ex3 {

    public int randomOddNumber() throws Exception {
        Random random = new Random();
        int number = random.nextInt();
        if (number % 10 < 6) {
            throw new Exception("Awfull error occurs");
        }
        return number;
    }

    public static void main(String[] args) {
        Ex3 runner = new Ex3();
        try {
            System.out.println(runner.randomOddNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
