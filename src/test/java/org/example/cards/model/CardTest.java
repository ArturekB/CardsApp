package org.example.cards.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardTest {

    @ParameterizedTest
    @MethodSource
    void shouldCreateCardsForValuesInRange(int value, Rank rank, Suit suit) {
        //when
        Card card = new Card(value);
        //then
        assertEquals(card.showPower(), value);
        assertEquals(card.getSuit(), suit);
        assertEquals(card.getRank(), rank);
    }

    private static Stream<Arguments> shouldCreateCardsForValuesInRange() {
        return Stream.of(
                Arguments.of(0, Rank.TWO, Suit.CLUBS),
                Arguments.of(17, Rank.SIX, Suit.DIAMONDS),
                Arguments.of(51, Rank.ACE, Suit.SPADES)
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldNotCreateCardsForValuesNotInRange(int value, String message) {
        assertThrows(CardException.class, () -> new Card(value), message);
    }

    private static Stream<Arguments> shouldNotCreateCardsForValuesNotInRange() {
        return Stream.of(
                Arguments.of(52, "No card suit with given value 4."),
                Arguments.of(-1, "No card rank with given value -1."));
    }
}