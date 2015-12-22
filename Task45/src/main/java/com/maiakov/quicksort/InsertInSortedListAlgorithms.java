package com.maiakov.quicksort;

public class InsertInSortedListAlgorithms {

    public static Node insert(Node nodeToInsert, Node headOfSortedList) {
        if(headOfSortedList == null){
            return nodeToInsert;
        }
        if (isNeedToInsertInTheBeginning(nodeToInsert, headOfSortedList)) {
            nodeToInsert.setNext(headOfSortedList);
            return nodeToInsert;
        }
        Node currentNode = headOfSortedList;
        Node nextNode = currentNode.getNext();
        while (nextNode != null && nextNode.getValue() < nodeToInsert.getValue()) {
            currentNode = nextNode;
            nextNode = currentNode.getNext();
        }
        nodeToInsert.setNext(nextNode);
        currentNode.setNext(nodeToInsert);
        return headOfSortedList;
    }

    private static boolean isNeedToInsertInTheBeginning(Node nodeToInsert, Node headOfSortedList) {
        return nodeToInsert.getValue() < headOfSortedList.getValue();
    }

}
