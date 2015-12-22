package com.maiakov.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FindUniqueElementAlgorithmTest {

    @Test
    public void testFindUniqueElementsWhenAllElementsUnique() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 6, 4, 3, 5});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);
        Node expectedResult = createSortedListFromArray(new int[]{2, 6, 4, 3, 5});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindUniqueElementsWithoutUniqueElements() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 2, 6, 6, 4, 4, 3, 3});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);

        assertNull(actualResult);
    }

    @Test
    public void testFindUniqueElementsWhenUniqueInTheBeginning() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{1, 2, 2, 6, 6, 4, 4, 3, 3});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);
        Node expectedResult = createSortedListFromArray(new int[]{1});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindUniqueElementsWhenUniqueInTheMiddle() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 2, 6, 6, 5, 4, 4, 3, 3});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);
        Node expectedResult = createSortedListFromArray(new int[]{5});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindUniqueElementsWhenUniqueInTheEnd() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 2, 6, 6, 10, 4, 4, 3, 3});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);
        Node expectedResult = createSortedListFromArray(new int[]{10});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindUniqueElementsWithManyUniqueElements() throws Exception {
        Node sortedList = createSortedListFromArray(new int[]{2, 2, 1, 6, 6, 3, 7, 4, 10, 4, 4, 3, 3});
        Node actualResult = FindUniqueElementAlgorithm.findUniqueElements(sortedList);
        Node expectedResult = createSortedListFromArray(new int[]{1, 7, 10});
        assertEquals(expectedResult, actualResult);
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