package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;

public class FindMiddleNodeAlgorithm {

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("Head of list can not be null");
        }
        Node currentNode = head;
        int listLength = getListLength(currentNode);
        if (listLength == 1) {
            return head;
        }
        if (listLength % 2 == 0) {
            throw new IllegalArgumentException("List does not contain middle element");
        }
        currentNode = head;
        return getMiddleNode(currentNode, listLength);
    }

    private static Node getMiddleNode(Node currentNode, int listLength) {
        int middleNodeIndex = listLength / 2 + 1;
        for (int i = 1; i < middleNodeIndex; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private static int getListLength(Node currentNode) {
        int listSize = 1;
        while ((currentNode = currentNode.getNext()) != null) {
            listSize++;
        }
        return listSize;
    }

}
