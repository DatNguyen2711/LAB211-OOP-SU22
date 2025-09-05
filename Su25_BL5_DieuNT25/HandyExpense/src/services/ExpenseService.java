package services;

import models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();
    private int currentId = 1;

    public void addExpense(String date, double amount, String content) {
        Expense e = new Expense(currentId++, date, amount, content);
        expenses.add(e);
    }
    public List<Expense> getAllExpenses() {
        return expenses;
    }


    public void deleteExpense(int id) {
        for(Expense e: expenses) {
            if(e.getId() == id) {
                expenses.remove(e);
                return;
            }
        }
    }
    public double getTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public boolean isExisted(int id){


        for(Expense e: expenses) {
            if(e.getId() == id) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<Expense> getExpensesWithDate(String date) {
        ArrayList<Expense> expensesWithDate = new ArrayList<>();
        for(Expense e: expenses) {
            if(e.getDate().equals(date)) {
                expensesWithDate.add(e);
            }
        }
        return expensesWithDate;
    }
}
