package be.spidermind.ialtem.aspectj.ex6;

public aspect AccessingAspect {

    before() : get(int Ex6.nb) && !withincode(* Ex6.getNb()){
        System.out.println("Get on nb :'( : " + thisJoinPoint);
    }

    before() : set(int Ex6.nb) && !withincode(* Ex6.setNb(..)) && !initialization(Ex6.new()) {
        System.out.println("Set on nb :'( " + thisJoinPoint);
    }
}
