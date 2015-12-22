package com.maiakov.algorithm.iterator;

import com.maiakov.algorithm.model.Node;

import java.util.Stack;

public class PreOrderIterator implements Iterator {
    private final Stack<Node> stk = new Stack<>();

    public PreOrderIterator(Node root) {
        stk.push(root);
    }

    @Override
    public Node next( ) {
        if (stk.size() == 0) {
            return null;
        }

        Node cur = stk.pop();
        if (cur.getRightChild() != null) {
            stk.push(cur.getRightChild());
        }
        if (cur.getLeftChild() != null) {
            stk.push(cur.getLeftChild());
        }

        return cur;
    }
}
