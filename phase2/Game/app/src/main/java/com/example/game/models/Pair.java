package com.example.game.models;

/**
 * Used to imitate the basic functionality of a Python tuple. Just setting and getting two items.
 * @param <F> Type of first item
 * @param <S> Type of second item
 */
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

