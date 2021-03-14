package org.example.cards.model;

import java.util.Arrays;

public enum Suit {

    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    final int value;

    Suit(int value) {
        this.value = value;
    }

    static Suit havingValue(int value) {
        return Arrays.stream(Suit.values())
                .filter(suit -> suit.value == value)
                .findFirst()
                .orElseThrow(() -> new CardException(String.format("No card suit with given value %d.", value)));
    }
}
