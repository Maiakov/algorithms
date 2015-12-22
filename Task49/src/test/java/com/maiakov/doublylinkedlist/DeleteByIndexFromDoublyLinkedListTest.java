package com.maiakov.doublylinkedlist;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static com.maiakov.doublylinkedlist.CreateDoublyListFactory.*;

public class DeleteByIndexFromDoublyLinkedListTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDeleteFirstElement() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2});
        Node nodeToDelete = new Node(1, null, null);
        Node actualResult = DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{2});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementInTheMiddle() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4});
        Node nodeToDelete = new Node(2, null, null);
        Node actualResult = DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{0, 1, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteSecondElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4});
        Node nodeToDelete = new Node(1, null, null);
        Node actualResult = DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{0, 2, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteOneSoleElement() throws Exception {
        Node inputList = createListFromArray(new int[]{1});
        Node nodeToDelete = new Node(1, null, null);
        Node actualResult = DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
        assertNull(actualResult);
    }

    @Test
    public void testDeleteElementThatDoesNotExists() throws Exception {
        Node inputList = createListFromArray(new int[]{0});
        Node nodeToDelete = new Node(1, null, null);
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage(nodeToDelete + " does not exists in the list");
        DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
    }

    @Test
    public void testDeleteLastElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        Node nodeToDelete = new Node(8, null, null);
        Node actualResult = DeleteFromDoublyLinkedList.deleteByElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7});

        assertEquals(expectedList.toString(), actualResult.toString());
    }
}