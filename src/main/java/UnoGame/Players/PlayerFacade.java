package UnoGame.Players;

import UnoGame.Engines.BaseUnoEngine;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// Facade Method Pattern
public class PlayerFacade {
    private BaseUnoEngine unoGame;

    public PlayerFacade(BaseUnoEngine unoGame) {
        this.unoGame = unoGame;
    }

    public void addPlayers(@NotNull List<String> playerNames) {
        if (playerNames.size() < 2 || playerNames.size() > 10) {
            System.out.println("Invalid number of players. Uno game allows 2 to 10 players.");
            return;
        }

        for (String name : playerNames) {
            Player player = new Player(name);
            unoGame.addPlayer(player);
        }
    }
}
