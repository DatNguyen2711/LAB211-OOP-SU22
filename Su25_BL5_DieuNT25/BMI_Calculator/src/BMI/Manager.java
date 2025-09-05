package BMI;

import utils.Validator;

import java.util.Scanner;

import java.text.DecimalFormat;

public class Manager {
    static Scanner sc = new Scanner(System.in);

    static void menu() {
        System.out.println("========= Calculator Program =========\n" +
                "1. Normal Calculator\n" +
                "2. BMI Calculator\n" +
                "3. Exit\n" +
                "Please choice one option:");
    }

    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "STANDARD";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }


    // allow user calculator normal

    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double memory;
        System.out.print("Enter number: ");
        memory = Validator.checkInputDouble();


        DecimalFormat df = new DecimalFormat("#,##0.############################");
        df.setMaximumFractionDigits(30);
        while (true) {
            System.out.print("Enter operator: ");
            String operator = Validator.checkInputOperator();

            double tempResult = memory;

            switch (operator) {
                case "+":
                    tempResult = memory + Validator.inputNumber();
                    break;
                case "-":
                    tempResult = memory - Validator.inputNumber();
                    break;
                case "*":
                    tempResult = memory * Validator.inputNumber();
                    break;
                case "/":
                    try {
                        tempResult = memory / Validator.checkNumberZero();
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case "^":
                    tempResult = Math.pow(memory, Validator.inputNumber());
                    break;
                case "=":
                    System.out.println("Result: " + df.format(normalizeZero(memory)));
                    System.out.println("");
                    return;
                default:
                    System.out.println("Unknown operator!");
                    continue;
            }

            // Kiểm tra overflow hoặc NaN
            if (Double.isInfinite(tempResult)) {
                System.out.println("Error: Result too large for double! Operation skipped.");
                continue;
            }
            if (Double.isNaN(tempResult)) {
                System.out.println("Error: Invalid calculation (NaN)! Operation skipped.");
                continue;
            }

            memory = tempResult;

            // Làm tròn các giá trị gần 0 về 0
            memory = normalizeZero(memory);

            // In kết quả
            System.out.println("Memory: " + df.format(memory));
        }
    }

    // Hàm bỏ dấu âm của 0 và làm tròn về 0 nếu quá nhỏ
    private static double normalizeZero(double value) {
        if (Math.abs(value) < 1e-15) {
            return 0.0;
        }
        return value;
    }


    //allow user enter weight
    static double inputcheck_weight() {
        boolean cout = false;
        double result = 0;
        while (cout = true) {
            try {
                result = Double.parseDouble(sc.nextLine());
                if (result <= 0) {
                    System.out.println("Weight must > 0 !!!");
                    System.out.print("Enter Weight(kg): ");
                    cout = true;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Weight(kg): ");
            }
        }
        return result;
    }


    public static void BMICalculator() {
        System.out.println("----- BMI Calculator -----");
        System.out.print("Enter Weight(kg): ");
        double weight = inputcheck_weight();
        System.out.print("Enter Height(cm): ");
        double height = Validator.inputcheck_height();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
        System.out.println("");
    }
}
