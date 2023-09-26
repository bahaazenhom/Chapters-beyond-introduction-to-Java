package Chapter_35;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.RowSet;

import com.sun.rowset.*;

// 35.6 | ScrollUpdateRowSet
public class ScrollUpdateRowSet {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database Connected");
        RowSet rowSet = new JdbcRowSetImpl();
        rowSet.setUrl("jdbc:mysql://localhost/javabook");
        rowSet.setUsername("scott");
        rowSet.setPassword("tiger");
        rowSet.setCommand("select state, capital from StateCapital");

        rowSet.execute();
        System.out.println("Before update: ");
        displayRowSet(rowSet);

        rowSet.absolute(2);
        rowSet.updateString("state", "New S");
        rowSet.updateString("capital", "New C");
        rowSet.updateRow();


        rowSet.last();
        rowSet.moveToInsertRow();
        rowSet.updateString("state", "Florida");
        rowSet.updateString("capital", "Tallahassee");
        rowSet.insertRow();
        rowSet.moveToCurrentRow();

        // Delete forth row.
        rowSet.absolute(4);
        rowSet.deleteRow();
        System.out.println("After update: ");
        displayRowSet(rowSet);

        connection.close();// Close the connection.

    }

    private static void displayRowSet(RowSet rowSet) throws SQLException {
        rowSet.beforeFirst();
        while (rowSet.next()) {
            for (int i = 1; i <= rowSet.getMetaData().getColumnCount(); i++)
                System.out.printf("%-12s\t", rowSet.getObject(i));
            System.out.println();
        }
    }
}
