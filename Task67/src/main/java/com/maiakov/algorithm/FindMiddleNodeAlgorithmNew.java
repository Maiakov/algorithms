package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;

public class FindMiddleNodeAlgorithmNew {

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("Head of list can not be null");
        }
        Node middleElement = head;
        Node lastElement = head;
        while ((lastElement = twoSteps(lastElement)) != null) {
            middleElement = oneStep(middleElement);
        }
        return middleElement;
    }

    private static Node oneStep(Node currentNode) {
        return currentNode.getNext();
    }

    private static Node twoSteps(Node currentNode) {
        if (currentNode.getNext() != null) {
            return currentNode.getNext().getNext();
        }
        return null;
    }

}
