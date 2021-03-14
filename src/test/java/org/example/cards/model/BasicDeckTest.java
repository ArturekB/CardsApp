package org.example.cards.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BasicDeckTest {

    Deck deck;

    @BeforeEach
    void prepareNewDeck(){
        deck = new BasicDeck();
    }

    @Test
    void shouldDrawGivenNumberOfCards(){
        //when
        List<Card> hand = deck.draw(5);
        //then
        assertEquals(hand.size(),5);
    }

    @Test
    void shouldDrawAllCards(){
        //when
        List<Card> hand = deck.drawAllAvailable();
        //then
        assertEquals(hand.size(),52);
    }

    @Test
    void shouldDrawRemainingCards(){
        //given
        List<Card> hand = deck.draw(10);
        //when
        List<Card> stack = deck.drawAllAvailable();
        //then
        assertEquals(hand.size(),10);
        assertEquals(stack.size(),42);
    }

    @Test
    void shouldThrowIfDeckIsDepleted(){
        //given
        deck.draw(50);
        //then
        assertThrows(DeckException.class,
                () -> deck.draw(5),
                "Deck contains only 2 cards, can not draw 5.");
    }

    @Test
    void shouldDrawUniqueCards(){
        //given
        deck.shuffle();
        //when
        List<Card> hand1 = deck.draw(20);
        List<Card> hand2 = deck.drawAllAvailable();
        //then
        assertTrue(hand1.stream().noneMatch(hand2::contains));
        assertEquals(hand1.size(), Set.copyOf(hand1).size());
        assertEquals(hand2.size(), Set.copyOf(hand2).size());
    }
}