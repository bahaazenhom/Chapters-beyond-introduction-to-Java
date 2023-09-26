package Chapter_35;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

// 35.2 | CopyFileToTableUsingBatchProcessing
// You can send a batch of SQL statements to the database for execution at once to improve efficiency.

public class CopyFileToTableUsingBatchProcessing {
    public static Scanner input = new Scanner(System.in);
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {

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

        System.out.println("Enter table name to copy file to it: ");
        String tableName = input.next();
        System.out.println("Enter the source text file: ");
        String fileSource = input.next();
        while (true) {
            System.out.println("Choose a number to process: ");
            System.out.println("1 - View file content");
            System.out.println("2 - Copy file content to table " + tableName);
            int actionNum = input.nextInt();
            if (actionNum == 2) {
                copyFileToTable(fileSource, tableName);
                break;
            } else viewFileContent(fileSource);
        }

    }

    private static void viewFileContent(String fileSource) throws FileNotFoundException {
        try {
            Scanner file = new Scanner(new File(fileSource.trim()));
            System.out.println("----------------------");
            System.out.println("---Source file content---");
            while (file.hasNext()) System.out.println(file.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + fileSource);
        }
        System.out.println("----------------------");
    }

    private static void copyFileToTable(String fileSource, String tableName) {
        String sqlQuery = "insert into " + tableName + " values(";
        try {
            Scanner file = new Scanner(new File(fileSource.trim()));
            statement = connection.createStatement();
            if (connection.getMetaData().supportsBatchUpdates()) {
                System.out.println("---Batch updates supported---");
                while (file.hasNext()) statement.addBatch(sqlQuery + file.nextLine() + ")");
                statement.executeBatch();
                System.out.println("---Batch updates completed---");
            } else {
                System.out.println("---No support for batch updates---");
                while (file.hasNext()) statement.executeUpdate(sqlQuery + file.nextLine() + ")");
                System.out.println("---Single row update completed---");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + fileSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            System.out.println("JDBC: " + driver);
            System.out.println("Database URL: " + url);
            System.out.println("Username: " + username);
        } catch (ClassNotFoundException e) {
            System.out.println("---Choose a suitable JDBC Driver---");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("---Database connecting error---");
            throw new RuntimeException(e);
        }


    }
}

