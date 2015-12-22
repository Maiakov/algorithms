package com.maiakov.cardsshuffling;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CardsShufflingAlgorithmsTest {
    private static final int PACK_SIZE = 52;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testShuffleWithNullCardsPack() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Size of cards pack must be 52");
        CardsShufflingAlgorithms.shuffle(null);
    }

    @Test
    public void testShuffleWithEmptyCardsPack() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Size of cards pack must be 52");
        CardsShufflingAlgorithms.shuffle(new byte[0]);
    }

    @Test
    public void testShuffleWith36Cards() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Size of cards pack must be 52");
        CardsShufflingAlgorithms.shuffle(new byte[36]);
    }

    @Test
    public void testShuffleCards10000Times() throws Exception {
        byte[][] resultsHistory = new byte[10000][52];
        for (int i = 0; i < 10000; i++) {
            byte[] actualResult = CardsShufflingAlgorithms.shuffle(prepareDefaultPack());
            assertWithPreviousResults(resultsHistory, actualResult);
            resultsHistory[i] = actualResult;
        }
    }

    private void assertWithPreviousResults(byte[][] resultsHistory, byte[] currentResult) {
        for (int i = 0; i < resultsHistory.length; i++) {
            assertThat(currentResult, not(equalTo(resultsHistory[i])));
        }

    }

    private static byte[] prepareDefaultPack() {
        byte[] cards = new byte[PACK_SIZE];
        for (byte i = 0; i < PACK_SIZE; i++) {
            cards[i] = i;
        }
        return cards;
    }

}