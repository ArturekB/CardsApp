package org.example.cards.config;

import org.example.cards.CardsApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class ConfigurationProvider {

    private static final Logger LOG = LoggerFactory.getLogger("org.example.config.PropertiesReader");
    private static final String SHUFFLE = "cardsapp.shuffle";
    private static final String PLAYERS_COUNT = "cardsapp.players.count";
    private static final String DRAW_CARDS_COUNT = "cardsapp.draw.cards.count";

    public CardsAppProperties provideAppProperties() {
        Properties parsedProperties = readConfigurationProperties();
        CardsAppProperties result = convertToPlayerAppProperties(parsedProperties);
        validatePlayerAndCardCounts(result.getPlayersCount(), result.getDrawCardsCount());
        return result;
    }

    private Properties readConfigurationProperties() {
        Properties prop = new Properties();
        try (InputStream input = CardsApp.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                prop.load(input);
            } else {
                LOG.error("Sorry, unable to find application.properties, using defaults");
            }
        } catch (IOException ex) {
            LOG.error("Sorry, file application.properties unreadable, using defaults");
        }
        if (!prop.isEmpty()) {
            LOG.info("Properties file read successfully");
        }
        return prop;
    }

    private CardsAppProperties convertToPlayerAppProperties(Properties parsedProperties) {
        boolean shuffle = Boolean.parseBoolean(parsedProperties.getProperty(SHUFFLE, "true"));
        int playersCount = Integer.parseInt(parsedProperties.getProperty(PLAYERS_COUNT, "4"));
        int drawCardsCount = Integer.parseInt(parsedProperties.getProperty(DRAW_CARDS_COUNT, "6"));
        return new CardsAppProperties(shuffle, playersCount, drawCardsCount);
    }

    private void validatePlayerAndCardCounts(int playersCount, int drawCardsCount) {
        if (playersCount < 0)
            logAndThrowConfigException(format("Players count can not be negative but set to %d", playersCount));
        if (drawCardsCount < 0)
            logAndThrowConfigException(format("Draw cards count can not be negative but set to %d", drawCardsCount));
        if (playersCount * drawCardsCount > 52)
            logAndThrowConfigException(format("Deck has 52 cards can not deal %d * %d = %d cards",
                    playersCount, drawCardsCount, playersCount * drawCardsCount));
    }

    private void logAndThrowConfigException(String message) {
        LOG.error(message);
        throw new ConfigException(message);
    }
}
