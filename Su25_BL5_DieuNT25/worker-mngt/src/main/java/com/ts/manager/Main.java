package com.ts.manager;

import com.ts.entity.Worker;
import com.ts.service.WorkerService;
import com.ts.utils.InputUtils;
import com.ts.utils.Validator;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static WorkerService service = new WorkerService();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            menu();
            int choice = InputUtils.inputChoice("Choose: ");
            switch (choice) {
                case 1 -> addWorker();
                case 2 -> changeSalary(true);
                case 3 -> changeSalary(false);
                case 4 -> displayHistory();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void menu() {
        System.out.println("\n===== Worker Management =====");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.println("==============================");
    }

//    private static void addWorker() {
//        System.out.println("\n--- Add Worker ---");
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//
//            String id = sc.nextLine();
//            if(!Validator.validateInputUniqueId(id,service)){
//
//            }
//        }
//
//        String name = InputUtils.inputString("Enter Name: ");
//        int age = InputUtils.inputAge("Enter Age: ");
//        double salary = InputUtils.inputSalary("Enter Salary: ");
//        String location = InputUtils.inputString("Enter work location: ");
//
//        service.addWorker(new Worker(id, name, age, salary, location));
//        System.out.println("Worker added successfully.");
//    }

    private static void addWorker() {
        System.out.println("\n--- Add Worker ---");
        String id;
        String name;
        int age;
        double salary;
        String location;

        // Input ID
        while (true) {
            System.out.print("Enter code: ");
            id = sc.nextLine();
            if (Validator.validateInputUniqueId(id, service)) {
                break; // chỉ thoát khi hợp lệ
            }
        }

        // Input Name
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (Validator.validateInputString(name)) { // <-- anh đang lỡ validate nhầm id ở đây
                break;
            }
        }

        // Input Age
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = Integer.parseInt(sc.nextLine());
                if (Validator.validateInputAge(age)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }

        // Input Salary
        while (true) {
            try {
                System.out.print("Enter salary: ");
                salary = Double.parseDouble(sc.nextLine());
                if (Validator.validateInputSalary(salary)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }

        // Input Location
        while (true) {
            System.out.print("Enter location: ");
            location = sc.nextLine();
            if (Validator.validateInputString(location)) {
                break;
            }
        }

        service.addWorker(new Worker(id, name, age, salary, location));
        System.out.println("Worker added successfully.");
    }



    private static void addWorker() {
        System.out.println("\n--- Add Worker ---");
        String id;
        String name;
        int age;
        double salary;
        String location;
        while (true) {
            System.out.print("Enter code: ");
            id = sc.nextLine();
            if (!Validator.validateInputUniqueId(id, service)) {
                continue;
            }
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (!Validator.validateInputString(id)) {
                continue;
            }
            System.out.print("Enter Age: ");
            age = Integer.parseInt(sc.nextLine());
            if (!Validator.validateInputAge(age)) {
                continue;
            }
            System.out.print("Enter salary: ");
            salary = Double.parseDouble(sc.nextLine());
            if (!Validator.validateInputSalary(salary)) {
                continue;
            }
            System.out.print("Enter location: ");
            location = sc.nextLine();
            if (!Validator.validateInputString(location)) {
                continue;
            }
            service.addWorker(new Worker(id, name, age, salary, location));
            System.out.println("Worker added successfully.");
            break;

        }


    }

    private static void changeSalary(boolean isUp) {
        System.out.println(isUp ? "\n--- Up Salary ---" : "\n--- Down Salary ---");
        String id;
        double amount;
        while (true) {
         id = sc.nextLine();
         if(!Validator.validateExistingId(id, service)) {
             System.out.println();
             continue;
         }
             amount = InputUtils.inputPositiveDouble("Enter Salary: ");
            if (isUp) {
                service.increaseSalary(id, amount);
            } else {
                boolean isSuccess = service.decreaseSalary(id, amount);
                if (!isSuccess) {
                    continue;
                }

            }
            System.out.println("Salary updated successfully.");
            break;
        }
    }

    private static void displayHistory() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n--- Display Information Salary ---");
        System.out.printf("%-5s %-10s %-5s %-10s %-6s %-12s%n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        System.out.println("------------------------------------------------------");
        service.getHistories().stream().sorted(Comparator.comparing(h -> h.getWorker().getId())).forEach(h -> {
            String dateFormatted = h.getDate().format(formatter); // đổi gạch ngang thành gạch chéo
            System.out.printf("%-5s %-10s %-5d %-10.2f %-6s %-12s%n",
                    h.getId(), h.getName(), h.getAge(), h.getSalary(),
                    h.getStatus(), dateFormatted);
        });
        System.out.println("------------------------------------------------------");
    }

}
