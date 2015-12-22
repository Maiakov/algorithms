package com.maiakov.doublylinkedlist;

import java.util.NoSuchElementException;

import static com.maiakov.doublylinkedlist.Validator.validateIndexForDeleting;
import static com.maiakov.doublylinkedlist.Validator.validateInputList;
import static com.maiakov.doublylinkedlist.Validator.validateInputParameters;

public class DeleteFromDoublyLinkedList {

    public static Node deleteByElement(Node headOfList, Node nodeToDelete) {
        validateInputParameters(headOfList, nodeToDelete);

        if (headOfList.getValue() == nodeToDelete.getValue()) {
            return headOfList.getNext();
        }

        Node currentNode = findNode(headOfList, nodeToDelete);
        if (currentNode == null) {
            throw new NoSuchElementException(nodeToDelete + " does not exists in the list");
        }
        deleteNode(currentNode);
        return headOfList;
    }

    public static Node deleteByIndex(Node headOfList, int indexToDelete) {
        validateInputList(headOfList);
        validateIndexForDeleting(headOfList, indexToDelete);

        if (indexToDelete == 0) {
            Node newHead = headOfList.getNext();
            if (newHead != null) {
                newHead.setPrev(null);
            }
            return newHead;
        }

        Node nodeToDelete = findNode(headOfList, indexToDelete);
        deleteNode(nodeToDelete);
        return headOfList;
    }

    private static Node findNode(Node headOfList, Node nodeToFind) {
        Node currentNode = headOfList.getNext();
        while (currentNode != null && currentNode.getValue() != nodeToFind.getValue()) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private static Node findNode(Node headOfList, int index) {
        int currentIndex = 1;
        Node currentNode = headOfList.getNext();
        while (currentNode != null && currentIndex != index) {
            currentIndex++;
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    private static void deleteNode(Node node) {
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        prevNode.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        }
    }
}
