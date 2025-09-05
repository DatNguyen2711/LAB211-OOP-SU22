package mananager;

import utils.InputHelper;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int[][] m1;
            int[][] m2;
            System.out.println("======Calculator program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.println("Your choice: ");
            int choice = InputHelper.inputChoice();
            switch (choice) {
                case 1:
                    System.out.println("-----Addition-----");
                    m1 = InputHelper.inputMatrix1(1);
                    m2 = InputHelper.inputMatrix2(m1, 2);
                    Addition(m1, m2);
                    break;
                case 2:
                    System.out.println("-----Subtraction-----");
                    m1 = InputHelper.inputMatrix1(1);
                    m2 = InputHelper.inputMatrix2(m1, 2);
                    Subtraction(m1, m2);
                    break;
                case 3:
                    System.out.println("-----Multiplication-----");
                    m1 = InputHelper.inputMatrix1(1);
                    m2 = InputHelper.inputMatrix2Mul(m1, 2);
                    Multiplication(m1, m2);
                    break;
                case 4:
                    return;
            }
        }
    }


    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }


    static void Multiplication(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(result);
    }

    static void Addition(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    static void Subtraction(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }
}