# CardsApp
Simple demo project. Provides a standard 52 card deck of playing cards and creates a deal for given amount of players, 
and given number of cards on each hand. Then the following results are presented in the application logs
1. Hand for each player
2. All cards remaining in the deck

## Installation
1. Download repository.
2. Execute `mvn clean package` to create executable _CardsApp-1.0.jar_ file.

## Configuration
Application can be configured via `application.properties` and `logback.xml` files.

### application.properties
File contains three parameters with provided default values, which can be overridden by configuration.
If some of parameters are not provided defaults will be used.
1. cardsapp.shuffle - true if deck shuffle should be performed before dealing cards (default: true)
2. cardsapp.players - number of players/hands (default: 4)
3. cardsapp.draw.cards - number of cards in each hand (default: 6)

Given parameters are validated in the following way:
number of players, and number of cards can not be negative
and the total number of cards to deal is limited to 52. 

### logback.xml
File is used to configure output. Logging is set to console, so the results will be presented there. 

## Usage
Application can be launched directly from the IDE or by executing command `java -jar CardsApp-1.0.jar` 
in the directory containing the file.  

## Tests
Application contains simple unit testing for proper cards construction, deck initialization process 
and methods used to execute dealing cards. 
