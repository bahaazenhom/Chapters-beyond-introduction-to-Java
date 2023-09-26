package Chapter_35;

import java.sql.*;
import java.util.*;

// 35.1 | SQLClient
// This section develops a universal SQL client for connecting and accessing any SQL database.
public class SQLClient {
    public static Scanner input = new Scanner(System.in);
    public static Connection connection;
    public static Statement statement;
    public static String[] drivers = {
            "com.mysql.jdbc.Driver",
            "sun.jdbc.odbc.dbcOdbcDriver",
            "oracle.jdbc.driver.OracleDriver"
    };
    public static String[] URLs = {
            "jdbc:mysql://localhost/javabook",
            "jdbc:mysql://liang.armstrong.edu/javabook",
            "jdbc:odbc:exampleMDBDataSource",
            "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl"
    };
    public static String sqlCommands = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Database Information\n");
        System.out.println("Enter a number with your JDBC Driver from the following: ");
        for (int i = 1; i <= drivers.length; i++) {
            System.out.println(i + " - " + drivers[i - 1]);
        }
        int driverNum = input.nextInt() - 1;
        System.out.println("----------------------------------");
        System.out.println("Enter a number with your database URL from the following: ");
        for (int i = 1; i <= URLs.length; i++) {
            System.out.println(i + " - " + URLs[i - 1]);
        }
        int databaseURLNum = input.nextInt() - 1;
        System.out.println("----------------------------------");
        System.out.println("Enter your database Username: ");
        String databaseUsername = input.next();
        System.out.println("----------------------------------");
        System.out.println("Enter your database password: ");
        String databasePassword = input.next();
        System.out.println("----------------------------------");

        connectToDB(driverNum, databaseURLNum, databaseUsername, databasePassword);

        enterSQLCommands();
        System.out.println("----------------------------------");
        while (true) {
            System.out.println("Enter a number indicating what you want to do from the following: ");
            System.out.println("1 - Clear");
            System.out.println("2 - Execute SQL commands");
            int action = input.nextInt();
            if (action == 1) {
                System.out.println("---Commands cleared---");
                enterSQLCommands();
            } else {
                executeSQL();
                break;
            }
        }


    }

    public static void enterSQLCommands() {
        sqlCommands = "";
        System.out.println("Enter SQL commands: ");
        System.out.println("---When finished enter the number -1 in a new line---");
        while (true) {
            String s = input.nextLine();
            sqlCommands += s;
            if (s.contains("-1")) break;
        }
    }

    private static void executeSQL() throws SQLException {
        if (connection == null) {
            System.out.println("---Please connect to a database first---");
            return;
        } else {
            String[] commandss = sqlCommands.replace('\n', ' ').replace("-1", "").split(";");
            for (String command : commandss) {
                System.out.println("---- Command: " + command + " ----");
                if (command.trim().toUpperCase().startsWith("SELECT")) processSQLSelect(command);
                else processSQLNonSelect(command);
                System.out.println("-------------------------------");
            }
        }

    }

    private static void processSQLNonSelect(String command) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(command);
        System.out.println("---SQL command executed");
    }

    private static void processSQLSelect(String command) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(command);
        int columnCount = resultSet.getMetaData().getColumnCount();
        String row = "";
        // Display column names.
        for (int i = 1; i <= columnCount; i++) row += resultSet.getMetaData().getColumnName(i) + "\t";
        System.out.println(row);
        while (resultSet.next()) {
            row = "";
            for (int i = 1; i <= columnCount; i++) row += resultSet.getString(i) + "\t";
            System.out.println(row);
        }
    }

    private static void connectToDB(int driverNum, int databaseURLNum, String databaseUsername, String databasePassword) throws ClassNotFoundException, SQLException {
        String driver = drivers[driverNum],
                url = URLs[databaseURLNum],
                username = databaseUsername,
                password = databasePassword;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("----Database Connected----");
        } catch (ClassNotFoundException e) {
            System.out.println("---Choose a suitable JDBC Driver---");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("---Database connecting error---");
            throw new RuntimeException(e);
        }


    }
}
