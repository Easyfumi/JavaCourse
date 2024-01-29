package ru.marinin.DataStream;

import java.util.function.Predicate;

public class FilterInteger implements Predicate<String> {
    @Override
    public boolean test(String o) {
        try {
            Integer.parseInt(o);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
