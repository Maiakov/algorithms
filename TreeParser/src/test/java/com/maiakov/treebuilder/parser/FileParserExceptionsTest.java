package com.maiakov.treebuilder.parser;

import com.maiakov.treebuilder.exception.EmptyFileException;
import com.maiakov.treebuilder.exception.FileParserException;
import com.maiakov.treebuilder.exception.InvalidLabelException;
import com.maiakov.treebuilder.exception.TreeBuilderException;
import com.maiakov.treebuilder.model.Tree;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class FileParserExceptionsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testBuildTree_fileIsEmpty() throws Exception {
        expectedException.expect(EmptyFileException.class);
        expectedException.expectMessage("Input data file can not be empty.");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("empty_file.txt");
        FileParser.buildTree(new InputStreamReader(resourceAsStream));
    }

    @Test
    public void testBuildTree_withIllegalLabel() throws Exception {
        expectedException.expect(InvalidLabelException.class);
        expectedException.expectMessage("Incorrect label found: Fox3 Label must be combination of uppercase and lowercase English letters.");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_illegal_label.txt");
        FileParser.buildTree(new InputStreamReader(resourceAsStream));
    }

    @Test
    public void testBuildTree_whenTreeNotBinary() throws Exception {
        expectedException.expect(FileParserException.class);
        expectedException.expectMessage("Input data file incorrect.");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("not_binary_tree.txt");
        FileParser.buildTree(new InputStreamReader(resourceAsStream));
    }

    @Test
    public void testBuildTree_whenExistsAloneNode() throws Exception {
        expectedException.expect(TreeBuilderException.class);
        expectedException.expectMessage("Input data can not be represented as Tree.");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_alone_node.txt");
        FileParser.buildTree(new InputStreamReader(resourceAsStream));
    }

    @Test
    public void testBuildTree_withEmptyNode() throws Exception {
        expectedException.expect(FileParserException.class);
        expectedException.expectMessage("Input data file incorrect.");
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("tree_with_empty_node.txt");
        FileParser.buildTree(new InputStreamReader(resourceAsStream));
    }
}