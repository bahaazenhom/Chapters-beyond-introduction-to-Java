/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Chapter_37;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahaa
 */
public class SimpleRegistration extends HttpServlet {

    private PreparedStatement psmt;

    public void init() throws ServletException {// this method is called and performed once the servlet is run.
        connectToDB();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String phone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        if (lastName.length() == 0 || firstName.length() == 0) {
            out.println("First Name and Last Name are required");
        } else {
            try {
                storeStudent(firstName, lastName, mi, phone, email, address, city, state, zip);
                out.println(firstName + " " + lastName + " is now registered in the database");
            } catch (Exception ex) {
                out.println("Errooooooooor: " + ex.toString());
            }
        }
        out.close();
    }

    private void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
            psmt = connection.prepareStatement("insert into Address (lastName, firstName, mi, telephone, email, street, city, state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            System.out.println(psmt);
        } catch (Exception ex) {
            Logger.getLogger(SimpleRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void storeStudent(String firstName, String lastName, String mi, String phone, String email, String address, String city, String state, String zip) throws SQLException {

        psmt.setString(1, lastName);
        psmt.setString(2, firstName);
        psmt.setString(3, mi);
        psmt.setString(4, phone);
        psmt.setString(5, email);
        psmt.setString(6, address);
        psmt.setString(7, city);
        psmt.setString(8, state);
        psmt.setString(9, zip);
        psmt.executeUpdate();
    }

}
