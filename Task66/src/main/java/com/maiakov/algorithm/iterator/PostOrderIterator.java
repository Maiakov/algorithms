package com.maiakov.algorithm.iterator;

import com.maiakov.algorithm.model.Node;

import java.util.Stack;

public class PostOrderIterator implements Iterator {
    private final Stack<Node> stk = new Stack<>();

    public PostOrderIterator(Node root) {
        stk.push(root);
    }

    @Override
    public Node next() {

        while (!stk.empty()) {
            Node cur = stk.peek();

            if (isNeedToAddRightChild(cur)) {
                stk.push(cur.getRightChild());
            }

            if (isNeedToAddLeftChild(cur)) {
                stk.push(cur.getLeftChild());
            }

            if (isElementExtreme(cur)) {
                cur.setVisited(true);
                stk.pop();
                return cur;
            }

        }
        return null;
    }

    private boolean isNeedToAddLeftChild(Node cur) {
        return isNeedToAddChild(cur.getRightChild());
    }

    private boolean isNeedToAddRightChild(Node cur) {
        return isNeedToAddChild(cur.getRightChild());
    }

    private boolean isNeedToAddChild(Node child) {
        return child != null && !child.isVisited();
    }

    private boolean isElementExtreme(Node cur) {
        return (cur.getLeftChild() == null || cur.getLeftChild().isVisited()) &&
                (cur.getRightChild() == null || cur.getRightChild().isVisited());
    }
}
