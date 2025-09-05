package com.ts.utils;


import java.util.List;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);


    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty, please try again!");
        }
    }

    public static String getSemester(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty, please try again!");
                continue;
            }

            return input;
        }
    }

    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input, please enter number between " + min + " and " + max);
        }
    }

    public static String getCourse() {

        while (true) {
            System.out.print("Enter Course (Java, .Net, C/C++): ");
            String c = sc.nextLine().trim();
            if (!List.of("java", "c/c++", ".net").contains(c.toLowerCase())) {

                System.out.println("Course is not valid!");
                continue;
            }

            return c;
        }
    }

    public static String getYesNo(String msg) {
        while (true) {
            System.out.print(msg);
            String ans = sc.nextLine().trim();
            if (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("N")) {
                return ans;
            }
            System.out.println("Please enter Y or N.");
        }
    }
}




//            if (!List.of("spring", "fall", "summer").contains(input.toLowerCase())) {
//                System.out.println("Semester is not valid!");
//                continue;
//            }