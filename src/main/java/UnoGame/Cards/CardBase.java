package UnoGame.Cards;

import UnoGame.Cards.Enums.CardAction;
import UnoGame.Cards.Enums.CardColor;
import UnoGame.Cards.Enums.CardType;

public abstract class CardBase {
    public abstract String Show();
    public abstract CardBase getCard();
    public abstract CardAction getAction();
    public abstract String getValue();
    public abstract CardColor getColor();
    public abstract CardType getType();
    public abstract void setColor(CardColor color);
}