package com.maiakov.listmanipulation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static com.maiakov.listmanipulation.common.CreateListFactory.*;
public class ListUtilsAddLastTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAddLastInLongList() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2, 3, 4});
        Node nodeToAdd = new Node(5, null);
        Node actualResult = ListUtils.addLast(inputList, nodeToAdd);
        Node expectedList = createListFromArray(new int[]{1, 2, 3, 4, 5});
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testAddLastInOneElementList() throws Exception {
        Node inputList = createListFromArray(new int[]{1});
        Node nodeToAdd = new Node(2, null);
        Node actualResult = ListUtils.addLast(inputList, nodeToAdd);
        Node expectedList = createListFromArray(new int[]{1, 2});
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testAddLastInNullList() throws Exception {
        Node nodeToDelete = new Node(22, null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List can not be null");
        ListUtils.deleteElement(null, nodeToDelete);
    }

}