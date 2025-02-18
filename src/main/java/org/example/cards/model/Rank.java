package org.example.cards.model;

import java.util.Arrays;

public enum Rank {
    TWO(0),
    THREE(1),
    FOUR(2),
    FIVE(3),
    SIX(4),
    SEVEN(5),
    EIGHT(6),
    NINE(7),
    TEN(8),
    JACK(9),
    QUEEN(10),
    KING(11),
    ACE(12);

    final int value;

    Rank(int value) {
        this.value = value;
    }

    static Rank havingValue(int value) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.value == value)
                .findFirst()
                .orElseThrow(() -> new CardException(String.format("No card rank with given value %d.", value)));
    }
}
