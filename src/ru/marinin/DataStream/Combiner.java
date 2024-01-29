package ru.marinin.DataStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Combiner implements BiConsumer<List<List<Integer>>, Integer> {

    @Override
    public void accept(List<List<Integer>> o, Integer o2) {
        if (o.isEmpty()) {
            o.add(new ArrayList<>());
            o.add(new ArrayList<>());
        }
        if (o2>0) {
            o.get(0).add(o2);
        } else {
            o.get(1).add(o2);
        }
    }

}
