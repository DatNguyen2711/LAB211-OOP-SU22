package Students;
import java.util.ArrayList;
import java.util.Scanner;


public class Validation {
    private final static Scanner in = new Scanner(System.in);
    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    //check user input u / d
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.println("Enter again: ");
        }
    }

    //check user input course
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.println("Enter again: ");
        }
    }

    //check student exist
    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
                                            String studentName, String semester, String courseName) {
        int size = ls.size();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    //check report exist
    public static boolean checkReportExist(ArrayList<Report> lr, String name,
                                           String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    //check id and exist
    public static boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    //    public static boolean checkCourseExist(ArrayList<Student> ls, String course, String semester) {
//        for (Student student : ls) {
//            if (course.equalsIgnoreCase(student.getCourseName())
//                    && semester.equalsIgnoreCase(student.getSemester())) {
//                return false;
//            }
//        }
//        return true;
//    }
    public static String checkInputName(){
        while(true){
            String name = in.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            }

            else if(!name.matches("[a-zA-Z ]*")){
                System.err.println("Only character (A/a to Z/z)");
                System.out.println("Enter again: ");
            }
            else{
                return name;
            }

        }
    }

    public static String checkInputCode(){
        while(true){
            String code = in.nextLine().trim();
            if (code.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            }

            if(!code.matches("[a-zA-Z1-9]*")){
                System.err.println("Only character and integer number (A/a to Z/z,1 to 9)");
                System.out.println("Enter again: ");
            }
            else{
                return code;
            }

        }
    }
}