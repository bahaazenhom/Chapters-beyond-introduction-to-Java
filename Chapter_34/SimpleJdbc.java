package Chapter_34;


import java.sql.*;

// 34.1 | SimpleJdbc
// JDBC is the Java API for accessing relational database.
public class SimpleJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Database connection.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database Connected");
        // Create of the statement.
        Statement statement = connection.createStatement();
        // execute the query and put the result in a result set.
        ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student where lastName = 'smith'");
        // we can loop through the result set as follow.
        // each parameter passed in the function getString() indicate a specific column value as the order we put it in the query.
        // ex: for the prev query we put the columns as follows (firstName, mi lastName) so to get the first value in the first record
        // in the result set we call the method with parameter '1' and for the second value we pass '2' and so on.
        while (resultSet.next()) System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " "
                + resultSet.getString(3));
        connection.close();

    }
}
