package com.ts.utils;

import com.ts.service.WorkerService;

public class Validator {


    public static boolean validateInputUniqueId(String id, WorkerService service) {
        if (id.isEmpty()) {
            System.out.println("Code cannot be empty.");
            return false;
        }
        if (service.existsWorkerId(id)) {
            System.out.println("Code already exists. Please enter another.");
            return false;
        }
        return true;
    }

    public static boolean validateExistingId(String id, WorkerService service) {
        if (!service.existsWorkerId(id)) {
            System.out.println("Worker ID not found. Please enter again.");
            return false;
        }
        return true;
    }

    public static boolean validateInputString(String value) {
        if (value.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return false;
        }
        return true;
    }

    public static boolean validateInputAge(int age) {
        try {
            if (age < 18 || age > 50) {
                System.out.println("Age must be between 18 and 50.");
                return false;

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again.");
            return false;

        }
        return true;
    }

    public static boolean validateinputChoice(int choice) {
        try {
            if (choice < 1 || choice > 5) {
                System.out.println("Choice must be between 1 and 5.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again.");
            return false;
        }
        return true;
    }

    public static boolean validatePositiveDouble(double value) {
        try {
            if (value <= 0) {
                System.out.println("Value must be greater than 0.");
                return false;

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again.");
            return false;

        }
        return true;
    }


    public static boolean validateInputSalary(double salary) {
        try {
            if (salary < 0) {
                System.out.println("Salary must be greater than 0.");
                return false;

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, try again.");
            return false;

        }
        return true;
    }
}
