package be.spidermind.ialtem.aspectj.ex7.async;

import java.util.Queue;

class RunnerThread implements Runnable {

    private volatile boolean mustRun = true;
    private Queue<LongRunningClass> waitingPool;

    public RunnerThread(Queue<LongRunningClass> waitingQueue) {
        waitingPool = waitingQueue;
    }

    public void stop() {
        mustRun = false;
    }

    @Override
    public void run() {
        while (mustRun) {
            LongRunningClass objToRun = waitingPool.poll();
            if (objToRun != null) {
                objToRun.longRunningMethod();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
