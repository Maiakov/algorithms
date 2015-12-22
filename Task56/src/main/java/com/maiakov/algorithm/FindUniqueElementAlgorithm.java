package com.maiakov.algorithm;

public class FindUniqueElementAlgorithm {
    public static Node findUniqueElements(Node listWithDuplicates) {

        Node head = findFirstUniqueNode(listWithDuplicates);

        if (head == null) {
            return null;
        }

        Node prevNode = head;
        Node currentElement = head.getNext();

        while (currentElement != null) {
            prevNode.setNext(findNextUniqueNode(prevNode, currentElement));
            prevNode = currentElement;
            currentElement = currentElement.getNext();
        }
        return head;
    }

    private static Node findFirstUniqueNode(Node listWithDuplicates) {
        Node head;
        if (isFirstElementUnique(listWithDuplicates)) {
            head = listWithDuplicates;
        } else {
            head = findNextUniqueNode(listWithDuplicates, listWithDuplicates.getNext());
        }
        return head;
    }

    private static boolean isFirstElementUnique(Node head) {
        return head.getValue() != head.getNext().getValue();
    }

    private static Node findNextUniqueNode(Node prevNode, Node head) {

        Node leftNode = prevNode;
        Node currentNode = head;
        Node rightNode = head.getNext();
        while (currentNode != null) {
            if (rightNode == null) {
                return isLastNodeUnique(leftNode, currentNode) ? currentNode : null;
            } else if (isNodeUnique(currentNode, leftNode, rightNode)) {
                return currentNode;
            }
            leftNode = currentNode;
            currentNode = rightNode;
            rightNode = rightNode.getNext();
        }

        return null;
    }

    private static final boolean isNodeUnique(Node currentNode, Node leftNode, Node rightNode) {
        if (currentNode.getValue() != leftNode.getValue() && currentNode.getValue() != rightNode.getValue()) {
            return true;
        }
        return false;
    }

    private static final boolean isLastNodeUnique(Node leftNode, Node currentNode) {
        return currentNode.getValue() != leftNode.getValue();
    }


}
