package BMI;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Manager.menu();
            int choice = Manager.InputChoice();
            switch (choice) {
                case 1:
                    Manager.normalCalculator();
                    break;
                case 2:
                    Manager.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }
    }
}
