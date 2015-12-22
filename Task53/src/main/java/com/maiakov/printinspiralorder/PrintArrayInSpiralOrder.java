package com.maiakov.printinspiralorder;


public class PrintArrayInSpiralOrder {
    private int i;
    private int xSize;
    private int ySize;
    private int column;
    private int row;
    private int[][] matrix;

    public void print(int[][] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            throw new IllegalArgumentException("Input array can not be null");
        }
        xSize = inputArray[0].length;
        ySize = inputArray.length;
        matrix = inputArray;
        spiralPrint();
    }


    public void spiralPrint() {
        xSize--;
        ySize--;
        while (!needBreak()) {
            printFromLeftToRight();

            printFromTopToBottom();

            printFromRigthToLeft();

            printFromBottomToTop();
        }
    }

    private void printFromLeftToRight() {
        for (i = column; i <= xSize; i++) {
            System.out.print(matrix[row][i] + " ");
        }
        row++;
    }

    private void printFromTopToBottom() {
        for (i = row; i <= ySize; i++) {
            System.out.print(matrix[i][xSize] + " ");
        }
        xSize--;
    }

    private void printFromRigthToLeft() {
        for (i = xSize; i >= column; i--) {
            System.out.print(matrix[ySize][i] + " ");
        }
        ySize--;
    }

    private void printFromBottomToTop() {
        for (i = ySize; i >= row; i--) {
            System.out.print(matrix[i][column] + " ");
        }
        column++;
    }


    private boolean needBreak() {
        return row > ySize || column > xSize;
    }

}
