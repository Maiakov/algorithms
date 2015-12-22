package com.maiakov.algorithm;

public class ReverseWithRecursionAlgorithm {

    public static  Node reverse(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Input list can`t be null");
        }
        if (node.getNext() == null) {
            return node;
        }
        Node next = node.getNext();
        node.setNext(null);
        return swap(node, next);

    }

    public static  Node swap(Node node, Node nextNode) {
        if (nextNode.getNext() == null) {
            nextNode.setNext(node);
            return nextNode;
        } else {
            Node next = nextNode.getNext();
            nextNode.setNext(node);
            nextNode = swap(nextNode, next);
        }
        return nextNode;
    }
}
