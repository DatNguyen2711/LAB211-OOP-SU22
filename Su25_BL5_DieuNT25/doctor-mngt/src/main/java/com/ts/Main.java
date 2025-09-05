package com.ts;

import com.ts.entity.Doctor;
import com.ts.service.DoctorService;
import com.ts.utils.InputUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoctorService doctorService = new DoctorService();

        while (true) {
            System.out.println("======== Doctor Management =========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");

            int choice = InputUtils.getChoice("Enter your choice");

            try {
                switch (choice) {
                    case 1:
                        System.out.println("--------- Add Doctor ---------");
                        String code = InputUtils.inputDoctorCode("Enter Code", doctorService, true);
                        String name = InputUtils.getNonEmptyString("Enter Name");
                        String specialization = InputUtils.getNonEmptyString("Enter Specialization");
                        int availability = InputUtils.inputInt("Enter Availability", true);
                        doctorService.addDoctor(new Doctor(code, name, specialization, availability));
                        System.out.println("Successfully added Doctor");
                        break;

                    case 2:
                        System.out.println("--------- Update Doctor -------");
                        String ucode = InputUtils.inputDoctorCode("Enter Code", doctorService, false);
                        String uname = InputUtils.getString("Enter Name (leave blank to keep old)");
                        String uspec = InputUtils.getString("Enter Specialization (leave blank to keep old)");
                        int uavail = InputUtils.inputInt("Enter Availability (-1 to keep old)", false);
                        doctorService.updateDoctor(new Doctor(ucode, uname, uspec, uavail));
                        System.out.println("Updated successfully");
                        break;

                    case 3:
                        System.out.println("--------- Delete Doctor -------");
                        String dcode = InputUtils.inputDoctorCode("Enter Code", doctorService, false);
                        doctorService.deleteDoctor(dcode);
                        System.out.println("Deleted successfully");
                        break;

                    case 4:
                        System.out.println("--------- Search Doctor --------");
                        String searchText = InputUtils.getString("Enter text");
                        HashMap<String, Doctor> result = doctorService.searchDoctor(searchText);
                        System.out.println("---------- Result ------------");
                        System.out.printf("%-10s %-15s %-15s %-5s\n", "Code", "Name", "Specialization", "Avail");

                        List<Doctor> sortedList = new ArrayList<>(result.values());
                        sortedList.sort(new Comparator<Doctor>() {
                            @Override
                            public int compare(Doctor d1, Doctor d2) {
                                int num1 = Integer.parseInt(d1.getCode().replaceAll("DOC", "").trim());
                                int num2 = Integer.parseInt(d2.getCode().replaceAll("DOC", "").trim());
                                return Integer.compare(num1, num2);
                            }
                        });
                        if(sortedList.isEmpty()){
                            System.out.println("No Data...");
                        }else{
                            for (Doctor d : sortedList) {
                                System.out.println(d);
                            }
                        }
                        break;
                    case 5:
                        doctorService.printDoctorsGroupedBySpecializationSimple();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
