package BMI;

import java.util.Scanner;



public class Manager {
    static Scanner sc = new Scanner(System.in);

    static void menu(){
        System.out.println("========= Calculator Program =========\n" +
                "1. Normal Calculator\n" +
                "2. BMI Calculator\n" +
                "3. Exit\n" +
                "Please choice one option:");
    }

    static int InputChoice(){
        int choice = 0;
        boolean cout =false;
        while (cout=true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 0 && choice <= 3) {
                    break;
                }else  {
                    System.out.println("Enter number from (1 -> 3) again !!!");
                    cout=true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 3) !!!");
                cout=true;
            }
        }
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

    static double checknumberZero(){
        boolean cout=false;
        double result;
        System.out.print("Enter number: ");
        while (true) {
                result = Double.parseDouble(sc.nextLine());
                if(result==0){
                    System.out.println("Enter again cannot divide to 0 !!!");
                    System.out.print("Enter number: ");
                    cout=false;
                }else{
                    return result;
                }
        }
    }

    //allow user calculator normal
    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double memory;
        System.out.print("Enter number: ");
        memory = checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= checknumberZero();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                System.out.println("");
                return;
            }
        }
    }

    //allow user enter weight
    static double inputcheck_weight(){
        boolean cout =false;
        double result=0;
        while (cout=true) {
            try {
                 result = Double.parseDouble(sc.nextLine());
                if(result <=0){
                    System.out.println("Weight must > 0 !!!");
                    System.out.print("Enter Weight(kg): ");
                    cout=true;
                }else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Weight(kg): ");
            }
        }
        return result;
    }

    // allow user enter height
    static double inputcheck_height(){
        boolean cout =false;
        double result=0;
        while (cout=true) {
            try {
                result = Double.parseDouble(sc.nextLine());
                if(result <=0){
                    System.out.println("Weight must > 0 !!!");
                    System.out.print("Enter Height(cm): ");
                    cout=true;
                }else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                System.out.print("Enter Height(cm): ");
            }
        }
        return result;
    }

    public static void BMICalculator(){
        System.out.println("----- BMI Calculator -----");
        System.out.print("Enter Weight(kg): ");
        double weight = inputcheck_weight();
        System.out.print("Enter Height(cm): ");
        double height = inputcheck_height();
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
        System.out.println("");
    }
}
