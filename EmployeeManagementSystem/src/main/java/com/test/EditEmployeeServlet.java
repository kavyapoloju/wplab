package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Shows the pre-filled edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("empId"));
        EmployeeDAO dao = new EmployeeDAO();
        Employee emp = dao.getEmployeeById(empId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (emp == null) {
            out.println("<h2>Employee not found.</h2>");
            return;
        }

        out.println("<html><body>");
        out.println("<h2>Edit Employee</h2>");
        out.println("<form action='EditEmployeeServlet' method='post'>");
        out.println("<input type='hidden' name='empId' value='" + emp.getEmpId() + "'>");
        out.println("Name: <input type='text' name='name' value='" + emp.getName() + "'><br><br>");
        out.println("Email: <input type='email' name='email' value='" + emp.getEmail() + "'><br><br>");
        out.println("Department: <input type='text' name='department' value='" + emp.getDepartment() + "'><br><br>");
        out.println("Salary: <input type='number' step='0.01' name='salary' value='" + emp.getSalary() + "'><br><br>");
        out.println("Phone: <input type='text' name='phone' value='" + emp.getPhone() + "'><br><br>");
        out.println("<input type='submit' value='Update Employee'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Saves the updated data
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("empId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");

        Employee emp = new Employee(empId, name, email, department, salary, phone);

        EmployeeDAO dao = new EmployeeDAO();
        dao.updateEmployee(emp);

        response.sendRedirect("ViewEmployeesServlet");
    }
}