package be.spidermind.ialtem.aspectj.ex7;

import be.spidermind.ialtem.aspectj.ex7.async.LongRunningClass;
import be.spidermind.ialtem.aspectj.ex7.async.ThreadPool;

public aspect AutoAsynAspect {

    private ThreadPool pool = new ThreadPool();

    Object around() : call(* RandomMatrix.longRunningMethod()) && withincode(* Ex7.asyncMatrix()) {
        System.out.println("Running call async");

        LongRunningClass target = (LongRunningClass)thisJoinPoint.getTarget();
        pool.executeAsync(target);

        return null;
    }
}
