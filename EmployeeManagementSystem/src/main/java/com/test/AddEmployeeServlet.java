package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("empId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");

        Employee emp = new Employee(empId, name, email, department, salary, phone);

        EmployeeDAO dao = new EmployeeDAO();
        boolean success = dao.insertEmployee(emp);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (success) {
            out.println("<h2>Employee added successfully!</h2>");
            out.println("<a href='addEmployee.html'>Add another</a>");
        } else {
            out.println("<h2>Failed to add employee.</h2>");
        }
    }
}