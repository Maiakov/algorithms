package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ReverseWithCycleAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testReverseAlgorithmWithNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input list can`t be null");
        ReverseWithCycleAlgorithm.reverse(null);
    }

    @Test
    public void testReverseWithOneElement() throws Exception {
        Node inputList = new Node(1, null);
        Node actualResult = ReverseWithCycleAlgorithm.reverse(inputList);
        assertEquals(inputList, actualResult);
    }

    @Test
    public void testReverseWithTwoElement() throws Exception {
        Node inputList = prepareInputListWith2Elements();
        Node expectedList = prepareExpectedListWith2Elements();

        Node actualResult = ReverseWithCycleAlgorithm.reverse(inputList);
        assertEquals(expectedList.toString(), actualResult.toString());
    }

    @Test
    public void testReverseWithLongList() throws Exception {
        Node inputList = prepareInputListWith5Elements();
        Node expectedList = prepareExpectedListWith5Elements();
        Node actualResult = ReverseWithCycleAlgorithm.reverse(inputList);

        assertEquals(expectedList.toString(), actualResult.toString());
    }

    private Node prepareInputListWith5Elements() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        return node1;
    }


    private Node prepareExpectedListWith5Elements() {
        Node expNode5 = new Node(1, null);
        Node expNode4 = new Node(2, expNode5);
        Node expNode3 = new Node(3, expNode4);
        Node expNode2 = new Node(4, expNode3);
        Node expNode1 = new Node(5, expNode2);
        return expNode1;
    }

    private Node prepareInputListWith2Elements() {
        Node node2 = new Node(2, null);
        Node node1 = new Node(1, node2);
        return node1;
    }


    private Node prepareExpectedListWith2Elements() {
        Node expNode2 = new Node(1, null);
        Node expNode1 = new Node(2, expNode2);
        return expNode1;
    }
}