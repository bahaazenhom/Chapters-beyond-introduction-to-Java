/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package chapter_41;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.sql.*;

/**
 *
 * @author bahaa
 */
@WebService(name = "AddressService", serviceName = "AddressWebService")
public class AddressService {

    // statement1 for retrieving an address and statement2 for storing
    private PreparedStatement statement1;

    // statement2 for storing an address
    private PreparedStatement statement2;

    public AddressService() {
        initializeJdbc();
    }

    @WebMethod(operationName = "getAddress")
    public Address getAddress(String firstName, String lastName) {
        try {
            if(statement1 != null){
            statement1.setString(1, firstName);
            statement1.setString(2, lastName);
            }
            else return new Address();
            ResultSet resultSet = statement1.executeQuery();

            if (resultSet.next()) {
                Address address = new Address();
                
                address.setFirstName(resultSet.getString("firstName"));
                address.setLastName(resultSet.getString("lastName"));
                address.setMi(resultSet.getString("mi"));
                address.setTelephone(resultSet.getString("telephone"));
                address.setFirstName(resultSet.getString("email"));
                address.setCity(resultSet.getString("telephone"));
                address.setState(resultSet.getString("state"));
                address.setZip(resultSet.getString("zip"));
                return address;
            } else {
                return new Address();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @WebMethod(operationName = "storeAddress")
    public void storeAddress(Address address) {
        try {
            statement2.setString(1, address.getLastName());
            statement2.setString(2, address.getFirstName());
            statement2.setString(3, address.getMi());
            statement2.setString(4, address.getTelephone());
            statement2.setString(5, address.getEmail());
            statement2.setString(6, address.getStreet());
            statement2.setString(7, address.getCity());
            statement2.setString(8, address.getState());
            statement2.setString(9, address.getZip());
            statement2.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initialize database connection
     */
    public void initializeJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the sample database 
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
           
            statement1 = connection.prepareStatement(
                    "select * from Address where firstName = ? and lastName = ?");
            statement2 = connection.prepareStatement(
                    "insert into Address "
                    + "(lastName, firstName, mi, telephone, email, street, city, "
                    + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
