package com.ts.entity;

import java.time.LocalDate;

public class History {
    Worker worker;
    private String status; // UP / DOWN
    private LocalDate date;

    public History() {
    }

    public History(Worker worker, String status, LocalDate date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

