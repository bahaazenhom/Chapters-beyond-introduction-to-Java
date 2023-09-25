package Chapter_34;

import java.sql.*;

//34.7 | TestResultSetMetaData
// The ResultSetMetaData interface describes information pertaining to the result set.
// A ResultSetMetaData object can be used to find the types and properties of the columns in a ResultSet.
public class TestResultSetMetaData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database Connected");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from enrollment");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for(int i=1;i<=resultSetMetaData.getColumnCount();i++) System.out.printf("%-12s\t",resultSetMetaData.getColumnName(i));
        System.out.println();

        while(resultSet.next()){
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++) System.out.printf("%-12s\t",resultSet.getObject(i));
            System.out.println();
        }

        connection.close();

    }
}
