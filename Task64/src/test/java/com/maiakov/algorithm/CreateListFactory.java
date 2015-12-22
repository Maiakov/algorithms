package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;

public class CreateListFactory {
    public static Node createListFromArray(int loopIndex, int... elements) {
        Node tailNode = new Node(elements[elements.length - 1], null);
        Node lastNode = tailNode;
        for (int i = elements.length - 2; i >= 0; i--) {
            Node currentNode = new Node(elements[i], tailNode);
            tailNode = currentNode;
            if (i == loopIndex) {
                lastNode.setNext(currentNode);
            }
        }
        return tailNode;
    }
}
