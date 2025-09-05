package com.ts.service;

import com.ts.entity.Student;
import com.ts.utils.InputUtils;

import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void createStudent() {
        while (true) {
            String id = InputUtils.getString("Enter ID: ");
            String name = InputUtils.getString("Enter Name: ");
            String semester = InputUtils.getSemester("Enter Semester: ");
            String course;
            while (true) {
                course = InputUtils.getCourse();
                if (isDuplicate(semester, course, id)) {
                    System.out.println("Course already exists");
                } else break;
            }
            students.add(new Student(id, name, semester, course));
            System.out.println("Student added!");
            if (students.size() >= 2) {
                String ans = InputUtils.getYesNo("Do you want to continue (Y/N)? ");
                if (ans.equalsIgnoreCase("N")) return;
            }
        }
    }

    public void findAndSort() {
        String keyword = InputUtils.getString("Enter student name to search: ").toLowerCase();

        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword)) result.add(s);
        }

        if (result.isEmpty()) {
            System.out.println("No student found!");
            return;
        }

        result.sort(new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return o1.getName().compareToIgnoreCase(o2.getName());

           }
        });



        System.out.println("---- Search Result ----");
        for (Student s : result) {
            System.out.println(s.getName() + " | " + s.getSemester() + " | " + s.getCourseName());
        }
    }

    public void updateOrDelete() {
        String id = InputUtils.getString("Enter student ID to search: ");

        Student target = null;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                target = s;
                break;
            }
        }

        if (target == null) {
            System.out.println("Student not found!");
            return;
        }

        String choice = InputUtils.getString("Do you want to update (U) or delete (D)? ");
        if (choice.equalsIgnoreCase("U")) {
            target.setName(InputUtils.getString("Enter new name: "));
            target.setSemester(InputUtils.getString("Enter new semester: "));
            target.setCourseName(InputUtils.getCourse());
            System.out.println("Updated successfully!");
        } else if (choice.equalsIgnoreCase("D")) {
            students.remove(target);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Invalid choice!");
        }
    }


    public boolean isDuplicate(String semester, String course, String id) {
        for (Student s : students) {
            if (s.getSemester().equalsIgnoreCase(semester) &&
                    s.getCourseName().equalsIgnoreCase(course) &&
                    s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

/*
    id 1: name kien course .net
    id 2: name long course java
    id 3: name kien course c/c++
    id 4: name minh course java
    id 5: name minh course java
    id 1: name kien course .net

    key = 1 - .net
    printed empty
    count =0;

    count =2
    printed add ket (1- .net ) -> sout 1 | kien .net 2




    kien java 1
    kien .net 1
    minh java 2
    long java 1

*/
    public void report() {
        System.out.println("---- Report ----");
        ArrayList<String> printed = new ArrayList<>();
        for (Student s : students) {
            String key = s.getId() + "-" + s.getCourseName();
            if (printed.contains(key)) {
                continue;
            }
            int count = 0;
            for (Student other : students) {
                if (s.getId().equalsIgnoreCase(other.getId()) &&
                        s.getCourseName().equalsIgnoreCase(other.getCourseName())) {
                    count++;
                }
            }
            System.out.println(s.getId() + " | " + s.getName() + " | " +
                    s.getCourseName() + " | " + count);

            printed.add(key);
        }
    }
}
