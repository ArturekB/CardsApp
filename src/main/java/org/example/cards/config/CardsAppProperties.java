package org.example.cards.config;

public class CardsAppProperties {

    private final boolean shuffle;
    private final int playersCount;
    private final int drawCardsCount;

    public CardsAppProperties(boolean shuffle, int playersCount, int drawCardsCount) {
        this.shuffle = shuffle;
        this.playersCount = playersCount;
        this.drawCardsCount = drawCardsCount;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public int getDrawCardsCount() {
        return drawCardsCount;
    }
}
