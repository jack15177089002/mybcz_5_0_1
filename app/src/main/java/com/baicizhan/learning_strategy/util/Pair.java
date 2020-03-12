package com.baicizhan.learning_strategy.util;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair() {
    }

    public Pair(F f, S s) {
        setFirst(f);
        setSecond(s);
    }

    public String toString() {
        return String.format("p<%s,%s>", new Object[]{this.first, this.second});
    }

    public F getFirst() {
        return this.first;
    }

    public void setFirst(F f) {
        this.first = f;
    }

    public S getSecond() {
        return this.second;
    }

    public void setSecond(S s) {
        this.second = s;
    }
}
