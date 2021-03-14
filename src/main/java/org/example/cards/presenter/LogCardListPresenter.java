package org.example.cards.presenter;

import org.example.cards.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LogCardListPresenter implements CardListPresenter {

    private static final Logger LOG = LoggerFactory.getLogger("org.example.presenter.LogCardListPresenter");
    @Override
    public void showCards(List<Card> cards, String message) {
        LOG.info(message+cards.toString());
    }

}
