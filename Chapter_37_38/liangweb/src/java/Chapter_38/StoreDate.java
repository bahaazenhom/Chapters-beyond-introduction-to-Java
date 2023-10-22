/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter_38;

import java.sql.*;
import Chapter_37.Address;

/**
 *
 * @author bahaa
 */
public class StoreDate {

    private PreparedStatement pstmt;

    public StoreDate() {
        initializeJdbc();
    }

    private void initializeJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
            pstmt = connection.prepareStatement("insert into Address "
                    + "(lastName, firstName, mi, telephone, email, street, city, "
                    + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void storeStudent(Address address) throws SQLException {
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
