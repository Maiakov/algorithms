package com.maiakov.treebuilder.parser;

import com.maiakov.treebuilder.TreeBuilder;
import com.maiakov.treebuilder.exception.EmptyFileException;
import com.maiakov.treebuilder.exception.FileParserException;
import com.maiakov.treebuilder.exception.InvalidLabelException;
import com.maiakov.treebuilder.model.Tree;

import java.io.*;
import java.util.Arrays;

public class FileParser {
    public static final String EMPTY_NODE_SIGN = "#";
    private static final String WORDS_DELIMITER = ",";
    private static final String LABEL_PATTERN = "[a-zA-Z]+|" + EMPTY_NODE_SIGN;
    private static TreeBuilder treeBuilder;

    public static Tree buildTree(InputStreamReader inputStreamReader) {
        treeBuilder = new TreeBuilder();
        parseFile(inputStreamReader);
        return treeBuilder.build();
    }

    private static void parseFile(InputStreamReader inputStreamReader) {
        boolean isFileEmpty = true;
        try (BufferedReader br = new BufferedReader(inputStreamReader)) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                isFileEmpty = false;
                String[] nodes = strLine.split(WORDS_DELIMITER);
                if (nodes.length != 3) {
                    throw new FileParserException();
                }
                validate(nodes);
                treeBuilder.addNodes(nodes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isFileEmpty) {
            throw new EmptyFileException();
        }
    }

    private static void validate(String[] nodes) {
        Arrays.stream(nodes).forEach(
                s -> {
                    if (s.isEmpty()) {
                        throw new FileParserException();
                    } else if (!s.matches(LABEL_PATTERN)) {
                        throw new InvalidLabelException(s);
                    }
                });
    }

}
