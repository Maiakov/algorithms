package com.maiakov.algorithm.iterator;

import com.maiakov.algorithm.model.Node;

public class TwoStepsIterator implements Iterator {
    @Override
    public Node getNext(Node node) {
        Node next = node.getNext();
        if (next != null) {
            return next.getNext();
        }
        return null;
    }
}
