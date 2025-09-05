package com.ts.entity;

public class Student {
    private String id;
    private String name;
    private String semester;
    private String courseName;

    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSemester() { return semester; }
    public String getCourseName() { return courseName; }

    public void setName(String name) { this.name = name; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + semester + " | " + courseName;
    }
}
