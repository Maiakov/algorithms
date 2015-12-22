package com.maiakov.treebuilder;

import com.maiakov.treebuilder.exception.TreeBuilderException;
import com.maiakov.treebuilder.model.Tree;

import java.util.HashMap;
import java.util.Map;

import static com.maiakov.treebuilder.parser.FileParser.EMPTY_NODE_SIGN;

public class TreeBuilder {
    private static final int LEFT_CHILD = 1;
    private static final int RIGHT_CHILD = 2;
    private static final int PARENT = 0;
    private Map<String, Tree> treeNodes = new HashMap<>();
    private Tree root;
    private int rootHeight;

    public void addNodes(String[] nodes) {
        Tree leftChild = createChild(nodes[LEFT_CHILD]);
        Tree rightChild = createChild(nodes[RIGHT_CHILD]);
        Tree parent = createParent(nodes[PARENT], leftChild, rightChild);
        setRoot(parent);
    }

    public Tree build() {
        traverseTree(root);
        if (!allNodesVisited()) {
            throw new TreeBuilderException();
        }
        return root;
    }

    private Tree createChild(String label) {
        if (isNodeAbsent(label)) {
            return null;
        }
        if (treeNodes.get(label) != null) {
            return treeNodes.get(label);
        }
        Tree child = new Tree(label, null, null);
        treeNodes.put(label, child);
        return child;

    }

    private boolean isNodeAbsent(String label) {
        return EMPTY_NODE_SIGN.equals(label);
    }

    private Tree createParent(String label, Tree leftChild, Tree rightChild) {
        if (treeNodes.get(label) != null) {
            Tree parent = treeNodes.get(label);
            parent.setLeft(leftChild);
            parent.setRight(rightChild);
        }
        Tree parent = new Tree(label, leftChild, rightChild);
        treeNodes.put(label, parent);
        return parent;
    }

    private boolean allNodesVisited() {
        return treeNodes.isEmpty();
    }

    private void setRoot(Tree parent) {
        if (root == null) {
            root = parent;
        }

        int parentHeight = height(parent);
        if (parentHeight > rootHeight) {
            root = parent;
            rootHeight = parentHeight;
        }
    }

    private int height(Tree node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }

    private void traverseTree(Tree root) {
        treeNodes.remove(root.getLabel());
        if (root.getRight() != null) {
            traverseTree(root.getRight());
        }
        if (root.getLeft() != null) {
            traverseTree(root.getLeft());
        }
    }
}
