package com.ts.utils;

import com.ts.service.WorkerService;

import java.util.Scanner;

public class InputUtils {
    private static Scanner sc = new Scanner(System.in);
    public static String inputUniqueId(String msg, WorkerService service) {
        String id;
        while (true) {
            System.out.print(msg);
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Code cannot be empty.");
                continue;
            }
            if (service.existsWorkerId(id)) {
                System.out.println("Code already exists. Please enter another.");
                continue;
            }
            break;
        }
        return id;
    }

    public static String inputExistingId(String msg, WorkerService service) {
        String id;
        while (true) {
            System.out.print(msg);
            id = sc.nextLine().trim();
            if (!service.existsWorkerId(id)) {
                System.out.println("Worker ID not found. Please enter again.");
                continue;
            }
            break;
        }
        return id;
    }

    public static String inputString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static int inputAge(String msg) {
        int age;
        while (true) {
            try {
                System.out.print(msg);
                age = Integer.parseInt(sc.nextLine());
                if (age < 18 || age > 50) {
                    System.out.println("Age must be between 18 and 50.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
        return age;
    }

    public static int inputChoice(String msg) {
        int choice;
        while (true) {
            try {
                System.out.print(msg);
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("Choice must be between 1 and 5.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
        return choice;
    }

    public static double inputPositiveDouble(String msg) {
        double value;
        while (true) {
            try {
                System.out.print(msg);
                value = Double.parseDouble(sc.nextLine());
                if (value <= 0) {
                    System.out.println("Value must be greater than 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
        return value;
    }



    public static int inputSalary(String msg) {
        int salary;
        while (true) {
            try {
                System.out.print(msg);
                salary = Integer.parseInt(sc.nextLine());
                if(salary < 0 ) {
                    System.out.println("Salary must be greater than 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
        return salary;
    }
}
