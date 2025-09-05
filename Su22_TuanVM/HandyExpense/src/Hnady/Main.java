package Hnady;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Expenses> le = new ArrayList<>();
        int id = 1;
        while (true) {
            System.out.println("=======Handy Expense program=======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = InputChoice();
            switch (choice) {
                case 1:
                    addExpense(le, id);
                    id++;
                    break;
                case 2:
                    displayExpense(le);
                    break;
                case 3:
                    deleteExpense(le);
                    break;
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
                    System.out.println("Enter number from (1 -> 4) again !!!");
                    cout = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 4) !!!");
                cout = true;
            }
        }
        return choice;
    }


    static Date InputDate(String format) {
        Date date = null;
        while (true) {
            try {
                String value = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                date = sdf.parse(value);
                Date now = new Date();
                if (date.after(now)) {
                    System.out.println("khong dc lon hon hien tai");
                    continue;
                }
                if (value.equalsIgnoreCase(sdf.format(date))) {
                    return date;
                } else {
                    System.out.println("Date is not valid");
                    System.out.print("Date: ");
                }
            } catch (ParseException e) {
                System.out.println("Enter date like the following format");
                System.out.print("Enter Date: ");
            }
        }
    }


    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Re-input");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Re-input");
            }
        }
    }

    public static boolean checkDuplicate(ArrayList<Expenses> lt, String date, double amount,
                                         String content) {
        //check task first to last list worker  worker exist or not
        for (Expenses expense : lt) {
            if (
                    date.equalsIgnoreCase(expense.getDate())
                            && amount == expense.getAmount()
                            && content.equalsIgnoreCase(expense.getContent())
            ) {
                return false;
            }
        }
        return true;
    }

    private static void addExpense(ArrayList<Expenses> le, int id) {
        while (true) {
            System.out.print("Enter Date: ");
            Date dateinput = InputDate("dd-MM-yyyy");
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
            String date = dateformat.format(dateinput);
            System.out.print("Enter Amount: ");
            double amount = checkInputDouble();
            System.out.print("Enter Content: ");
            String content = checkInputString();
            if (!checkDuplicate(le, date, amount, content)) {
                System.out.println("Duplicate.");
                System.out.println("");
            } else {
                le.add(new Expenses(id, date, amount, content));
                System.out.println("Add Successful !!!.");
                System.out.println("");
                break;
            }
        }
    }

    private static void displayExpense(ArrayList<Expenses> le) {
        if (le.size() == 0) {
            System.out.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(),
                    le.get(i).getAmount(), le.get(i).getContent());
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    private static int checkIdExist(ArrayList<Expenses> le, int id) {
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private static void deleteExpense(ArrayList<Expenses> le) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        int checkIdExist = checkIdExist(le, id);
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            System.out.println("Delete an expense successful");

        } else {
            System.out.println("Delete an expense fail");
        }
    }
}
