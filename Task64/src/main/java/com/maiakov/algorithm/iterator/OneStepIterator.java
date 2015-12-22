package com.maiakov.algorithm.iterator;

import com.maiakov.algorithm.model.Node;

public class OneStepIterator implements Iterator {
    @Override
    public Node getNext(Node node) {
        return node.getNext();
    }
}
