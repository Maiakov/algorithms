package com.maiakov.algorithm.model;

public class Node {
    private int value;
    private Node next;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

}
