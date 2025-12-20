package com.java.version.eight.streams.level.hard.dto;

public class WorkRecord {
    private String employeeName;
    private String department;

    public WorkRecord(String employeeName, String department) {
        this.employeeName = employeeName;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return  "name : " + employeeName +
                ", department : " + department;
    }
}
