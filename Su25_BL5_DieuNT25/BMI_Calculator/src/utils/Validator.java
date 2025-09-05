package utils;

import java.util.Scanner;

public class Validator {
    static Scanner sc = new Scanner(System.in);

    public static int InputChoice() {
        int choice = 0;
        boolean cout = false;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice > 0 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Enter number from (1 -> 3) again !!!");
                    cout = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 3) !!!");
                cout = true;
            }
        } while (cout = true);
        return choice;
    }

    //allow user input number in normal calculator
    public static double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Enter number again !!!");
                System.out.print("Enter number: ");
            }
        }

    }
    public static double checkNumberZero() {
        while (true) {
            try {
                System.out.print("Enter number: ");
                double result = Double.parseDouble(sc.nextLine());

                if (result == 0) {
                    throw new ArithmeticException("Cannot divide by 0!");
                }

                return result; // nếu hợp lệ thì trả về
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //allow user input operator
    public static String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equals("+") || result.equals("-")
                    || result.equals("*") || result.equals("/")
                    || result.equals("^") || result.equals("=")) {
                return result;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
                System.out.print("Enter Operator: ");
            }
        }
    }


    public static double inputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }

    // allow user enter height
    public static double inputcheck_height() {
        boolean cout = false;
        double result = 0;
        while (cout = true) {
            try {
                result = Double.parseDouble(sc.nextLine());
                if (result <= 0) {
                    System.out.println("Weight must > 0 !!!");
                    System.out.print("Enter Height(cm): ");
                    cout = true;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Height(cm): ");
            }
        }
        return result;
    }
}
