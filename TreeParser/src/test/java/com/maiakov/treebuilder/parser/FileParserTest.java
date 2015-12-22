package com.maiakov.treebuilder.parser;

import com.maiakov.treebuilder.exception.EmptyFileException;
import com.maiakov.treebuilder.exception.FileParserException;
import com.maiakov.treebuilder.exception.InvalidLabelException;
import com.maiakov.treebuilder.exception.TreeBuilderException;
import com.maiakov.treebuilder.model.Tree;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class FileParserTest {

    @Test
    public void testBuildTree_withOneNode() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("one_node_tree.txt");
        Tree actualTree = FileParser.buildTree(new InputStreamReader(resourceAsStream));
        assertEquals(new Tree("Fox", null, null), actualTree);
    }

    @Test
    public void testBuildTree_withThreeNode() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_three_nodes.txt");
        Tree actualTree = FileParser.buildTree(new InputStreamReader(resourceAsStream));
        Tree the = new Tree("The", null, null);
        Tree lazy = new Tree("Lazy", null, null);
        Tree root = new Tree("Fox", the, lazy);
        assertEquals(root, actualTree);
    }

    @Test
    public void testBuildTree_withOnlyLeftChild() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_left_child.txt");
        Tree actualTree = FileParser.buildTree(new InputStreamReader(resourceAsStream));
        Tree root = getTreeWithLeftChild();
        assertEquals(root, actualTree);
    }

    @Test
    public void testBuildTree_withOnlyRightChild() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_right_child.txt");
        Tree actualTree = FileParser.buildTree(new InputStreamReader(resourceAsStream));
        Tree root = getTreeWithRightChild();
        assertEquals(root, actualTree);
    }

    @Test
    public void testBuildTree_fromTaskExample() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("example_tree.txt");
        Tree actualTree = FileParser.buildTree(new InputStreamReader(resourceAsStream));
        assertEquals(prepareTreeFromExample(), actualTree);
    }

    private Tree prepareTreeFromExample() {
        Tree the = new Tree("The", null, null);
        Tree lazy = new Tree("Lazy", null, null);
        Tree fox = new Tree("Fox", the, lazy);

        Tree dog = new Tree("Dog", null, null);

        Tree jumps = new Tree("Jumps", dog, null);
        Tree quick = new Tree("Quick", fox, jumps);


        Tree over = new Tree("Over", null, null);
        Tree brown = new Tree("Brown", null, over);

        Tree a = new Tree("A", quick, brown);
        return a;
    }

    private Tree getTreeWithLeftChild() {
        Tree dog = new Tree("Dog", null, null);
        Tree the = new Tree("The", dog, null);
        Tree fox = new Tree("Fox", the, null);
        Tree quick = new Tree("Quick", fox, null);
        return new Tree("A", quick, null);
    }

    private Tree getTreeWithRightChild() {
        Tree dog = new Tree("Dog", null, null);
        Tree the = new Tree("The", null, dog);
        Tree fox = new Tree("Fox", null, the);
        Tree quick = new Tree("Quick", null, fox);
        return new Tree("A", null, quick);
    }
}