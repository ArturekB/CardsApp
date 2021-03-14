package org.example.cards.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicDeck implements Deck {
    
    private final Stack<Card> cards;

    public BasicDeck() {
        this.cards = initializeDeck();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public List<Card> draw(int howMany){
        if (howMany>cards.size())
            throw new DeckException(String.format("Deck contains only %d cards, can not draw %d.", cards.size(),howMany));
        List<Card> result = new LinkedList<>();
        for (int i = 0; i < howMany ; i++) {
            result.add(cards.pop());
        }
        return result;
    }

    public List<Card> drawAllAvailable(){
        return this.draw(cards.size());
    }

    private Stack<Card> initializeDeck() {
        return IntStream.range(0,52)
                .mapToObj(Card::new)
                .collect(Collectors.toCollection(Stack::new));
    }
}
