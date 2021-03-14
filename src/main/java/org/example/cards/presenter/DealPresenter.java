package org.example.cards.presenter;

import org.example.cards.config.CardsAppProperties;
import org.example.cards.model.BasicDeck;
import org.example.cards.model.Card;
import org.example.cards.model.Deck;

import java.util.List;

public class DealPresenter {

    private final boolean shuffle;
    private final int playersCount;
    private final int drawCardsCount;
    private final CardListPresenter presenter;

    public DealPresenter(CardsAppProperties configProperties, CardListPresenter presenter) {
        shuffle = configProperties.isShuffle();
        playersCount = configProperties.getPlayersCount();
        drawCardsCount = configProperties.getDrawCardsCount();
        this.presenter = presenter;
    }

    public void showDeal() {
        Deck deck = new BasicDeck();
        if (shuffle)
            deck.shuffle();
        for (int i = 1; i <=playersCount ; i++) {
            List<Card> hand = deck.draw(drawCardsCount);
            presenter.showCards(hand, String.format("Player %d cards: ", i));
        }
        List<Card> remains = deck.drawAllAvailable();
        presenter.showCards(remains, "Remained in deck: ");
    }
}
