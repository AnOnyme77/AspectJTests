package be.spidermind.ialtem.aspectj.ex5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public aspect SynchronizedAspect {

    /**
     * Synchronized keyword cannot be added by aspectj so we manage it manually
     */

    private Lock lock = new ReentrantLock();

    Object around() : execution(* Ex5.myAwesomeMethod(..)) {
        System.out.println("\n\nWaiting for lock");
        lock.lock();
        System.out.println("I have the lock");

        System.out.println("Running");
        Object r = proceed();

        System.out.println("Releasing the lock");
        lock.unlock();
        System.out.println("Lock released");

        return r;
    }
}
