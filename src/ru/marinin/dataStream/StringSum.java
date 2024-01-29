package ru.marinin.dataStream;

import java.util.function.BinaryOperator;

public class StringSum implements BinaryOperator<String> {
    @Override
    public String apply(String o, String o2) {
        return Integer.valueOf(o) + Integer.valueOf(o2) + "";
    }
}
