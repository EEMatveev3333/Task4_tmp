package org.example;
import java.util.function.Predicate;
public class PredicateExample implements Predicate<Integer>{
    @Override
    public boolean test(Integer integer) {
        if (integer >= 2 && integer <= 5) return true; else return false;

    }
}
