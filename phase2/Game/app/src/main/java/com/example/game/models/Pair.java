package com.example.game.models;

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

    /**
     *
     * @return the first object in Pair
     */
    public F getFirst(){
        return this.first;
    }

    /**
     *
     * @return the second object in Pair
     */
    public S getSecond(){
        return this.second;
    }
}

