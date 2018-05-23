package be.spidermind.ialtem.aspectj.ex2;

import java.util.LinkedHashMap;
import java.util.Map;

public aspect Ex2A {
    pointcut timeMethods() : execution(* Ex2.*(..));//Prends le public privé et tous les types de retour
    pointcut mainMethod() : execution(private * Ex2.printPrimes(..));

    private Map<String, Long> methodNameExecutionTime = new LinkedHashMap<>();
    private Map<String, Long> methodSignatureExecutionTime = new LinkedHashMap<>();

    after() : mainMethod() {
        System.out.println("\n\nAccumulation by method name");
        System.out.println(methodNameExecutionTime);

        System.out.println("Accumulation by method signature");
        System.out.println(methodSignatureExecutionTime);

        System.out.println("\n\n");
    }

    Object around() : timeMethods() {
        Long startTime = System.currentTimeMillis();
        Object returnValue = proceed();
        Long endTime = System.currentTimeMillis();

        String methodName = thisJoinPoint.getSignature().getName();
        accMethodNameRuntime(methodName, endTime - startTime);
        accMethodSignatureRuntime(thisJoinPoint.getSignature().toString(), endTime - startTime);

        return returnValue;
    }

    private void accMethodNameRuntime(String methodName, Long runtime) {
        methodNameExecutionTime.put(
                methodName,
                methodNameExecutionTime.getOrDefault(methodName, 0L) + runtime
        );
    }

    private void accMethodSignatureRuntime(String methodName, Long runtime) {
        methodSignatureExecutionTime.put(
                methodName,
                methodNameExecutionTime.getOrDefault(methodName, 0L) + runtime
        );
    }
}
