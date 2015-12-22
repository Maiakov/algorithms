package com.maiakov.algorithm;

import com.maiakov.algorithm.iterator.Iterator;
import com.maiakov.algorithm.iterator.OneStepIterator;
import com.maiakov.algorithm.iterator.TwoStepsIterator;
import com.maiakov.algorithm.model.Node;

public class LoopDeterminantAlgorithm {

    private static Iterator oneStepIterator = new OneStepIterator();
    private static Iterator twoStepIterator = new TwoStepsIterator();

    public static boolean hasLoop(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("Input list can not be null");
        }
        if (head.getNext() == null) {
            return false;
        }

        Node oneElementIterator = head;
        Node twoElementIterator = head;
        boolean hasLoop;
        for (; ; ) {
            oneElementIterator = oneStepIterator.getNext(oneElementIterator);
            twoElementIterator = twoStepIterator.getNext(twoElementIterator);

            if (oneElementIterator == null || twoElementIterator == null) {
                hasLoop = false;
                break;
            }

            if (oneElementIterator.getValue() == twoElementIterator.getValue()) {
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }

}
