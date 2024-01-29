package ru.marinin.DataStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class DataStream<T> {
    private List<T> list;
    private List actions=new ArrayList();

    private DataStream(List<T> list) {
        this.list = list;
    }

    public static<V> DataStream<V> create(List<V> obj) {
        return new DataStream<>(obj);
    }


    public <R> DataStream<R> map(Function<T, R> function) {
        actions.add(function);
        return (DataStream)this;
    }

    public DataStream<T> filter(Predicate<T> rule) {
        actions.add(rule);
        return this;
    }

    public<R> R collect(Supplier<R> init, BiConsumer<R, T> op) {
        R obj = init.get();
        up: for (T t:list) {
            for (Object action:actions) {
                try {
                    Function fun = (Function) action;
                    t = (T) fun.apply(t);
                } catch (ClassCastException e) {
                    Predicate rule= (Predicate) action;
                    if(!rule.test(t))
                        continue up;
                }
            }
            op.accept(obj,t);
        }
        return obj;
    }


    public T reduce(BinaryOperator<T> operator, T start) {
        T res = start;
        up: for (T t:list) {
            for (Object action:actions) {
                try {
                    Function fun = (Function) action;
                    t = (T) fun.apply(t);
                } catch (ClassCastException e) {
                    Predicate rule= (Predicate) action;
                    if(!rule.test(t))
                        continue up;
                }
            }
            res = operator.apply(res, t);
        }
        return res;
    }
}