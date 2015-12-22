package com.maiakov.treebuilder.model;

public class Tree {
    String label;
    Tree left;
    Tree right;

    public Tree(String label, Tree left, Tree right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (label != null ? !label.equals(tree.label) : tree.label != null) return false;
        if (left != null ? !left.equals(tree.left) : tree.left != null) return false;
        if (right != null ? !right.equals(tree.right) : tree.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "label='" + label + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
