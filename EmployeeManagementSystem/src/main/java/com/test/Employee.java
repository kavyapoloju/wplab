package com.test;

public class Employee {
    private int empId;
    private String name;
    private String email;
    private String department;
    private double salary;
    private String phone;

    public Employee() {
    }

    public Employee(int empId, String name, String email, String department, double salary, String phone) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phone = phone;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
