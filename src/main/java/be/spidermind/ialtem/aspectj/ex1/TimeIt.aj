package be.spidermind.ialtem.aspectj.ex1;

public aspect TimeIt {

    pointcut timeItExec() : execution (public * MyAwesomeClass.*(..));
    pointcut timeItCall() : call (public * MyAwesomeClass.*(..));

    Object around() : timeItExec() {
        System.out.println("------> Before execution of "+ thisJoinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        Object retVal = proceed();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("####### Time taken by method execution "+ thisJoinPoint.getSignature() + " " + time + "ms");
        System.out.println("------> After executon of "+ thisJoinPoint.getSignature());

        return retVal;
    }

    Object around() : timeItCall() {
        System.out.println("\n\n\n########################################################");
        System.out.println("----> Before call of "+ thisJoinPoint.getSignature()+"\n");
        long startTime = System.currentTimeMillis();
        Object retVal = proceed();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("\n##### Time taken by method call "+ thisJoinPoint.getSignature() + " " + time + "ms");
        System.out.println("----> After call of "+ thisJoinPoint.getSignature());
        System.out.println("########################################################");

        return retVal;
    }
}
