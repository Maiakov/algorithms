package com.maiakov.listmanipulation;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static com.maiakov.listmanipulation.common.CreateListFactory.*;

public class ListUtilsDeleteByIndexTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDeleteElementsByIndexWhenIndex0() throws Exception {
        Node inputList = createListFromArray(new int[]{1, 2});
        Node actualResult = ListUtils.deleteElement(inputList, 0);
        Node expectedList = createListFromArray(new int[]{2});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementsByIndexWhenIndex2() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4});
        Node actualResult = ListUtils.deleteElement(inputList, 2);
        Node expectedList = createListFromArray(new int[]{0, 1, 3, 4});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testDeleteElementsByIndexWithOneElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0});
        Node actualResult = ListUtils.deleteElement(inputList, 0);
        assertNull(actualResult);
    }

    @Test
    public void testDeleteElementsByIndexWhenIndexOutOfBound() throws Exception {
        Node inputList = createListFromArray(new int[]{0});
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Index out of bound");
        ListUtils.deleteElement(inputList, 1);
    }

    @Test
    public void testDeleteElementsByIndexLastElement() throws Exception {
        Node inputList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        Node actualResult = ListUtils.deleteElement(inputList, 8);
        Node expectedList = createListFromArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7});

        assertEquals(expectedList.toString(), actualResult.toString());
    }

}
