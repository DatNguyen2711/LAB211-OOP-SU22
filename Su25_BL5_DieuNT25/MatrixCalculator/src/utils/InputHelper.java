package utils;

import java.util.Scanner;

public class InputHelper {
    static Scanner sc = new  Scanner(System.in);
    public static int checkInputInt(int i, int j, int n) {
        while (true) {
            try {
                System.out.print("Enter Matrix" + n + "[" + i + "]" + "[" + j + "]:");
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Value of matrix is digit");
            }
        }
    }

   public static int[][] inputMatrix1(int n) {
        int row = inputRow("Enter Row Matrix 1" + n + ":");
        int col = inputColumn("Enter Column Matrix 1" + n + ":");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = checkInputInt(i, j, n);
            }
        }
        return matrix;
    }


   public static int[][] inputMatrix2(int[][] m1, int n) {
        int row = inputRow("Enter Row Matrix" + n + ":");
        int col = inputColumn("Enter Column Matrix" + n + ":");
        int[][] matrix2 = new int[row][col];
        int row1 = m1.length;
        int col1 = m1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        while (true) {
            if ((row1 != row2 || col1 != col2)) {
                System.out.println("Row and column must be equal to matrix 1");
                row = inputRow("Enter Row Matrix 2" + n + ":");
                col = inputColumn("Enter Column Matrix 2" + n + ":");
                if ((row == row1 && col == col1)) {
                    matrix2 = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            matrix2[i][j] = checkInputInt(i, j, n);
                        }
                    }
                    return matrix2;
                }
            } else {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        matrix2[i][j] = checkInputInt(i, j, n);
                    }
                }
                return matrix2;
            }
        }
    }

    public  static int[][] inputMatrix2Mul(int[][] m1, int n) {
        int row = inputRow("Enter Row Matrix 2" + n + ":");
        int col = inputColumn("Enter Column Matrix 2" + n + ":");
        int[][] matrix2 = new int[row][col];
        int col1 = m1[0].length;
        int row2 = matrix2.length;
        while (true) {
            if ((col1 != row2)) {
                System.out.println("Row of matrix 2 must equal to column of matrix 1 !");
                row = inputRow("Enter Row of Matrix 2" + n + ":");
                //
                col = inputColumn("Enter Column of Matrix 2" + n + ":");
                if (col1 == row) {
                    matrix2 = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            matrix2[i][j] = checkInputInt(i, j, n);
                        }
                    }
                    return matrix2;
                }
            } else {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        matrix2[i][j] = checkInputInt(i, j, n);
                    }
                }
                return matrix2;
            }
        }
    }

    public static int inputChoice() {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice > 0 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Enter number from (1 -> 3) again !!!");
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 3) !!!");
            }
        }
        return choice;
    }

    public  static int inputRow(String mes) {
        System.out.print("Enter Row Matrix:");
        int inputsize = 0;
        while (true) {
            try {
                inputsize = Integer.parseInt(sc.nextLine());
                if (inputsize <= 0) {
                    System.out.println("Row must be > 0 !!!");
                    System.out.print("Enter row matrix : ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer !!!");
                System.out.print("Enter row matrix : ");
            }
        }
        return inputsize;
    }


    public static int inputColumn(String mes) {
        System.out.print("Enter Column Matrix:");
        int inputsize = 0;
        while (true) {
            try {
                inputsize = Integer.parseInt(sc.nextLine());
                if (inputsize <= 0) {
                    System.out.println("Row must be > 0 !!!");
                    System.out.print("Enter column matrix : ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer !!!");
                System.out.print("Enter column matrix : ");
            }
        }
        return inputsize;
    }

}
