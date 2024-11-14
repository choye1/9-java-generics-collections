package com.example.task01;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    private Pair (T1 t1, T2 t2) {
        first = t1;
        second = t2;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }


    public int hashCode() {
        return Objects.hash(first,second);
    }

    public void ifPresent(BiConsumer<? super T1, ? super T2> consumer ) {
        if(first != null && second != null) {
            consumer.accept(first, second);
        }
    }

    public static <T1,T2>Pair<T1,T2> of(T1 t1, T2 t2) {
        return new Pair(t1, t2);
    }
}

