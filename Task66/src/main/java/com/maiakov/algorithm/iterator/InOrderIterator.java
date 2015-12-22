package com.maiakov.algorithm.iterator;

import com.maiakov.algorithm.model.Node;

import java.util.Stack;

public class InOrderIterator implements Iterator {
    private final Stack<Node> stk = new Stack<>();

    public InOrderIterator(Node root) {
        stk.push(root);
    }

    @Override
    public Node next() {
        while (!stk.empty()) {
            Node cur = stk.peek();

            if (!cur.isVisited()) {
                if (isNeedToAddLeftChild(cur)) {
                    stk.push(cur.getLeftChild());
                } else if (isAllLeftChildsProcessed(cur)) {
                    cur.setVisited(true);
                    return cur;
                }
            } else {
                if (isNeedToAddRightChild(cur)) {
                    stk.push(cur.getRightChild());
                } else {
                    stk.pop();
                }
            }

        }
        return null;
    }

    private boolean isAllLeftChildsProcessed(Node cur) {
        return cur.getLeftChild() == null || cur.getLeftChild().isVisited();
    }

    private boolean isNeedToAddRightChild(Node cur) {
        return isNeedToAddChild(cur.getRightChild());
    }

    private boolean isNeedToAddLeftChild(Node cur) {
        return isNeedToAddChild(cur.getLeftChild());
    }

    private boolean isNeedToAddChild(Node child) {
        return child != null && !child.isVisited();
    }
}
