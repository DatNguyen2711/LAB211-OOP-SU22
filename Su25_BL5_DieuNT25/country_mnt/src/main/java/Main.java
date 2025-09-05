import entity.EastAsiaCountries;
import service.ManageEastAsiaCountries;
import utils.InputHelper;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries mgr = new ManageEastAsiaCountries();

        while (true) {
            showMenu();
            int opt = InputHelper.readIntInRange("Choose: ", 1, 5);

            switch (opt) {
                case 1: // Input
                    if (mgr.isFull()) {
                        System.out.println("Enough 11 countries. Don't add more.");
                        break;
                    }
                    EastAsiaCountries c = inputOneCountry(mgr);
                    mgr.addCountry(c);
//                    boolean ok = mgr.addCountry(c);
//                    if (!ok) {
//                        System.out.println("Duplicate country code or name, or the limit of 11 countries reached.");
//                    } else {
//                        System.out.println("Add success");
//                    }
                    break;

                case 2: // Display already information
                    List<EastAsiaCountries> all = mgr.getAll();
                    if (all.isEmpty()) {
                        System.out.println("No data.");
                    } else {
                        ManageEastAsiaCountries.display();
                        for (EastAsiaCountries e : all) {
                            e.display();
                        }
                    }
                    break;

                case 3: // Search by name
                    String kw = InputHelper.readNonEmpty("Enter the name you want to search for: ");
                    List<EastAsiaCountries> found = mgr.searchByName(kw);
                    if (found.isEmpty()) {
                        System.out.println("No matching country found.");
                    } else {
                        ManageEastAsiaCountries.display();
                        for (EastAsiaCountries e : found) {
                            e.display();
                        }
                    }
                    break;

                case 4: // Display sorted by name asc
                    List<EastAsiaCountries> sorted = mgr.sortInformationByAscendingOrder();
                    if (sorted.isEmpty()) {
                        System.out.println("No data.");
                    } else {
                        ManageEastAsiaCountries.display();
                        for (EastAsiaCountries e : sorted) {
                            e.display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Bye!");
                    return;
            }
            System.out.println();
        }
    }

    private static EastAsiaCountries inputOneCountry(ManageEastAsiaCountries mgr) {
        String code = InputHelper.inputCountryCode("Enter code of country: ",mgr).trim();
        String name = InputHelper.readCountryName("Enter name of country: ", mgr);
        float area  = InputHelper.readPositiveFloat("Enter total Area: ");
        String terrain = InputHelper.readNonEmpty("Enter terrain of country: ").trim();
        return new EastAsiaCountries(code, name, area, terrain);
    }

    private static void showMenu() {
        System.out.println("=========== MENU ===========");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
    }
}
