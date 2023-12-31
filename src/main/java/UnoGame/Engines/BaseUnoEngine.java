package UnoGame.Engines;

import UnoGame.Cards.CardBase;
import UnoGame.Decks.AllBlanksUsedException;
import UnoGame.Players.Player;

import java.util.ArrayList;
import java.util.List;

// Template Method Pattern.
public abstract class BaseUnoEngine {
    public BaseUnoEngine() {

    }
    protected BaseUnoEngine(List<Player> players) {
        this.players = players;
    }

    public final void play() throws AllBlanksUsedException {
        dealingCardsToPlayers();
        while (!isGameFinished()) {
            currentPlayerTurn();
            if (playerNeedsToDraw())
                drawCard();
            else
                performCardAction(playCard());
            changeTurn();
        }
        displayWinner();
    }

    public abstract void changeTurn();

    private List<Player> players = new ArrayList<>();
    public List<Player> getPlayers(){
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
        System.out.println(player.getName() + " added to the game.");
    }
    protected abstract void dealingCardsToPlayers() throws AllBlanksUsedException;
    protected abstract boolean isGameFinished();
    protected abstract void currentPlayerTurn();
    protected abstract boolean playerNeedsToDraw();
    protected abstract void drawCard();
    protected abstract CardBase playCard();
    protected abstract void displayWinner();
    protected void performCardAction(CardBase card) throws AllBlanksUsedException {
        if (card != null){
            switch (card.getAction()) {
                case SKIP:
                    handleSkipAction();
                    break;
                case REVERSE:
                    handleReverseAction();
                    break;
                case DRAW_TWO:
                    handleDrawTwoAction();
                    break;
                case CHANGE_COLOR:
                    handleChangeColorAction();
                    break;
                case CHANGE_COLOR_DRAW_FOUR:
                    handleChangeColorDrawFourAction();
                    break;
                default:
                    performAdditionalActionCards(card);
                    break;
            }
        }
    }

    protected abstract void handleSkipAction();
    protected abstract void handleReverseAction();
    protected abstract void handleDrawTwoAction() throws AllBlanksUsedException;
    protected abstract void handleChangeColorAction();
    protected abstract void handleChangeColorDrawFourAction() throws AllBlanksUsedException;
    //Add additional actions to handle it if needed
    protected abstract void performAdditionalActionCards(CardBase card);
}
