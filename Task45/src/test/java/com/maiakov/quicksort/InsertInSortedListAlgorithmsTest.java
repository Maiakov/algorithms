package com.maiakov.quicksort;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertInSortedListAlgorithmsTest {

    @Test
    public void testInsertInTheBeginning() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 6, 4, 3, 5});
        Node nodeToInsert = new Node(1, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, sortedList);
        Node expectedResult = createListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        assertEquals(expectedResult.toString(), actualResult.toString());

    }

    @Test
    public void testInsertInTheEnd() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{1, 2, 0, 5, 3, 4});
        Node nodeToInsert = new Node(6, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, sortedList);
        Node expectedResult = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6});
        assertEquals(expectedResult.toString(), actualResult.toString());

    }

    @Test
    public void testInsertInTheMiddle() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{0, 5, 1, 4});
        Node nodeToInsert = new Node(3, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, sortedList);
        Node expectedResult = createListFromArray(new int[]{0, 1, 3, 4, 5});
        assertEquals(expectedResult.toString(), actualResult.toString());

    }

    @Test
    public void testInsertInListOfDuplicates() throws Exception {
        Node sortedList = createListFromArray(new int[]{1, 1, 1, 1, 1});
        Node nodeToInsert = new Node(1, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, sortedList);
        Node expectedResult = createListFromArray(new int[]{1, 1, 1, 1, 1, 1});
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void testInsertInListWithOneElement() throws Exception {
        Node sortedList = createListFromArray(new int[]{5});
        Node nodeToInsert = new Node(1, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, sortedList);
        Node expectedResult = createListFromArray(new int[]{1, 5});
        assertEquals(expectedResult.toString(), actualResult.toString());

    }

    @Test
    public void testInsertInEmptyList() throws Exception {
        Node nodeToInsert = new Node(1, null);
        Node actualResult = InsertInSortedListAlgorithms.insert(nodeToInsert, null);
        Node expectedResult = nodeToInsert;
        assertEquals(expectedResult.toString(), actualResult.toString());

    }
    private Node createListFromArray(int... elements) {
        Node lastNode = new Node(elements[elements.length - 1], null);
        for (int i = elements.length - 2; i >= 0; i--) {
            Node currentNode = new Node(elements[i], lastNode);
            lastNode = currentNode;
        }
        return lastNode;

    }

    private Node createSortedListFromArray(int... elements) {
        QuickSortAlgorithm.sort(elements);
        Node lastNode = new Node(elements[elements.length - 1], null);
        for (int i = elements.length - 2; i >= 0; i--) {
            Node currentNode = new Node(elements[i], lastNode);
            lastNode = currentNode;
        }
        return lastNode;

    }

}