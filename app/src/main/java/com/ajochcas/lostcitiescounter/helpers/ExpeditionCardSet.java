package com.ajochcas.lostcitiescounter.helpers;

/**
 * Class stores a boolean base of hands. It handles casting
 * back and forth from an integer bitwise based representation
 * and the calculation of the expedition's value.
 */
public class ExpeditionCardSet {

    /**
     * The base cost of going on an expedition.
     * As long as you have at least one card
     * put into the expedition, this will
     * act as your starting negative score.
     */
    private static final int EXPEDITION_COST = 20;


    /**
     * The total amount of cards there are per
     * Expedition.
     */
    private static final int CARD_COUNT = 12;

    /**
     * The amount of Multiplier Cards there are
     * in the total card count
     */
    private static final int MULTIPLIER_COUNT = 3;

    /**
     * The amount of bonus points you get if you
     * meet of exceed the require bonus card count
     * requirements.
     */
    private static final int BONUS_POINTS = 20;


    /**
     * The amount of cards you must have in a single
     * expedition to get the bonus points.
     */
    private static final int BONUS_CARD_REQUIREMENT = 8;

    /**
     * How much how is a card worth over its position.
     */
    private static final int CARD_VALUE_MODIFER = 2;

    /**
     * 0-2 are $ sign cards
     * 3-12 are value cards.
     */
    public final boolean[] cards;

    /**
     * Default Constructor, makes an empty set of cards
     */
    public ExpeditionCardSet() {
        this.cards = new boolean[CARD_COUNT];
    }

    /**
     * @param representativeInt takes the current integer, in theory created
     *                        from the castToInt Method and re-creates
     *                        the object as if it was in that state.
     */
    public ExpeditionCardSet(int representativeInt) {
        this();
        for (int i = this.cards.length - 1; i >= 0; i--) {
            int currentInt = (int) Math.pow(2, i);
            if (representativeInt >= currentInt) {
                representativeInt -= currentInt;
                this.cards[i] = true;
            }
        }
    }

    /**
     * Casts the current hand of cards represented
     * to be casted into an integer for storage purposes. Based off
     * power of two
     *
     * @return the integer representation of the current expedition so
     * it can be stored in a readable file
     */
    public int castToInt() {
        int currentRep = 0;
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i]) {
                currentRep += (int) Math.pow(2, i);
            }
        }
        return currentRep;
    }

    /**
     * Given the current hand, calculates the score of the current
     * expedition.
     *
     * @return the value of the current expedition.
     */
    public int calculateValue() {
        if (this.castToInt() == 0) {
            //Since you have no cards put into this expedition
            //the overall value is zero, no additional math
            //needed
            return 0;
        } else {
            int cardCount = 0;
            int multiplierCount = 1;
            int expeditionValue = 0;
            expeditionValue -= EXPEDITION_COST;
            for (int i = 0; i < this.cards.length; i++) {
                if (this.cards[i]) {
                    cardCount +=1;
                    if (i < MULTIPLIER_COUNT) {
                        multiplierCount++;
                    } else {
                        expeditionValue += i - MULTIPLIER_COUNT + CARD_VALUE_MODIFER;
                    }
                }
            }
            expeditionValue *= multiplierCount;
            if(cardCount >= BONUS_CARD_REQUIREMENT)
            {
                expeditionValue += BONUS_POINTS;
            }
            return expeditionValue;
        }
    }
}
