package org.example.cards.model;

public class Card {

    private final Rank rank;
    private final Suit suit;

    Card(int value) {
        this.rank = Rank.havingValue(value % 13);
        this.suit = Suit.havingValue(value / 13);
    }

    int showPower() {
        return rank.value + suit.value * 13;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.toString()+ " of "+ suit.toString();
    }
}
