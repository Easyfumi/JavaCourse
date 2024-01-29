package ru.marinin.utils.utilsService;

public interface Applyable<T, P> {
    P apply(T t);
}
