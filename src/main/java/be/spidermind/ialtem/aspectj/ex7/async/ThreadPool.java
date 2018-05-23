package be.spidermind.ialtem.aspectj.ex7.async;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

    private static final int NB_THREADS = 5;

    private List<RunnerThread> runners = new LinkedList<>();
    private List<Thread> threads = new LinkedList<>();
    private Queue<LongRunningClass> queue = new ConcurrentLinkedQueue<>();

    public ThreadPool() {
        launchThreads();
    }

    public void stopPool() {
        for (RunnerThread runner :
                runners) {
            runner.stop();
        }

        for (Thread th :
                threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeAsync(LongRunningClass objToRun) {
        queue.add(objToRun);
    }

    private void launchThreads() {
        for(int i=0; i < NB_THREADS; i++) {
            RunnerThread runner = new RunnerThread(queue);
            runners.add(runner);
            Thread th = new Thread(runner);
            th.start();
            threads.add(th);
        }
    }


}
