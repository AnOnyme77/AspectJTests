package be.spidermind.ialtem.aspectj.ex9;

public aspect CheckCaller {

    before() : call(* be.spidermind.ialtem.aspectj..repository.*.*(..)) {
        String callerPackage = thisJoinPoint.getSourceLocation().getWithinType().getPackage().getName();

        if(!callerPackage.endsWith("business") || !callerPackage.endsWith("repository")) {
            throw new RuntimeException("Boooouh pas bien");
        }
    }
}
