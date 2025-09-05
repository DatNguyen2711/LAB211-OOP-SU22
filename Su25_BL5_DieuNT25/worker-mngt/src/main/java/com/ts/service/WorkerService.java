package com.ts.service;

import com.ts.entity.History;
import com.ts.entity.Worker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerService {
    private List<Worker> workers = new ArrayList<>();
    private List<History> histories = new ArrayList<>();
    // set ko support phương thức để update 1 phần tử nào đó



    public boolean addWorker(Worker w) {
        workers.add(w);
        return true;
    }


    public boolean existsWorkerId(String id) {
        return findWorkerById(id) != null;
    }

    public boolean increaseSalary(String id, double amount) {
        Worker w = findWorkerById(id);
        if (w == null) return false;
        w.setSalary(w.getSalary() + amount);
        histories.add(new History(w.getId(), w.getName(), w.getAge(), w.getSalary(), "UP", LocalDate.now()));
        return true;
    }

    public boolean decreaseSalary(String id, double amount) {
        Worker w = findWorkerById(id);
        if (w == null) return false;
        if(w.getSalary() - amount < 0) {
            System.out.println("Worker salary cannot....");
            return  false;
        };
        w.setSalary(w.getSalary() - amount);
        histories.add(new History(w, "DOWN", LocalDate.now()));
        return true;
    }

    public List<History> getHistories() {
        return histories;
    }

    private Worker findWorkerById(String id) {
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }
}
