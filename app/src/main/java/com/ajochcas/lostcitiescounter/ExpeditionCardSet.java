package com.ajochcas.lostcitiescounter;

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
    public static final int EXPEDITION_COST = 20;

    /**
     * How much each multiplier card multiples the end
     * value of the expedition by.
     */
    public static final int MULTIPLIER_MODIFIER = 2;

    /**
     * The total amount of cards there are per
     * Expedition.
     */
    public static final int CARD_COUNT = 13;

    /**
     * The amount of Multiplier Cards there are
     * in the total card count
     */
    public static final int MULTIPLIER_COUNT = 3;

    /**
     * 0-2 are $ sign cards
     * 3-12 are value cards.
     */
    public boolean[] cards;

    /**
     * Default Constructor, makes an empty set of cards
     */
    public ExpeditionCardSet() {
        this.cards = new boolean[CARD_COUNT];
    }

    /**
     * @param representiveInt takes the current integer, in theory created
     *                        from the castToInt Method and re-creates
     *                        the object as if it was in that state.
     */
    public ExpeditionCardSet(int representiveInt) {
        this();
        for (int i = this.cards.length; i >= 0; i--) {
            if (representiveInt > i) {
                representiveInt -= (i + 1);
                this.cards[i] = true;
            }
        }
    }

    /**
     * Casts the current hand of cards represented in this class
     * to be casted into an integer for storage proposes. Based off
     * Power of two
     *
     * @return the integer representation of the current expedition so
     * it can be stored.
     */
    public int castToInt() {
        int currentRep = 0;
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i]) {
                currentRep += (int) Math.pow(i + 1, 2);
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
            int multiplierCount = 0;
            int expeditionValue = 0;
            expeditionValue -= EXPEDITION_COST;
            for (int i = 0; i < this.cards.length; i++) {
                if (this.cards[i]) {
                    if (i < MULTIPLIER_COUNT) {
                        multiplierCount++;
                    } else {
                        expeditionValue += i + 1 - MULTIPLIER_COUNT;
                    }
                }
            }
            if (multiplierCount > 0) {
                expeditionValue *= multiplierCount * MULTIPLIER_MODIFIER;
            }
            return expeditionValue;
        }
    }
}
