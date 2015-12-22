package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;

public class TreeFactory {
    public static Node getSimpleTree() {
        Node leftChild = new Node(2, null, null);
        Node rightChild = new Node(3, null, null);
        Node root = new Node(1, leftChild, rightChild);
        return root;
    }

    public static Node getTreeWithOnlyLeftChilds() {
        Node leftChild5 = new Node(5, null, null);
        Node leftChild4 = new Node(4, leftChild5, null);
        Node leftChild3 = new Node(3, leftChild4, null);
        Node leftChild2 = new Node(2, leftChild3, null);
        Node leftChild1 = new Node(1, leftChild2, null);
        Node root = new Node(0, leftChild1, null);
        return root;
    }

    public static  Node getTreeWithOnlyRightChilds() {
        Node rightChild5 = new Node(5, null, null);
        Node rightChild4 = new Node(4, null, rightChild5);
        Node rightChild3 = new Node(3, null, rightChild4);
        Node rightChild2 = new Node(2, null, rightChild3);
        Node rightChild1 = new Node(1, null, rightChild2);
        Node root = new Node(0, null, rightChild1);
        return root;
    }

    public static  Node getComplexTree() {
        Node child7 = new Node(7, null, null);
        Node child6 = new Node(6, null, child7);
        Node child5 = new Node(5, null, null);
        Node child4 = new Node(4, null, null);
        Node child3 = new Node(3, child4, child5);
        Node child2 = new Node(2, null, null);
        Node child1 = new Node(1, child2, child3);
        Node root = new Node(0, child1, child6);
        return root;
    }

}
