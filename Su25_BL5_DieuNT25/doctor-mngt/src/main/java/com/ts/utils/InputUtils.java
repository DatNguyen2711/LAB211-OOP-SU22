package com.ts.utils;

import com.ts.service.DoctorService;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);
    // regex nghĩa là: DOC luôn phải đứng đu sau đó có 1 dấu cách (là chữ s nghĩa là space) sau đó là 1 số nguyên (chữ d l interger)
    private static final String CODE_FORMAT = "^DOC\\s\\d+$";

    public static String getString(String message) {
        System.out.print(message + ": ");
        return sc.nextLine().trim();
    }

    public static String getNonEmptyString(String message) {
        while (true) {
            System.out.print(message + ": ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Value cannot be empty.");
        }
    }

    public static int inputInt(String message, boolean isAdd) {
        while (true) {
            System.out.print(message + ": ");
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if ((isAdd && value < 0) || (!isAdd && value < -1)) {
                    System.out.println("Value cannot be negative.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    public static int getChoice(String message) {
        while (true) {
            System.out.print(message + ": ");
            String input = sc.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice <= 0 || choice > 5) {
                    System.out.println("Please enter a number between 1 and 5.");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }



    public static String inputDoctorCode(String message, DoctorService doctorService, boolean isAdd) {
        while (true) {
            System.out.print(message + ": ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Value cannot be empty.");
            } else if (!input.matches(CODE_FORMAT)) {
                System.out.println("Code must match the format DOC + number");
            } else if (isAdd && doctorService.isExistCode(input)) {
                System.out.println("Code already exist.");
            } else if (!isAdd && !doctorService.isExistCode(input)) {
                System.out.println("Code does not exist.");
            } else {
                return input;
            }
        }
    }
}
