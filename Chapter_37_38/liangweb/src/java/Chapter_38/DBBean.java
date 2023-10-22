/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter_38;

import java.sql.*;

/**
 *
 * @author bahaa
 */
public class DBBean {

    private Connection connection;
    private String username;
    private String password;
    private String driver;
    private String url;

    public void initializeJdbc() {
        try {
            System.out.println("Driver is: com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection((url+"?useSSL=false"), username, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String[] getTables() {
        String[] tables = null;
        try {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rsTables = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            int size = 0;
            while (rsTables.next()) {
                size++;
            }
            rsTables = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            tables = new String[size];
            int i = 0;
            while (rsTables.next()) {
                tables[i++] = rsTables.getString("TABLE_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tables;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setDriver(String newDriver) {
        driver = newDriver;
    }

    public String getDriver() {
        return driver;
    }

    public void setUrl(String newUrl) {
        url = newUrl;
    }

    public String getUrl() {
        return url;
    }
}
