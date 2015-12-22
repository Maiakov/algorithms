package com.maiakov.finddepth;

public class FindDepthAlgorithm {

    private static final int INITIAL_DEPTH = 0;

    public static int findDepth(Node root) {
        if(root == null){
            return 0;
        }
        return findDepth(root, INITIAL_DEPTH);
    }

    private static int findDepth(Node root, int depth) {
        int depthRight = depth;
        int depthLeft = depth;
        if (root.getLeftChild() != null) {
            depthLeft = findDepth(root.getLeftChild(), depth + 1);

        }
        if (root.getRightChild() != null) {
            depthRight = findDepth(root.getRightChild(), depth + 1);

        }
        return getMax(depthLeft, depthRight);
    }

    private static int getMax(int depthLeft, int depthRight) {
        return depthLeft > depthRight ? depthLeft : depthRight;
    }

}

