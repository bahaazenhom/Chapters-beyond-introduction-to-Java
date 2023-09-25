package Chapter_34;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.*;

// 34.6 | FindUserTables
public class FindUserTables {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database connected");
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null,null,null,new String[]{"TABLE"});
        System.out.println("User tables: ");
        while(resultSet.next()) System.out.println(resultSet.getString("TABLE_NAME"));
        connection.close();
    }
}
