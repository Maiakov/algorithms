package com.maiakov.cardsshuffling;

import java.util.Random;

public class CardsShufflingAlgorithms {
    private static Random random = new Random();
    private static final byte packSize = 52;

    public static byte[] shuffle(byte[] cards) {
        if (cards == null || cards.length != 52) {
            throw new IllegalArgumentException("Size of cards pack must be 52");
        }

        for (int i = 0; i < packSize; i++) {
            int newPosition = random.nextInt(packSize - 1);
            swap(cards, i, newPosition);
        }
        return cards;
    }

    private static void swap(byte[] cards, int firstIndex, int secondIndex) {
        byte temp = cards[firstIndex];
        cards[firstIndex] = cards[secondIndex];
        cards[secondIndex] = temp;
    }
}
