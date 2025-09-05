package Students;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;

public class Manager {
    //Show menu
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.println(" Enter your choice: ");
    }

    //Allow user create new student
    public static void createStudent(int count, ArrayList<Student> ls) {
        //if number of students greater than 10 ask user continue or not
        if (count > 10 || ls.size() >= 10) {
            System.out.println("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        //loop until user input not duplicate
        while (true) {
            System.out.println("Enter id: ");
            String id = Validation.checkInputString();
            System.out.println("Enter name student: ");
            String name = Validation.checkInputName();
            if (!Validation.checkIdExist(ls, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.println("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.println("Enter name course: ");
            String course = Validation.checkInputCourse();
//            if(!Validation.checkCourseExist(ls, course, semester)){
//                System.err.println("Can not add same course in same semester!! Please re-input.");
//                continue;
//            }
            //check student exist or not
            if (Validation.checkStudentExist(ls, id, name, semester, course)) {
                ls.add(new Student(id, name, semester, course));
                count++;
                System.out.println("Add student success.");
                return;
            }
            System.err.println("Duplicate.");

        }
    }
    //Allow user create find and sort

    public static void findAndSort(ArrayList<Student> ls) {
        //check list empty
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("Enter name to search: ");
        String nameSearch = Validation.checkInputName();
        ArrayList<Student> listStudentFindByName = listStudentFindByName(ls, nameSearch);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Comparator obj = new Comparator() {

                @Override
                public int compare(Object o1, Object o2) {
                    Student st1 = (Student) o1;
                    Student st2 = (Student) o2;
                    return (st1.getStudentName().toLowerCase().compareTo(st2.getStudentName().toLowerCase()));
                }
            };

            Collections.sort(ls, obj);
            //Collections.reverse(ld);
        }
        System.out.printf("%-30s%-20s%-20s\n", "Student name", "semester", "Course Name");
        //loop from first to last element of list student
        for (Student student : listStudentFindByName) {
            student.print();
        }
    }


    //List student found by name
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> ls, String name) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();

        String xName = name.toLowerCase();
        for (Student student : ls) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(xName)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    //Allow user update and delete
    public static void updateOrDelete(int count, ArrayList<Student> ls) {
        //if list empty
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(ls, id);
        //check list empty
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.println("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            if (Validation.checkInputUD()) {
                while (true) {
                    System.out.println("Enter name student: ");
                    String name = Validation.checkInputName();
                    System.out.println("Enter semester: ");
                    String semester = Validation.checkInputString();
                    System.out.println("Enter name course: ");
                    String course = Validation.checkInputCourse();
                    if (!Validation.checkStudentExist(ls, id, name, semester, course)) {
                        System.err.println("Can not add same course in same semester!! Please re-input.");
                        //System.out.println("Enter student name: ");
                        continue;
                    }
                    //check student exist or not
                    if (Validation.checkStudentExist(ls, id, name, semester, course)) {
                        student.setStudentName(name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        System.err.println("Update success.");
                        return;
                    }

                }
                //return;
            } else {
                ls.remove(student);
                count--;
                System.err.println("Delete success.");
                return;
            }
        }
    }

    //Get student user want to update/delete in list found
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-30s%-20s%-20s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-30s%-20s%-20s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.println("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    //Get list student find by id
    public static ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    //Print report
    public static void report(ArrayList<Student> ls) {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = ls.size();
        for (int i = 0; i < size; i++) {
//            int total = 0;
            for (Student student1 : ls) {
                int total = 0;
                for (Student student2 : ls) {
                    if (student1.getId().equalsIgnoreCase(student2.getId())
                            && student1.getCourseName().equalsIgnoreCase(student2.getCourseName())) {
                        total++;
                    }
                }

                if (Validation.checkReportExist(lr, student1.getStudentName(),
                        student1.getCourseName(), total)) {
                    lr.add(new Report(student1.getStudentName(),
                            student1.getCourseName(), total));
                }
            }
        }
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-30s|%-20s|%-20d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }


}
