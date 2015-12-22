package com.maiakov.algorithm;

public class ReverseWithCycleAlgorithm {

    public static Node reverse(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Input list can`t be null");
        }
        if (node.getNext() == null) {
            return node;
        }
        Node head = node;
        Node secondNode = node.getNext();
        Node thirdNode = secondNode.getNext();
        head.setNext(null);
        secondNode.setNext(head);

        if(thirdNode == null){
            return secondNode;
        }
        return reverseInCycle(thirdNode, secondNode);

    }

    private static Node reverseInCycle(Node currentNode, Node prevNode) {
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }
}
