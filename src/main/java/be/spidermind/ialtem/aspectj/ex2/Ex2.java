package be.spidermind.ialtem.aspectj.ex2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex2 {

    private List<Integer> primes;

    public Ex2(){
        primes = new LinkedList<>();
        primes.add(2);
    }

    public List<Integer> getXPrimes(int x) {
        if (primes.size() > x) {
            return Collections.unmodifiableList(primes.subList(0, x));
        }

        while(primes.size() < x) {
            int toTest = primes.get(primes.size() - 1) + 1;
            while(!isPrime(toTest)) {
                toTest += 1;
            }
            primes.add(toTest);
        }

        return Collections.unmodifiableList(primes.subList(0, x));
    }

    private boolean isPrime(int toTest) {
        int limitToCheck = (int)Math.sqrt(toTest);

        for(int i = 0; i < primes.size() && primes.get(i) <= limitToCheck; i++) {
            if (toTest % primes.get(i) == 0)
                return false;
        }

        return true;
    }

    private static void printPrimes(Ex2 ex2, int nb) {
        System.out.println(ex2.getXPrimes(nb));
    }

    public static void main(String[] args) {
        Ex2 obj = new Ex2();

        printPrimes(obj, 1000);
        printPrimes(obj, 100);
        printPrimes(obj, 10000);
        printPrimes(obj, 100000);
    }
}
