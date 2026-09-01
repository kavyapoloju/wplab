package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // CREATE - Add a new employee
    public boolean insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee (emp_id, name, email, department, salary, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());
            ps.setString(6, emp.getPhone());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ - Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("emp_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getDouble("salary"),
                    rs.getString("phone")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // READ - Get one employee by ID
    public Employee getEmployeeById(int empId) {
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE - Update an existing employee
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET name=?, email=?, department=?, salary=?, phone=? WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getPhone());
            ps.setInt(6, emp.getEmpId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE - Remove an employee
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM employee WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SEARCH - Search employees by name or department
    public List<Employee> searchEmployees(String keyword) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE LOWER(name) LIKE ? OR LOWER(department) LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            String likeKeyword = "%" + keyword.toLowerCase() + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
               
                	Employee emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("phone")
                    );
                    list.add(emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}