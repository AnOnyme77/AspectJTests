package be.spidermind.ialtem.aspectj.ex8;

import java.util.LinkedHashMap;
import java.util.Map;

public aspect DbLinkAspect {

    private Map<Integer, Map<String, Object>> fakeDb = new LinkedHashMap<>();

    Object around(Object value) : set(!static public * Ex8.*) && args(value) {
        System.out.println(thisJoinPoint + " value "+value);

        Ex8 target = (Ex8)thisJoinPoint.getTarget();
        String attributeName = thisJoinPoint.getSignature().getName();

        if (!fakeDb.containsKey(target.id())) {
            fakeDb.put(target.id(), new LinkedHashMap<>());
        }

        fakeDb.get(target.id()).put(attributeName, value);

        return value;
    }

    Object around() : get(!static public * Ex8.*) {
        System.out.println(thisJoinPoint);
        Ex8 target = (Ex8) thisJoinPoint.getTarget();
        String attributeName = thisJoinPoint.getSignature().getName();

        return fakeDb.get(target.id()).get(attributeName);
    }

    after() : execution(* Ex8.main(..)) {
        System.out.println(fakeDb);
    }
}
