package Chapter_34;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
// 34.5 | TestDatabaseMetaData
public class TestDatabaseMetaData {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database connected");
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("Database URL: " + databaseMetaData.getURL());
        System.out.println("Database username: " + databaseMetaData.getUserName());
        System.out.println("Database product name: " + databaseMetaData.getDatabaseProductName());
        System.out.println("Database product version: " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("JDBC driver name: " + databaseMetaData.getDriverName());
        System.out.println("JDBC driver version: " + databaseMetaData.getDriverVersion());
        System.out.println("JDBC driver major version: " + databaseMetaData.getDriverMajorVersion());
        System.out.println("JDBC driver minor version: " + databaseMetaData.getDriverMinorVersion());
        System.out.println("Max number of connections: " + databaseMetaData.getMaxConnections());
        System.out.println("MaxTableNameLength: " + databaseMetaData.getMaxTableNameLength());
        System.out.println("MaxColumnsInTable: " + databaseMetaData.getMaxColumnsInTable());

        connection.close();
    }
}
