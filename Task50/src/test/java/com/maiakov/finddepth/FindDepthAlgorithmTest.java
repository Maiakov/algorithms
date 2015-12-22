package com.maiakov.finddepth;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindDepthAlgorithmTest {
    @Test
    public void testFindDepthInEmptyTree() throws Exception {
        int actualResult = FindDepthAlgorithm.findDepth(null);
        assertEquals(0, actualResult);
    }

    @Test
    public void testFindDepthRandomTree() throws Exception {
        Node root = CreateTreeFactory.createRandomTreeWithDepth4();
        int actualResult = FindDepthAlgorithm.findDepth(root);
        assertEquals(6, actualResult);
    }

    @Test
    public void testFindDepthInSmallTree() throws Exception {
        Node root = CreateTreeFactory.createTreeWithDepth1();
        int actualResult = FindDepthAlgorithm.findDepth(root);
        assertEquals(1, actualResult);
    }

    @Test
    public void testFindDepthWithOnlyLeftChilds() throws Exception {
        Node root = CreateTreeFactory.createTreeWithDepth4WithOnlyLeftChilds();
        int actualResult = FindDepthAlgorithm.findDepth(root);
        assertEquals(4, actualResult);
    }

    @Test
    public void testFindDepthWithOnlyRightChilds() throws Exception {
        Node root = CreateTreeFactory.createTreeWithDepth4WithOnlyRightChilds();
        int actualResult = FindDepthAlgorithm.findDepth(root);
        assertEquals(4, actualResult);
    }
    @Test
    public void testFindDepthWithSameLeftAndRightChilds() throws Exception {
        Node root = CreateTreeFactory.createTreeWithDepth2WithSameLeftAndRightChilds();
        int actualResult = FindDepthAlgorithm.findDepth(root);
        assertEquals(2, actualResult);
    }
}