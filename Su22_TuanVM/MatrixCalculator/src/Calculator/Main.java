package Calculator;

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
            //user choice one option
            int choice = InputChoice();
            switch (choice) {
                //Addition 2 matrix
                case 1:
                    System.out.println("-----Addition-----");
                    m1 = InputMatrix1(1);
                    m2 = InputMatrix2(m1, 2);
                    Addition(m1, m2);
                    break;
                //Subtraction 2 matrix
                case 2:
                    System.out.println("-----Subtraction-----");
                    m1 = InputMatrix1(1);
                    m2 = InputMatrix2(m1, 2);
                    Subtraction(m1, m2);
                    break;
                //Multiplication 2 matrix
                case 3:
                    System.out.println("-----Multiplication-----");
                    m1 = InputMatrix1(1);
                    m2 = InputMatrix2_mul(m1, 2);
                    Multiplication(m1, m2);
                    break;
                //Quit the program
                case 4:
                    return;
            }
        }
    }

    static int InputChoice() {
        int choice = 0;
        boolean cout = false;
        while (cout = true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice > 0 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Enter number from (1 -> 3) again !!!");
                    cout = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 3) !!!");
                cout = true;
            }
        }
        return choice;
    }

    static int InputRow(String mes) {
        System.out.print("Enter Row Matrix:");
        int inputsize = 0;
        boolean cout = false;
        while (cout = true) {
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
                cout = true;
            }
        }
        return inputsize;
    }


    static int InputColumn(String mes) {
        System.out.print("Enter Column Matrix:");
        int inputsize = 0;
        boolean cout = false;
        while (cout = true) {
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
                cout = true;
            }
        }
        return inputsize;
    }


    static int[][] InputMatrix1(int n) {
        int row = InputRow("Enter Row Matrix" + n + ":");
        int col = InputColumn("Enter Column Matrix" + n + ":");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = checkInputInt(i, j, n);
            }
        }
        return matrix;
    }

    private static int checkInputInt(int i, int j, int n) {
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

    static int[][] InputMatrix2(int[][] m1, int n) {
        int row = InputRow("Enter Row Matrix" + n + ":");
        int col = InputColumn("Enter Column Matrix" + n + ":");
        int[][] matrix2 = new int[row][col];
        int row1 = m1.length;
        int col1 = m1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        while (true) {
            if ((row1 != row2 || col1 != col2)) {
                System.out.println("Row and column must be equal to matrix 1");
                row = InputRow("Enter Row Matrix" + n + ":");
                col = InputColumn("Enter Column Matrix" + n + ":");
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

    static int[][] InputMatrix2_mul(int[][] m1, int n) {
        int row = InputRow("Enter Row Matrix" + n + ":");
        int col = InputColumn("Enter Column Matrix" + n + ":");
        int[][] matrix2 = new int[row][col];
        int row1 = m1.length;
        int col1 = m1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        while (true) {
            if ((col1 != row2)) {
                System.out.println("Row and column must be equal to matrix 1");
                row = InputRow("Enter Row Matrix" + n + ":");
                col = InputColumn("Enter Column Matrix" + n + ":");
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
        //traverse from first element of row to last element of row of matrix 1
        for (int i = 0; i < row1; i++) {
            //traverse from first element of column to last element of column of matrix 2
            for (int j = 0; j < col2; j++) {
                //traverse from first element of row to last element of row of matrix 1
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
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
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
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row1; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col1; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }
}
