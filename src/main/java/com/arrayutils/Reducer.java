package com.arrayutils;

public interface Reducer<T, U> {
    U reduce(U context, T element);
}
