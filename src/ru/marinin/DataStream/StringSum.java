package ru.marinin.DataStream;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class StringSum implements BinaryOperator<String> {
    @Override
    public String apply(String o, String o2) {
        return Integer.valueOf(o) + Integer.valueOf(o2) + "";
    }
}
