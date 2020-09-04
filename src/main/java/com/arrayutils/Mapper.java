package com.arrayutils;

public interface Mapper<T, U> {
    U apply(T element);
}
