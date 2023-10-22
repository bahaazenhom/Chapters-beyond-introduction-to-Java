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
 * @author bahaa
 */
public class RegistrationWithHttpSession extends HttpServlet {

    // Use a prepared statement to store a student into the database
    private PreparedStatement pstmt;

    /**
     * Initialize variables
     */
    public void init() throws ServletException {
        initializeJdbc();
    }

    /**
     * Process the HTTP Get request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

// Obtain data from the form
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        if (lastName.length() == 0 || firstName.length() == 0) {
            out.println("Last Name and First Name are required");
        } else {
            // Ask for confirmation
            Address address = new Address();
            address.setCity(city);
            address.setEmail(email);
            address.setFirstName(firstName);
            address.setLastName(lastName);
            address.setMi(mi);
            address.setState(state);
            address.setStreet(street);
            address.setTelephone(telephone);
            address.setZip(zip);

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("address", address);

            out.println("You entered the following data");
            out.println("<p>Last name: " + lastName);
            out.println("<br>First name: " + firstName);
            out.println("<br>MI: " + mi);
            out.println("<br>Telephone: " + telephone);
            out.println("<br>Email: " + email);
            out.println("<br>Address: " + street);
            out.println("<br>City: " + city);
            out.println("<br>State: " + state);
            out.println("<br>Zip: " + zip);
            out.println("<p><form method=\"post\" action= RegistrationWithHttpSession>");
            out.println("<p><input type=\"submit\" value=\"Confirm\" >");
            out.println("</form>");
            out.close();

        }

        out.close(); // Close stream
    }

    /**
     * Process the HTTP Post request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession();
        Address address = (Address) httpSession.getAttribute("address");

        try {
            storeStudent(address);
            out.println(address.getFirstName() + " " + address.getLastName() + " is now registered in the database");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            out.println(address.getLastName() + " " + address.getFirstName() + " " + address.getMi() + " " + address.getTelephone() + " "
                    + address.getEmail() + " "
                    + address.getStreet() + " "
                    + address.getCity() + " "
                    + address.getState() + " "
                    + address.getZip());
        }
    }

    /**
     * Initialize database connection
     */
    private void initializeJdbc() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
            System.out.println("Database connected");

            // Create a Statement
            pstmt = conn.prepareStatement("insert into Address "
                    + "(lastName, firstName, mi, telephone, email, street, city, "
                    + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Store a student record to the database
     */
    private void storeStudent(Address address) throws SQLException {
        pstmt.setString(1, address.getLastName());
        pstmt.setString(2, address.getFirstName());
        pstmt.setString(3, address.getMi());
        pstmt.setString(4, address.getTelephone());
        pstmt.setString(5, address.getEmail());
        pstmt.setString(6, address.getStreet());
        pstmt.setString(7, address.getCity());
        pstmt.setString(8, address.getState());
        pstmt.setString(9, address.getZip());
        pstmt.executeUpdate();
    }
}
