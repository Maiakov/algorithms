package com.maiakov.doublylinkedlist;


public class Validator {

    public static void validateIndexForDeleting(Node headOfList, int index) {
        int length = getLength(headOfList);
        if (index >= length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index can not be negative");
        }
    }
    public static void validateInputParameters(Node headOfList, Node node) {
        validateInputList(headOfList);
        if (node == null) {
            throw new IllegalArgumentException("Input node can not be null");
        }
    }

    public static void validateInputList(Node headOfList) {
        if (headOfList == null) {
            throw new IllegalArgumentException("List can not be null");
        }
    }

    private static int getLength(Node headOfList) {
        int length = 0;
        Node currentNode = headOfList;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }
}
