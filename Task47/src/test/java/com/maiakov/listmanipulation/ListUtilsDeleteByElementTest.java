package com.maiakov.listmanipulation;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static com.maiakov.listmanipulation.common.CreateListFactory.createListFromArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListUtilsDeleteByElementTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDeleteFirstElement() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2});
        Node nodeToDelete = new Node(1, null);
        Node actualResult = ListUtils.deleteElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{2});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteLastElement() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2, 3, 4});
        Node nodeToDelete = new Node(4, null);
        Node actualResult = ListUtils.deleteElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{1, 2, 3});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementInTheMiddle() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2, 3, 4});
        Node nodeToDelete = new Node(2, null);
        Node actualResult = ListUtils.deleteElement(inputList, nodeToDelete);
        Node expectedList = createListFromArray(new int[]{1, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementThatDoesNotExists() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2, 3, 4});
        Node nodeToDelete = new Node(22, null);
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage(nodeToDelete + " does not exists in the list");
        ListUtils.deleteElement(inputList, nodeToDelete);
    }

    @Test
    public void testDeleteElementFromNullList() throws Exception {
        Node nodeToDelete = new Node(22, null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List can not be null");
        ListUtils.deleteElement(null, nodeToDelete);
    }
}
