package org.example.cards.presenter;

import org.example.cards.model.Card;

import java.util.List;

public interface CardListPresenter {

    void showCards(List<Card> cards, String message);
}
