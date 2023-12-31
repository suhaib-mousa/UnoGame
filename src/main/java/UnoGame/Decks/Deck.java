package UnoGame.Decks;

import UnoGame.Cards.*;
import UnoGame.Cards.Enums.*;

import java.util.*;

public class Deck {
    public List<CardBase> unoDeck;
    // 4 blanks cards to add a customized cards
    private static final List<CardBase> Blanks = new ArrayList<>(); // Initializes the Blanks list with 4 null elements
    private CardBase lastDraw;
    private static Deck instance;
    private Deck() {
        unoDeck = new ArrayList<>();
        Initialize();
    }

    public static Deck getInstance() { // Singleton pattern for the deck
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }
    public static Deck getInstance(List<CardBase> blanks) throws AllBlanksUsedException{
        if (Blanks.stream().filter(Objects::nonNull).count() >= 4) {
            throw new AllBlanksUsedException("All blank cards are already used.");
        } else {
            List<CardBase> nonNullBlanks = blanks.stream().filter(Objects::nonNull).toList();
            Blanks.addAll(nonNullBlanks);
        }
        return getInstance();
    }
    private void Initialize() {
        // Check if Blanks has more than 0 elements and less than 4 (non-null elements)
        if (Blanks.stream().anyMatch(Objects::nonNull)) {
            unoDeck.addAll(Blanks); // Add the non-null elements from Blanks to unoDeck
        }
        // Adding numbered cards
        for (CardColor color : CardColor.values()) {
            // TO avoid adding non colored numbers
            if (color == CardColor.NO_COLOR || color == CardColor.WILD) {
                continue;
            }
            for (int value = 0; value <= 9; value++) {
                var card = new Card();
                if (value != 0) {
                    unoDeck.add(card.setNumberedCard(color, value));
                    unoDeck.add(card.setNumberedCard(color, value));
                } else {
                    unoDeck.add(card.setNumberedCard(color, value));
                }
            }
        }
        // Adding action cards
        for (CardColor color : CardColor.values()) {
            if (color == CardColor.NO_COLOR || color == CardColor.WILD) {
                continue;
            }
            var card = new Card();
            unoDeck.add(card.setActionCard(color, CardAction.SKIP));
            unoDeck.add(card.setActionCard(color, CardAction.SKIP));
            unoDeck.add(card.setActionCard(color, CardAction.REVERSE));
            unoDeck.add(card.setActionCard(color, CardAction.REVERSE));
            unoDeck.add(card.setActionCard(color, CardAction.DRAW_TWO));
            unoDeck.add(card.setActionCard(color, CardAction.DRAW_TWO));
        }
        // Adding wild cards
        for (int i = 0; i < 4; i++){
            unoDeck.add(new Card().setWildCard());
            unoDeck.add(new Card().setWildDrawFourCard());
        }
    }
    public void shuffle() {
        Collections.shuffle(unoDeck);
    }

    public CardBase drawCard() {
        if (unoDeck.isEmpty()) {
            Initialize();
            excludeTopCard();
            shuffle();
        }
        lastDraw = unoDeck.remove(0);
        return lastDraw;// Draw the top card from the deck
    }

    private void excludeTopCard() {
        unoDeck.removeIf(card -> card.getCard().equals(lastDraw.getCard()));
    }
    public boolean isEmpty() {
        return unoDeck.isEmpty();
    }
}
