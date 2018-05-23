package be.spidermind.ialtem.aspectj.ex4;

public aspect RecusivityAspect {

    /**
     * cflowbelow(execution(* C.m(int))) //Select all lines executing in the method called
     *   && !within(RecusivityAspect) // But not the advice itself
     *   && execution(* C.m(int)) //In the selected code, just keep calls to the method itself
     *   && args(param); // And get the param
     */
    pointcut recur(int param) : cflowbelow(execution(* C.m(int)))
                                    && !within(RecusivityAspect)
                                    && execution(* C.m(int))
                                    && args(param);

    before(int param) : recur(param) {
        throw new RuntimeException("Recursive call with parameter " + param);
    }
}
