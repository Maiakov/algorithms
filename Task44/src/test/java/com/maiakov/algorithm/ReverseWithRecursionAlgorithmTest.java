package com.maiakov.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ReverseWithRecursionAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testReverseAlgorithmWithNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input list can`t be null");
        ReverseWithRecursionAlgorithm.reverse(null);
    }

    @Test
    public void testReverseWithOneElement() throws Exception {
        Node inputList = new Node(1, null);
        Node actualResult = ReverseWithRecursionAlgorithm.reverse(inputList);
        assertEquals(inputList,actualResult);
    }
    @Test
    public void testReverseWithLongList() throws Exception {
        Node inputList = prepareInputList();
        Node expectedList = prepareExpectedList();
        Node actualResult = ReverseWithRecursionAlgorithm.reverse(inputList);

        assertEquals(expectedList, actualResult);
    }

    private Node prepareInputList() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        return node1;
    }


    private Node prepareExpectedList() {
        Node expNode5 = new Node(1, null);
        Node expNode4 = new Node(2, expNode5);
        Node expNode3 = new Node(3, expNode4);
        Node expNode2 = new Node(4, expNode3);
        Node expNode1 = new Node(5, expNode2);
        return expNode1;
    }
}