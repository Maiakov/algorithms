package com.maiakov.listmanipulation;

import java.util.NoSuchElementException;

import static com.maiakov.listmanipulation.Validator.*;

public class ListUtils {
    public static Node addAtIndex(Node headOfList, Node nodeToInsert, int index) {
        validateInputParameters(headOfList, nodeToInsert, index);

        if (index == 0) {
            nodeToInsert.setNext(headOfList);
            return nodeToInsert;
        }

        int currentIndex = 1;
        Node currentNode = headOfList;
        Node nextNode = currentNode.getNext();
        while (nextNode != null && currentIndex != index) {
            currentIndex++;
            currentNode = nextNode;
            nextNode = currentNode.getNext();
        }
        nodeToInsert.setNext(nextNode);
        currentNode.setNext(nodeToInsert);
        return headOfList;
    }

    public static Node deleteElement(Node headOfList, Node nodeToDelete) {
        validateInputParameters(headOfList, nodeToDelete);

        if (headOfList.getValue() == nodeToDelete.getValue()) {
            return headOfList.getNext();
        }

        Node prevNode = headOfList;
        Node currentNode = headOfList.getNext();
        while (currentNode != null && currentNode.getValue() != nodeToDelete.getValue()) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            throw new NoSuchElementException(nodeToDelete + " does not exists in the list");
        }
        prevNode.setNext(currentNode.getNext());
        return headOfList;
    }

    public static Node deleteElement(Node headOfList, int indexToDelete) {
        validateInputList(headOfList);
        validateIndexForDeleting(headOfList, indexToDelete);

        if (indexToDelete == 0) {
            return headOfList.getNext();
        }

        int currentIndex = 1;
        Node prevNode = headOfList;
        Node currentNode = headOfList.getNext();
        while (currentNode != null && currentIndex != indexToDelete) {
            currentIndex++;
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        prevNode.setNext(currentNode.getNext());
        return headOfList;
    }

    public static Node addLast(Node headOfList, Node nodeToAdd) {
        validateInputParameters(headOfList, nodeToAdd);

        Node lastElement = headOfList;
        while (lastElement.getNext() != null) {
            lastElement = lastElement.getNext();
        }
        lastElement.setNext(nodeToAdd);
        return headOfList;
    }

}

