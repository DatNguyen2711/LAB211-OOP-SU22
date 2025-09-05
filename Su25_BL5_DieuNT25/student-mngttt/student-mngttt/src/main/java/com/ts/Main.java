package com.ts;

import com.ts.service.StudentService;
import com.ts.utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");

//        Collections.sort(result, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getName().compareToIgnoreCase(s2.getName());
//            }
//        });
            int choice = InputUtils.getInt("Please choose (1-5): ", 1, 5);
            switch (choice) {
                case 1 -> service.createStudent();
                case 2 -> service.findAndSort();
                case 3 -> service.updateOrDelete();
                case 4 -> service.report();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
            }
        }
    }
}
