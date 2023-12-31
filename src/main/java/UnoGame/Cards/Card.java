package UnoGame.Cards;

import UnoGame.Cards.Enums.*;

public class Card extends CardBase{
    private final int NULL_VALUE = -1;
    private CardType type;
    private CardColor color;
    private int value = NULL_VALUE; //Initialize it with a number is not exist in the uno game
    private CardAction action;
    public Card(){

    }
    // Constructor for numbered cards
    private Card(CardType type, CardColor color, int value, CardAction action) {
        this.type = type;
        this.color = color;
        this.value = value;
        this.action = action;
    }
    public Card setNumberedCard(CardColor color, int value){
        return new Card(CardType.NUMBER, color, value, CardAction.NO_ACTION);
    }
    public Card setActionCard(CardColor color, CardAction action){
        return new Card(CardType.ACTION, color, NULL_VALUE, action);
    }
    public Card setWildCard(){
        return new Card(CardType.WILD, CardColor.WILD, NULL_VALUE, CardAction.CHANGE_COLOR);
    }
    public Card setWildDrawFourCard(){
        return new Card(CardType.WILD, CardColor.WILD, NULL_VALUE, CardAction.CHANGE_COLOR_DRAW_FOUR);
    }

    @Override
    public String Show() {
        String color = Consts.COLOR_MAP.get(getColor());
        if (type == CardType.ACTION || type == CardType.WILD){
            return color + String.valueOf(getAction()) + Consts.ANSI_RESET;
        }
        if (type == CardType.NUMBER){
            return color + String.valueOf(getValue()) + Consts.ANSI_RESET;
        }
        return "";
    }

    @Override
    public CardBase getCard() {
        return new Card(type, color, value, action);
    }

    @Override
    public CardAction getAction() {
        return action;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public CardColor getColor() {
        return color;
    }
    @Override
    public void setColor(CardColor color) {
        this.color = color;
    }
    @Override
    public CardType getType() {
        return type;
    }
}
