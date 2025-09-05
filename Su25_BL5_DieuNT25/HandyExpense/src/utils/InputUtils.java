package utils;

import services.ExpenseService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, boolean isInputChoice) {
        while (true) {
            System.out.print(msg + ": ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (isInputChoice && (input < 1 || input > 4)) {
                    System.out.println("Please enter a number between 1 and 4");
                } else if (!isInputChoice && input < 0) {
                    System.out.println("Input cannot be negative");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    public static double getDouble(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            try {
                double input = Double.parseDouble(sc.nextLine());
                if (input <= 0) {
                    System.out.println("Input must be positive number");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static String getNonEmptyString(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Value cannot be empty!");
        }
    }

    public static String getValidDate(String msg) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;

        while (true) {
            try {
                System.out.print(msg + " (dd-MM-yyyy): ");
                String input = sc.nextLine().trim();
                date = LocalDate.parse(input, inputFormat);

                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Date cannot be in the future! Please enter again.");
                    continue;
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please use dd-MM-yyyy.");
            }
        }
        return formatDisplayDate(date);
    }


    public static String formatDisplayDate(LocalDate date) {
        DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        return date.format(displayFormat);
    }

    public static int inputExpenseID(String msg, ExpenseService expenseService) {
        System.out.print(msg);
        while (true) {
            System.out.print("Enter ID: ");
            int input = Integer.parseInt(sc.nextLine());
            if (expenseService.isExisted(input)) {
                return input;
            } else {
                System.out.println("Expense ID does not exist!");
            }
        }
    }
}
