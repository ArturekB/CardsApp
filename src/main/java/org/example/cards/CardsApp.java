package org.example.cards;

import org.example.cards.config.CardsAppProperties;
import org.example.cards.config.ConfigurationProvider;
import org.example.cards.presenter.DealPresenter;
import org.example.cards.presenter.LogCardListPresenter;

public class CardsApp {

    public static void main(String[] args) {
        CardsAppProperties configProperties = new ConfigurationProvider().provideAppProperties();
        new DealPresenter(configProperties, new LogCardListPresenter()).showDeal();
        System.exit(0);
    }
}
