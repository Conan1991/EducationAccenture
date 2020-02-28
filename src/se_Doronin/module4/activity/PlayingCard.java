package sef.module4.activity;

import java.util.Map;

/**
 * This class represents a playing card
 *
 * @author John Doe
 */

public class PlayingCard {

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;


    public static final int JOKER = 0;
    public static final int SPADES = 4;
    public static final int HEARTS = 3;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 1;

    public enum Numbers {
        JOKER, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

        public static boolean contains(int value) {
            return (value >= JOKER.ordinal() && value <= KING.ordinal());
        }

        public static Numbers valueOf(int value) {
            for (Numbers number : Numbers.values())
                if (value == number.ordinal())
                    return number;
            return Numbers.JOKER;
        }
    }

    public enum Suits {
        JOKER, CLUBS, DIAMONDS, HEARTS, SPADES;

        public static boolean contains(int value) {
            for (Suits suit : Suits.values())
                if (value == suit.ordinal())
                    return true;
            return false;
        }

        public static Suits valueOf(int value) {
            for (Suits suit : Suits.values())
                if (value == suit.ordinal())
                    return suit;
            return Suits.JOKER;
        }
    }

    Numbers number;
    Suits suit;

    /**
     * Creates an instance of a PlayingCard given the specified parameters. Valid
     * values for the number and suit parameters are the range of static attributes
     * ACE to KING for number and CLUBS to SPADES for suit.  JOKER values can be
     * applied to suit and number.
     * <p>
     * If a JOKER value or any invalid value is assigned to either number or
     * suit, then both number and suit are assigned the JOKER value.
     *
     * @param _number the number of the card
     * @param _suit   the suit of the card
     */
    public PlayingCard(int _number, int _suit) {
        number = Numbers.valueOf(_number);
        suit = Suits.valueOf(_suit);

        if (number == Numbers.JOKER || suit == Suits.JOKER) {
            number = Numbers.JOKER;
            suit = Suits.JOKER;
        }
    }

    /**
     * Creates an instance of a JOKER PlayingCard
     */
    public PlayingCard() {
        this(-1, -1);
    }

    /**
     * Return the number of the card . Valid values returned can be one of the static fields of this
     * class from ACE to KING or JOKER
     *
     * @return the number
     */
    public int getNumber() {
        return number.ordinal();
    }

    /**
     * Return the suit of the card.  Valid values returned can be one of the static fields of this
     * class from CLUBS to SPADES or JOKER
     *
     * @return the suit
     */
    public int getSuit() {
        return suit.ordinal();
    }

    /**
     * Return a String representation of this card in the following form:
     * "<number> of <suit>"
     *
     * @return the String representation of this card
     */
    public String toString() {
        if (number == Numbers.JOKER || suit == Suits.JOKER)
            return Numbers.JOKER.toString();
        return number.toString() + " of " + suit.toString();
    }
}
