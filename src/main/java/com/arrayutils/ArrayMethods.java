package com.arrayutils;

import java.util.ArrayList;

public class ArrayMethods {
    public static <I> void forEach(I[] elements, Consumer<I> consumer) {
        for (I element : elements) {
            consumer.apply(element);
        }
    }

    public static <I, O> O[] map(I[] elements, Mapper<I, O> mapper) {
        final ArrayList<O> mapped = new ArrayList<>();
        for (I element : elements) {
            mapped.add(mapper.apply(element));
        }
        return (O[]) mapped.toArray();
    }

    public static <I> I[] filter(I[] elements, Predicate<I> predicate) {
        final ArrayList<I> filtered = new ArrayList<>();
        for (I element : elements) {
            if (predicate.match(element)) {
                filtered.add(element);
            }
        }
        return (I[]) filtered.toArray();
    }

    public static <I, O> O reduce(I[] elements, O context, Reducer<I, O> reducer) {
        for (I element : elements) {
            context = reducer.reduce(context, element);
        }
        return context;
    }
}
