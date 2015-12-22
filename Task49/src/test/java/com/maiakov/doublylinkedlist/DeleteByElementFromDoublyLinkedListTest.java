package com.maiakov.doublylinkedlist;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.maiakov.doublylinkedlist.CreateDoublyListFactory.createListFromArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteByElementFromDoublyLinkedListTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDeleteElementsByIndexWhenIndex0() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2});
        Node actualResult = DeleteFromDoublyLinkedList.deleteByIndex(inputList, 0);
        Node expectedList = createListFromArray(new int[]{2});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementsByIndexWhenIndex2() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4});
        Node actualResult = DeleteFromDoublyLinkedList.deleteByIndex(inputList, 2);
        Node expectedList = createListFromArray(new int[]{0, 1, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }
    @Test
    public void testDeleteElementsByIndexSecondElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4});
        Node actualResult = DeleteFromDoublyLinkedList.deleteByIndex(inputList, 1);
        Node expectedList = createListFromArray(new int[]{0, 2, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }
    @Test
    public void testDeleteElementsByIndexWithOneElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0});
        Node actualResult = DeleteFromDoublyLinkedList.deleteByIndex(inputList, 0);
        assertNull(actualResult);
    }

    @Test
    public void testDeleteElementsByIndexWhenIndexOutOfBound() throws Exception {
        Node inputList = createListFromArray(new int[]{0});
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Index out of bound");
        DeleteFromDoublyLinkedList.deleteByIndex(inputList, 1);
    }

    @Test
    public void testDeleteElementsByIndexLastElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        Node actualResult = DeleteFromDoublyLinkedList.deleteByIndex(inputList, 8);
        Node expectedList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7});

        assertEquals(expectedList.toString(), actualResult.toString());
    }
}