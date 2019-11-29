package com.example.game;

public class Pair<F, S> {
    private final F first;
    private final S second;

    /**
     * Constructor for a Pair.
     *
     * @param first the first object in the Pair
     * @param second the second object in the pair
     */
    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    F getFirst(){
        return this.first;
    }

    S getSecond(){
        return this.second;
    }
}

