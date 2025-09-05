package com.ts.service;

import com.ts.entity.Doctor;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorService {
    private HashMap<String, Doctor> doctors = new HashMap<>();
    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getCode(), doctor);
    }

    public void updateDoctor(Doctor doctor) {
        Doctor old = doctors.get(doctor.getCode());

        if (doctor.getName() != null && !doctor.getName().trim().isEmpty()) {
            old.setName(doctor.getName());
        }
        if (doctor.getSpecialization() != null && !doctor.getSpecialization().trim().isEmpty()) {
            old.setSpecialization(doctor.getSpecialization());
        }
        if (doctor.getAvailability() >= 0) {
            old.setAvailability(doctor.getAvailability());
        }

        doctors.put(doctor.getCode(), old);
    }

    public void deleteDoctor(String code) {
        doctors.remove(code);
    }


    public HashMap<String, Doctor> searchDoctor(String input) {

        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor d : doctors.values()) {
            if (d.getCode().toLowerCase().contains(input.toLowerCase()) ||
                    d.getName().toLowerCase().contains(input.toLowerCase()) ||
                    d.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                result.put(d.getCode(), d);
            }
        }
        return result;
    }

    public void printDoctorsGroupedBySpecializationSimple() {
        ArrayList<Doctor> doctorList = new ArrayList<>(doctors.values());
        ArrayList<Doctor> visited = new ArrayList<>();

        for (int i = 0; i < doctorList.size(); i++) {
            Doctor current = doctorList.get(i);

            if (visited.contains(current)) {
                continue;
            }

            System.out.println("Specialization: " + current.getSpecialization());

            for (int j = 0; j < doctorList.size(); j++) {
                Doctor d = doctorList.get(j);
                if (d.getSpecialization().equalsIgnoreCase(current.getSpecialization())) {
                    System.out.println(d);
                    visited.add(d);
                }
            }
        }
    }


    public boolean isExistCode(String input) {
        return doctors.containsKey(input);
    }
}
