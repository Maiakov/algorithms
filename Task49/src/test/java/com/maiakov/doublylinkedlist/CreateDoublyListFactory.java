package com.maiakov.doublylinkedlist;

public class CreateDoublyListFactory {
    public static Node createListFromArray(int... elements) {
        Node lastNode = new Node(elements[elements.length - 1], null, null);
        for (int i = elements.length - 2; i >= 0; i--) {
            Node currentNode = new Node(elements[i], lastNode, null);
            lastNode.setPrev(currentNode);
            lastNode = currentNode;
        }
        return lastNode;
    }
}
