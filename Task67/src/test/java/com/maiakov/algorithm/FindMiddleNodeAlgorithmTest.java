package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FindMiddleNodeAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFindMiddleNode_WithEmptyList() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Head of list can not be null");
        FindMiddleNodeAlgorithm.findMiddleNode(null);
    }

    @Test
    public void testFindMiddleNode_WithOneNode() throws Exception {

        Node actualResult = FindMiddleNodeAlgorithm.findMiddleNode(createList(1));
        assertEquals(1, actualResult.getValue());
    }

    @Test
    public void testFindMiddleNode_WithTwoNodes() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List does not contain middle element");
        FindMiddleNodeAlgorithm.findMiddleNode(createList(2));

    }

    @Test
    public void testFindMiddleNode_WithThreeNodes() throws Exception {
        Node actualResult = FindMiddleNodeAlgorithm.findMiddleNode(createList(3));
        assertEquals(2, actualResult.getValue());
    }

    @Test
    public void testFindMiddleNode_WithFiveNodes() throws Exception {
        Node actualResult = FindMiddleNodeAlgorithm.findMiddleNode(createList(5));
        assertEquals(3, actualResult.getValue());
    }


    private Node createList(int numberOfElement) {
        Node lastNode = new Node(null, numberOfElement);
        for (int i = numberOfElement - 1; i != 0; i--) {
            Node newNode = new Node(lastNode, i);
            lastNode = newNode;

        }
        return lastNode;
    }
}