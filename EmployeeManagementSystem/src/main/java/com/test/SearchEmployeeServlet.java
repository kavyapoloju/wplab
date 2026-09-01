package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if (keyword == null) keyword = "";

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.searchEmployees(keyword);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Search Results</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 90%; margin: 20px; }");
        out.println("th, td { border: 1px solid #999; padding: 8px; text-align: left; }");
        out.println("th { background-color: #333; color: white; }");
        out.println("</style></head><body>");

        out.println("<h2>Search Employees</h2>");
        out.println("<form action='SearchEmployeeServlet' method='get'>");
        out.println("<input type='text' name='keyword' placeholder='Search by name or department' value='" + keyword + "'>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("<a href='ViewEmployeesServlet'>View All Employees</a><br><br>");

        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Phone</th></tr>");

        for (Employee emp : employees) {
            out.println("<tr>");
            out.println("<td>" + emp.getEmpId() + "</td>");
            out.println("<td>" + emp.getName() + "</td>");
            out.println("<td>" + emp.getEmail() + "</td>");
            out.println("<td>" + emp.getDepartment() + "</td>");
            out.println("<td>" + emp.getSalary() + "</td>");
            out.println("<td>" + emp.getPhone() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}