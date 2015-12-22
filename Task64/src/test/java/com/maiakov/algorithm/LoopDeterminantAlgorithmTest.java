package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LoopDeterminantAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private static final int NO_LOOP = -1;


    @Test
    public void testHasLoopWithNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input list can not be null");
        LoopDeterminantAlgorithm.hasLoop(null);
    }

    @Test
    public void testHasLoopWithTwoNodes() throws Exception {
        int indexLoopNode = 0;
        Node listWithLoop = CreateListFactory.createListFromArray(indexLoopNode, 1, 2);
        assertTrue(LoopDeterminantAlgorithm.hasLoop(listWithLoop));
    }

    @Test
    public void testHasLoopWithThreeNodes() throws Exception {
        int indexLoopNode = 1;
        Node listWithLoop = CreateListFactory.createListFromArray(indexLoopNode, 1, 2, 3);
        assertTrue(LoopDeterminantAlgorithm.hasLoop(listWithLoop));
    }

    @Test
    public void testHasLoopWithTenNodes() throws Exception {
        int indexLoopNode = 5;
        Node listWithLoop = CreateListFactory.createListFromArray(indexLoopNode, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertTrue(LoopDeterminantAlgorithm.hasLoop(listWithLoop));
    }

    @Test
    public void testHasLoopWithOneNode() throws Exception {
        int indexLoopNode = NO_LOOP;
        Node listWithLoop = CreateListFactory.createListFromArray(indexLoopNode, 1);
        assertFalse(LoopDeterminantAlgorithm.hasLoop(listWithLoop));
    }

    @Test
    public void testHasLoopWithoutLoop() throws Exception {
        int indexLoopNode = NO_LOOP;
        Node listWithLoop = CreateListFactory.createListFromArray(indexLoopNode, 1, 2, 3, 4, 5, 6);
        assertFalse(LoopDeterminantAlgorithm.hasLoop(listWithLoop));
    }
}