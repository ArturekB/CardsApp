package org.example.cards.model;

import java.util.List;

public interface Deck {

    // shuffles the deck
    void shuffle();

    // draw a number of cards from the deck.  The end result is that the
    // cards returned are removed from the deck.
    List<Card> draw(int howMany);


    // returns all available cards form the deck.  The end result is that the
    // cards returned are removed from the deck.
    List<Card> drawAllAvailable();
}
