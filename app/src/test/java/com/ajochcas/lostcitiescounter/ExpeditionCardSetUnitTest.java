package com.ajochcas.lostcitiescounter;

import com.ajochcas.lostcitiescounter.helpers.ExpeditionCardSet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExpeditionCardSetUnitTest {
    @Test
    public void CheckConstructorValueOne() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(273);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", false, score.cards[1]);
        assertEquals("Index 2  ($)", false, score.cards[2]);
        assertEquals("Index 3  (2)", false, score.cards[3]);
        assertEquals("Index 4  (3)", true, score.cards[4]);
        assertEquals("Index 5  (4)", false, score.cards[5]);
        assertEquals("Index 6  (5)", false, score.cards[6]);
        assertEquals("Index 7  (6)", false, score.cards[7]);
        assertEquals("Index 8  (7)", true, score.cards[8]);
        assertEquals("Index 9  (8)", false, score.cards[9]);
        assertEquals("Index 10 (9)", false, score.cards[10]);
        assertEquals("Index 11 (10)", false, score.cards[11]);

    }

    @Test
    public void CheckConstructorValueTwo() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(989);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", false, score.cards[1]);
        assertEquals("Index 2  ($)", true, score.cards[2]);
        assertEquals("Index 3  (2)", true, score.cards[3]);
        assertEquals("Index 4  (3)", true, score.cards[4]);
        assertEquals("Index 5  (4)", false, score.cards[5]);
        assertEquals("Index 6  (5)", true, score.cards[6]);
        assertEquals("Index 7  (6)", true, score.cards[7]);
        assertEquals("Index 8  (7)", true, score.cards[8]);
        assertEquals("Index 9  (8)", true, score.cards[9]);
        assertEquals("Index 10 (9)", false, score.cards[10]);
        assertEquals("Index 11 (10)", false, score.cards[11]);
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
    }


    @Test
    public void CheckConstructorEmpty() throws Exception {
        ExpeditionCardSet score = new ExpeditionCardSet(4095);
        assertEquals("Index 0  ($)", true, score.cards[0]);
        assertEquals("Index 1  ($)", true, score.cards[1]);
        assertEquals("Index 2  ($)", true, score.cards[2]);
        assertEquals("Index 3  (2)", true, score.cards[3]);
        assertEquals("Index 4  (3)", true, score.cards[4]);
        assertEquals("Index 5  (4)", true, score.cards[5]);
        assertEquals("Index 6  (5)", true, score.cards[6]);
        assertEquals("Index 7  (6)", true, score.cards[7]);
        assertEquals("Index 8  (7)", true, score.cards[8]);
        assertEquals("Index 9  (8)", true, score.cards[9]);
        assertEquals("Index 10 (9)", true, score.cards[10]);
        assertEquals("Index 11 (10)", true, score.cards[11]);
    }

    @Test
    public void CheckCastToInt() throws Exception {
        ExpeditionCardSet score126 = new ExpeditionCardSet(126);
        assertEquals("Check Cast (126)", 126, score126.castToInt());

        ExpeditionCardSet score521 = new ExpeditionCardSet(521);
        assertEquals("Check Cast (521)", 521, score521.castToInt());

        ExpeditionCardSet score1962 = new ExpeditionCardSet(1962);
        assertEquals("Check Cast (1962)", 1962, score1962.castToInt());

        ExpeditionCardSet score3974 = new ExpeditionCardSet(3974);
        assertEquals("Check Cast (3974)", 3974, score3974.castToInt());

        ExpeditionCardSet score3828 = new ExpeditionCardSet(3828);
        assertEquals("Check Cast (3828)", 3828, score3828.castToInt());

        ExpeditionCardSet score0 = new ExpeditionCardSet(0);
        assertEquals("Check Cast (0)", 0, score0.castToInt());

        ExpeditionCardSet score1 = new ExpeditionCardSet(1);
        assertEquals("Check Cast (1)", 1, score1.castToInt());

    }

    @Test
    public void CheckCalculateValue() throws Exception {
        ExpeditionCardSet score2321 = new ExpeditionCardSet(2321);
        assertEquals("Check Calculated Value (2321)", 0, score2321.calculateValue());

        ExpeditionCardSet score2431 = new ExpeditionCardSet(2431);
        assertEquals("Check Calculated Value (2431)", 64, score2431.calculateValue());

        ExpeditionCardSet score1752 = new ExpeditionCardSet(1752);
        assertEquals("Check Calculated Value (1752)", 13, score1752.calculateValue());

        ExpeditionCardSet score2101 = new ExpeditionCardSet(2101);
        assertEquals("Check Calculated Value (2101)", -9, score2101.calculateValue());

        ExpeditionCardSet score3451 = new ExpeditionCardSet(3451);
        assertEquals("Check Calculated Value (3451)", 80, score3451.calculateValue());
    }
}