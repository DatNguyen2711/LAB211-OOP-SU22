package Students;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Validation validation = new Validation();
        ls.add(new Student("1", "Bui Quoc Anh", "Spring", "java"));
        ls.add(new Student("2", "Bui Viet Anh", "Fall", ".net"));
        ls.add(new Student("3", "Nguyen Khai Hon", "Summer", "c/c++"));
        ls.add(new Student("4", "Nguyen Thanh Tung", "Winter", "java"));
        ls.add(new Student("5", "Trinh Hoang Phong", "Summer", ".net"));
        ls.add(new Student("6", "Chu Viet Dung", "Fall", "c/c++"));
        ls.add(new Student("7", "Mai Nam Hai", "Spring", "java"));
        ls.add(new Student("8", "Phung Thanh Do", "Winter", ".net"));
        ls.add(new Student("9", "Ronaldo", "Summer", "c/c++"));
        //ls.add(new Student("10", "Vuong Minh Tuan", "Spring", "java"));
        int count = 10;
        //loop until user want to exit program
        while (true) {
            //Show menu option
            Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStudent(count, ls);
                    break;
                case 2:
                    Manager.findAndSort(ls);
                    break;
                case 3:
                    Manager.updateOrDelete(count, ls);
                    break;
                case 4:
                    Manager.report(ls);
                    break;
                case 5:
                    return;
            }
        }
    }
}