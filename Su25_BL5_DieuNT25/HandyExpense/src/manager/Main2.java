package manager;

import models.Expense;
import services.ExpenseService;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseService();

        while (true) {
            System.out.println("========= Handy Expense Program =========");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Remove an expense");
            System.out.println("4. Exit");

            int choice = InputUtils.getInt("Your choice", true);
            switch (choice) {
                case 1:
                    System.out.println("----- Add an expense -----");
                    String date = InputUtils.getValidDate("Enter Date");
                    double amount = InputUtils.getDouble("Enter Amount");
                    String content = InputUtils.getNonEmptyString("Enter Content");
                    service.addExpense(date, amount, content);
                    System.out.println("Add successfully");
                    break;

                case 2:
                    System.out.println("----- All expenses -----");
                    List<Expense> list = service.getAllExpenses();
                    if (list.isEmpty()) {
                        System.out.println("No expenses yet!");
                    } else {
                        System.out.printf("%-5s %-15s %-10s %-20s\n", "ID", "Date", "Amount", "Content");
                        for (Expense e : list) {
                            System.out.println(e);
                        }
                        System.out.println("Total: " + service.getTotal());
                    }
                    break;

                case 3:
                    System.out.println("----- Expense same date -----");
                    String sameDate = InputUtils.getValidDate("Enter date:");
                      ArrayList<Expense> samedateExpenseList=  service.getExpensesWithDate(sameDate);

                      for (Expense e : samedateExpenseList) {
                          System.out.print(e.toString());
                      }

//                    service.deleteExpense(id);
//                    System.out.println("Delete an expense successful!");
                    break;


                case 4:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }
}
