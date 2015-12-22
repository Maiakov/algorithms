package com.maiakov.algorithm;

import com.maiakov.algorithm.iterator.InOrderIterator;
import com.maiakov.algorithm.iterator.Iterator;
import com.maiakov.algorithm.iterator.PostOrderIterator;
import com.maiakov.algorithm.iterator.PreOrderIterator;
import com.maiakov.algorithm.model.Node;

public class TreeBypassAlgorithm {
    public static void bypassInPreOrder(Node root) {
        validate(root);
        Iterator preOrderIterator = new PreOrderIterator(root);
        print(preOrderIterator);
    }

    public static void bypassInOrder(Node root) {
        validate(root);
        Iterator inOrderIterator = new InOrderIterator(root);
        print(inOrderIterator);
    }

    public static void bypassInPostOrder(Node root) {
        validate(root);
        Iterator postOrderIterator = new PostOrderIterator(root);
        print(postOrderIterator);
    }

    private static void print(Iterator iterator) {
        Node root;
        while ((root = iterator.next()) != null) {
            System.out.print(root + " ");
        }
    }

    private static void validate(Node root) {
        if(root == null){
            throw new IllegalArgumentException("Root element can not be null");
        }
    }
}
