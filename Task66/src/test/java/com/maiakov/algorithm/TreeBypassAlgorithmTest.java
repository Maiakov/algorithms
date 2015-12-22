package com.maiakov.algorithm;

import com.maiakov.algorithm.model.Node;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class TreeBypassAlgorithmTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testBypassInPreOrder_nullTree() {
        expectedException.expectMessage("Root element can not be null");
        expectedException.expect(IllegalArgumentException.class);
        TreeBypassAlgorithm.bypassInPreOrder(null);
    }

    @Test
    public void testBypassInPreOrder_SimpleTree() throws Exception {
        TreeBypassAlgorithm.bypassInPreOrder(TreeFactory.getSimpleTree());
        assertEquals("1 2 3 ", outputStream.toString());
    }

    @Test
    public void testBypassInPreOrder_LeftChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInPreOrder(TreeFactory.getTreeWithOnlyLeftChilds());
        assertEquals("0 1 2 3 4 5 ", outputStream.toString());
    }

    @Test
    public void testBypassInPreOrder_RightChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInPreOrder(TreeFactory.getTreeWithOnlyLeftChilds());
        assertEquals("0 1 2 3 4 5 ", outputStream.toString());
    }

    @Test
    public void testBypassInPreOrder_ComplexTree() throws Exception {
        TreeBypassAlgorithm.bypassInPreOrder(TreeFactory.getComplexTree());
        assertEquals("0 1 2 3 4 5 6 7 ", outputStream.toString());
    }

    @Test
    public void testBypassInOrder_nullTree() {
        expectedException.expectMessage("Root element can not be null");
        expectedException.expect(IllegalArgumentException.class);
        TreeBypassAlgorithm.bypassInOrder(null);
    }

    @Test
    public void testBypassInOrder_SimpleTree() throws Exception {
        TreeBypassAlgorithm.bypassInOrder(TreeFactory.getSimpleTree());
        assertEquals("2 1 3 ", outputStream.toString());
    }

    @Test
    public void testBypassInOrder_LeftChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInOrder(TreeFactory.getTreeWithOnlyLeftChilds());
        assertEquals("5 4 3 2 1 0 ", outputStream.toString());
    }

    @Test
    public void testBypassInOrder_RightChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInOrder(TreeFactory.getTreeWithOnlyRightChilds());
        assertEquals("0 1 2 3 4 5 ", outputStream.toString());
    }

    @Test
    public void testBypassInOrder_ComplexTree() throws Exception {
        TreeBypassAlgorithm.bypassInOrder(TreeFactory.getComplexTree());
        assertEquals("2 1 4 3 5 0 6 7 ", outputStream.toString());
    }

    @Test
    public void testBypassInPostOrder_nullTree() {
        expectedException.expectMessage("Root element can not be null");
        expectedException.expect(IllegalArgumentException.class);
        TreeBypassAlgorithm.bypassInPostOrder(null);
    }

    @Test
    public void testBypassInPostOrder_SimpleTree() throws Exception {
        TreeBypassAlgorithm.bypassInPostOrder(TreeFactory.getSimpleTree());
        assertEquals("2 3 1 ", outputStream.toString());
    }

    @Test
    public void testBypassInPostOrder_LeftChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInPostOrder(TreeFactory.getTreeWithOnlyLeftChilds());
        assertEquals("5 4 3 2 1 0 ", outputStream.toString());
    }

    @Test
    public void testBypassInPostOrder_RightChildsTree() throws Exception {
        TreeBypassAlgorithm.bypassInPostOrder(TreeFactory.getTreeWithOnlyRightChilds());
        assertEquals("5 4 3 2 1 0 ", outputStream.toString());
    }

    @Test
    public void testBypassInPostOrder_ComplexTree() throws Exception {
        TreeBypassAlgorithm.bypassInPostOrder(TreeFactory.getComplexTree());
        assertEquals("2 4 5 3 1 7 6 0 ", outputStream.toString());
    }

}