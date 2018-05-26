package be.spidermind.ialtem.aspectj.exempleCours;

import java.util.LinkedHashMap;
import java.util.Map;

public aspect CachingAspect {

    private Map<Integer, Integer> cache = new LinkedHashMap<>();

    int around(int argument) : execution(* ExempleCours.factorial(int))
                        && !cflowbelow(execution(* ExempleCours.factorial(..))) && args(argument) {
        if(cache.containsKey(argument)) {
            return cache.get(argument);
        } else {
            int result = proceed(argument);
            cache.put(argument, result);
            System.out.println(cache);
            return result;
        }
    }
}
