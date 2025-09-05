package utils;

import service.ManageEastAsiaCountries;

import java.util.Scanner;

public class InputHelper {
    // Single shared scanner (do not close)
    private static final Scanner sc = new Scanner(System.in);

    public static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("This field cannot be empty. Please re-enter!");
        }
    }


    /**
     * Country name: letters (Unicode) and spaces only
     */
    public static String readCountryName(String prompt, ManageEastAsiaCountries manageEastAsiaCountries) {
        while (true) {
            System.out.print(prompt);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Country name cannot be empty. Please re-enter!");
                continue;
            }
            if (!name.matches("^[\\p{L}\\s]+$")) {
                System.out.println("Country name must contain only letters and spaces. Please re-enter!");
                continue;
            }
            if (manageEastAsiaCountries.isExistedCountryName(name)) {
                System.out.println("Country name already exists! Please re-enter!");
                continue;
            }
            return name;
        }
    }

    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(raw);
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a number between %d and %d.%n", min, max);
            }
        }
    }

    public static float readPositiveFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine().trim();
            try {
                float f = Float.parseFloat(raw);
                if (f <= 0) throw new NumberFormatException();
                return f;
            } catch (NumberFormatException e) {
                System.out.println("Value must be a number greater than 0. Please re-enter!");
            }
        }
    }

    public static String inputCountryCode(String prompt, ManageEastAsiaCountries service) {
        while (true) {
            System.out.print(prompt);
            String code = sc.nextLine().trim();
            if (code.isEmpty()) {
                System.out.println("Country code cannot be empty. Please re-enter!");
                continue;
            }
            if (!code.matches("^[\\p{L}\\s]+$")) {
                System.out.println("Country code must contain only letters and spaces. Please re-enter!");
                continue;
            }

            if (service.isExistedCountryCode(code)) {
                System.out.println("Country already exists! Please re-enter!");
                continue;
            }

            return code;
        }
    }
}
