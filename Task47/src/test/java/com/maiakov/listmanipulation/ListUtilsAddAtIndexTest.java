package com.maiakov.listmanipulation;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static com.maiakov.listmanipulation.common.CreateListFactory.*;
public class ListUtilsAddAtIndexTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAddAtIndex1() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 3, 4, 5});
        Node nodeToAdd = new Node(2, null);
        Node actualResult = ListUtils.addAtIndex(inputList, nodeToAdd, 1);
        Node expectedList = createListFromArray(new int[]{1, 2, 3, 4, 5});
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testAddAtIndex0() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 3, 4, 5});
        Node nodeToAdd = new Node(2, null);
        Node actualResult = ListUtils.addAtIndex(inputList, nodeToAdd, 0);
        Node expectedList = createListFromArray(new int[]{2, 1, 3, 4, 5});
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testAddAtIndexEqualsLength() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 3, 4, 5});
        Node nodeToAdd = new Node(2, null);
        Node actualResult = ListUtils.addAtIndex(inputList, nodeToAdd, 4);
        Node expectedList = createListFromArray(new int[]{1, 3, 4, 5, 2});
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testAddAtIndexGreaterThenLength() throws Exception {
        Node inputList = createListFromArray(new int[]{1});
        Node nodeToAdd = new Node(2, null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Index out of bound");
        ListUtils.addAtIndex(inputList, nodeToAdd, 2);
    }

    @Test
    public void testAddAtNegativeIndex() throws Exception {
        Node inputList = createListFromArray(new int[]{1});
        Node nodeToAdd = new Node(2, null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Index can not be negative");
        ListUtils.addAtIndex(inputList, nodeToAdd, -1);
    }

    @Test
    public void testAddAtIndexInNullList() throws Exception {
        Node nodeToDelete = new Node(22, null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List can not be null");
        ListUtils.deleteElement(null, nodeToDelete);
    }


}
