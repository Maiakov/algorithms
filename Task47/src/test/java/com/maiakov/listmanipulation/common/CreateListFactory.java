package com.maiakov.listmanipulation.common;

import com.maiakov.listmanipulation.Node;

public class CreateListFactory {
    public static Node createListFromArray(int... elements) {
        Node lastNode = new Node(elements[elements.length - 1], null);
        for (int i = elements.length - 2; i >= 0; i--) {
            Node currentNode = new Node(elements[i], lastNode);
            lastNode = currentNode;
        }
        return lastNode;
    }
}
