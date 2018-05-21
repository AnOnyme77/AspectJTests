package be.spidermind.ialtem.aspectj.dummy;

public aspect TestPrivate {
    pointcut NoSleep(): call( private static void Hello.sleepTen());

    void around() : NoSleep() {
        System.out.println("Skipping sleep !");
    }
}
