package UnoGame.Cards.Enums;

import java.util.HashMap;
import java.util.Map;

public class Consts {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GRAY = "\u001B[90m";
    public static final String ANSI_LIGHT_GRAY = "\u001B[37m";
    public static final Map<CardColor, String> COLOR_MAP = new HashMap<>();

    static {
        COLOR_MAP.put(CardColor.RED, Consts.ANSI_RED);
        COLOR_MAP.put(CardColor.BLUE, Consts.ANSI_BLUE);
        COLOR_MAP.put(CardColor.GREEN, Consts.ANSI_GREEN);
        COLOR_MAP.put(CardColor.YELLOW, Consts.ANSI_YELLOW);
        COLOR_MAP.put(CardColor.WILD, Consts.ANSI_GRAY);
    }
}