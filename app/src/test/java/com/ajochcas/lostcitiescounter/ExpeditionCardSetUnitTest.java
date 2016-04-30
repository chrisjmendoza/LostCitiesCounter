package com.ajochcas.lostcitiescounter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExpeditionCardSetUnitTest {
    @Test
    public void CheckConstructorValueOne() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(4369);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", false, score.cards[1]);
        assertEquals("Index 2  ($)", false, score.cards[2]);
        assertEquals("Index 3  (1)", false, score.cards[3]);
        assertEquals("Index 4  (2)", true, score.cards[4]);
        assertEquals("Index 5  (3)", false, score.cards[5]);
        assertEquals("Index 6  (4)", false, score.cards[6]);
        assertEquals("Index 7  (5)", false, score.cards[7]);
        assertEquals("Index 8  (6)", true, score.cards[8]);
        assertEquals("Index 9  (7)", false, score.cards[9]);
        assertEquals("Index 10 (8)", false, score.cards[10]);
        assertEquals("Index 11 (9)", false, score.cards[11]);
        assertEquals("Index 12 (10)", true, score.cards[12]);

    }

    @Test
    public void CheckConstructorValueTwo() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(989);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", false, score.cards[1]);
        assertEquals("Index 2  ($)", true, score.cards[2]);
        assertEquals("Index 3  (1)", true, score.cards[3]);
        assertEquals("Index 4  (2)", true, score.cards[4]);
        assertEquals("Index 5  (3)", false, score.cards[5]);
        assertEquals("Index 6  (4)", true, score.cards[6]);
        assertEquals("Index 7  (5)", true, score.cards[7]);
        assertEquals("Index 8  (6)", true, score.cards[8]);
        assertEquals("Index 9  (7)", true, score.cards[9]);
        assertEquals("Index 10 (8)", false, score.cards[10]);
        assertEquals("Index 11 (9)", false, score.cards[11]);
        assertEquals("Index 12 (10)", false, score.cards[12]);
    }

    @Test
    public void CheckConstructorValueThree() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(989);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", false, score.cards[1]);
        assertEquals("Index 2  ($)", true, score.cards[2]);
        assertEquals("Index 3  (1)", true, score.cards[3]);
        assertEquals("Index 4  (2)", true, score.cards[4]);
        assertEquals("Index 5  (3)", false, score.cards[5]);
        assertEquals("Index 6  (4)", true, score.cards[6]);
        assertEquals("Index 7  (5)", true, score.cards[7]);
        assertEquals("Index 8  (6)", true, score.cards[8]);
        assertEquals("Index 9  (7)", true, score.cards[9]);
        assertEquals("Index 10 (8)", false, score.cards[10]);
        assertEquals("Index 11 (9)", false, score.cards[11]);
        assertEquals("Index 12 (10)", false, score.cards[12]);
    }


    @Test
    public void CheckConstructorEmpty() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(8191);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", true, score.cards[1]);
        assertEquals("Index 2  ($)", true, score.cards[2]);
        assertEquals("Index 3  (1)", true, score.cards[3]);
        assertEquals("Index 4  (2)", true, score.cards[4]);
        assertEquals("Index 5  (3)", true, score.cards[5]);
        assertEquals("Index 6  (4)", true, score.cards[6]);
        assertEquals("Index 7  (5)", true, score.cards[7]);
        assertEquals("Index 8  (6)", true, score.cards[8]);
        assertEquals("Index 9  (7)", true, score.cards[9]);
        assertEquals("Index 10 (8)", true, score.cards[10]);
        assertEquals("Index 11 (9)", true, score.cards[11]);
        assertEquals("Index 12 (10)", true, score.cards[12]);
    }

    @Test
    public void CheckCastToInt() throws Exception {
        ExpeditionCardSet score126 = new ExpeditionCardSet(126);
        assertEquals("Check Cast (126)", 126, score126.castToInt());

        ExpeditionCardSet score521 = new ExpeditionCardSet(521);
        assertEquals("Check Cast (521)", 521, score521.castToInt());

        ExpeditionCardSet score1962 = new ExpeditionCardSet(1962);
        assertEquals("Check Cast (1962)", 1962, score1962.castToInt());

        ExpeditionCardSet score6812 = new ExpeditionCardSet(6812);
        assertEquals("Check Cast (6812)", 6812, score6812.castToInt());

        ExpeditionCardSet score3828 = new ExpeditionCardSet(3828);
        assertEquals("Check Cast (3828)", 3828, score3828.castToInt());

        ExpeditionCardSet score0 = new ExpeditionCardSet(0);
        assertEquals("Check Cast (0)", 0, score0.castToInt());

        ExpeditionCardSet score1 = new ExpeditionCardSet(1);
        assertEquals("Check Cast (1)", 1, score1.castToInt());

        ExpeditionCardSet score8191 = new ExpeditionCardSet(8191);
        assertEquals("Check Cast (8191)", 8191, score8191.castToInt());

    }

    @Test
    public void CheckCalculateValue() throws Exception {
        ExpeditionCardSet score4369 = new ExpeditionCardSet(4369);
        assertEquals("Check Calculated Value (4369)", -4, score4369.calculateValue());
        ExpeditionCardSet score4371 = new ExpeditionCardSet(4371);
        assertEquals("Check Calculated Value (4371)", -6, score4371.calculateValue());
        ExpeditionCardSet score4375 = new ExpeditionCardSet(4375);
        assertEquals("Check Calculated Value (4375)", -8, score4375.calculateValue());
        ExpeditionCardSet score4383 = new ExpeditionCardSet(4383);
        assertEquals("Check Calculated Value (4383)", -4, score4383.calculateValue());
        ExpeditionCardSet score4415 = new ExpeditionCardSet(4415);
        assertEquals("Check Calculated Value (4415)", 28, score4415.calculateValue());
    }
}