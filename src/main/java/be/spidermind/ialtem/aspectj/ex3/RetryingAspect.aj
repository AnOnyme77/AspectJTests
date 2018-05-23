package be.spidermind.ialtem.aspectj.ex3;

public aspect RetryingAspect {

    pointcut errorHandler() : execution(* Ex3.*(..) throws Exception+);

    Object around() : errorHandler() {
        boolean mustRun = true;
        Object result = null;

        while(mustRun) {
            try {
                result = proceed();
                mustRun = false;
            } catch (Exception e) {
                System.out.println("Retrying because : "+ e.getMessage());
            }
        }
        return result;
    }
}
