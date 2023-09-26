package Chapter_35;


import java.sql.*;

// 35.3 | ScrollUpdateResultSet
// We can use scrollable and updatable result set to move the cursor anywhere in the result set to perform insertion, deletion, and update.
// The program may not work because not all current drivers support scrollable and updatable result sets
public class ScrollUpdateResultSet {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database Connected");
        // this how we define a statement which support scrollable and updatable Result Set.
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select state, capital from StateCapital");
        System.out.println("Before update: ");
        displayResultSet(resultSet);
        // Update the second row.
        resultSet.absolute(2);// Move cursor to the second row.
        resultSet.updateString("state", "New S");// update the column 'state' in the row that the cursor is referring to.
        resultSet.updateString("capital", "New C");// // update the column 'capital' in the row that the cursor is referring to.
        resultSet.updateRow();// update the row in the data source.

        // Insert after the last row.
        resultSet.last();// Move cursor to the last row.
        resultSet.moveToInsertRow();// Move cursor to insert row.
        resultSet.updateString("state", "Florida");// Put a state value in the last row we inserted.
        resultSet.updateString("capital", "Tallahassee");// // Put a capital value in the last row we inserted.
        resultSet.insertRow();// Insert the row to the data source.
        resultSet.moveToCurrentRow();// Move the cursor to the current row.

        // Delete forth row.
        resultSet.absolute(4);// Move cursor to the 4th row.
        resultSet.deleteRow();// Delete the current row.

        System.out.println("After update: ");
        resultSet = statement.executeQuery("select * from statecapital");
        displayResultSet(resultSet);

        connection.close();// Close the connection.

    }

    private static void displayResultSet(ResultSet resultSet) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
                System.out.printf("%-12s\t", resultSet.getObject(i));
            System.out.println();
        }
    }
}
