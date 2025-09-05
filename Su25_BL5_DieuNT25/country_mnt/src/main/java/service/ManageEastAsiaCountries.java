package service;

import entity.EastAsiaCountries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ManageEastAsiaCountries {
    public static final int MAX = 11;
    private List<EastAsiaCountries> countries = new ArrayList<>();

    public boolean isFull() {
        return countries.size() >= MAX;
    }



    public void addCountry(EastAsiaCountries c){
        countries.add(c);
    }

    public ArrayList<EastAsiaCountries> getAll() {
        return new ArrayList<>(countries);
    }

    public ArrayList<EastAsiaCountries> searchByName(String keyword) {
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries e : countries) {
            if (e.getCountryName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() {
        ArrayList<EastAsiaCountries> sorted = new ArrayList<>(countries);
        sorted.sort(new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });

        return sorted;
    }

    public static void display() {
            System.out.printf("%-6s %-20s %-12s %-12s%n", "ID", "Name", "Total Area", "Terrain");
    }


    public boolean isExistedCountryCode(String code) {
        for (EastAsiaCountries e : countries) {
            if (e.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }


    public boolean isExistedCountryName(String name) {
        for (EastAsiaCountries e : countries) {
            if (e.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
