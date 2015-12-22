package com.maiakov.finddepth;

public class CreateTreeFactory {
    public static Node createRandomTreeWithDepth4() {
        Node nodeR6 = new Node(null, null, 9);
        Node nodeR5 = new Node(null, nodeR6, 8);
        Node nodeL4 = new Node(null, nodeR5, 7);

        Node nodeR3 = new Node(nodeL4, null, 6);
        Node nodeL3 = new Node(null, null, 5);

        Node nodeR2 = new Node(nodeL3, nodeR3, 4);
        Node nodeL2 = new Node(null, null, 3);

        Node nodeR1 = new Node(null, null, 2);
        Node nodeL1 = new Node(nodeL2, nodeR2, 1);

        Node root = new Node(nodeL1, nodeR1, 0);
        return root;
    }

    public static Node createTreeWithDepth4WithOnlyLeftChilds() {
        Node nodeL4 = new Node(null, null, 7);

        Node nodeL3 = new Node(nodeL4, null, 5);

        Node nodeL2 = new Node(nodeL3, null, 3);

        Node nodeL1 = new Node(nodeL2, null, 1);

        Node root = new Node(nodeL1, null, 0);
        return root;
    }

    public static Node createTreeWithDepth4WithOnlyRightChilds() {
        Node nodeR4 = new Node(null, null, 7);

        Node nodeR3 = new Node(null, nodeR4, 6);

        Node nodeR2 = new Node(null, nodeR3, 4);

        Node nodeR1 = new Node(null, nodeR2, 2);

        Node root = new Node(null, nodeR1, 0);
        return root;
    }
    public static Node createTreeWithDepth2WithSameLeftAndRightChilds() {
        Node nodeL2_2 = new Node(null, null, 7);
        Node nodeR2_2 = new Node(null, null, 5);

        Node nodeL2_1 = new Node(null, null, 3);
        Node nodeR2_1 = new Node(null, null, 4);

        Node nodeL1_1 = new Node(nodeL2_1, nodeR2_1, 1);
        Node nodeR1_1 = new Node(nodeL2_2, nodeR2_2, 2);

        Node root = new Node(nodeL1_1, nodeR1_1, 0);
        return root;
    }
    public static Node createTreeWithDepth1() {
        Node nodeL1 = new Node(null, null, 1);
        Node root = new Node(nodeL1, null, 0);
        return root;
    }
}
