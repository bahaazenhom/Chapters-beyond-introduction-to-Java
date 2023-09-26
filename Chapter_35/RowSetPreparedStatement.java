package Chapter_35;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.RowSet;

import com.sun.rowset.*;

// 35.5 |  RowSetPreparedStatement
public class RowSetPreparedStatement {
    public static void main(String[] args) throws SQLException {
        RowSet rowSet = new JdbcRowSetImpl();
        rowSet.setUrl("jdbc:mysql://localhost/javabook");
        rowSet.setUsername("scott");
        rowSet.setPassword("tiger");
        rowSet.setCommand("select * from Student where lastName = ? and mi = ?");
        rowSet.setString(1, "Smith");
        rowSet.setString(2, "R");
        rowSet.execute();

        ResultSetMetaData rsMetaData = rowSet.getMetaData();
        for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
            System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
        System.out.println();

        // Iterate through the result and print the student names
        while (rowSet.next()) {
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) System.out.printf("%-12s\t", rowSet.getObject(i));
            System.out.println();
        }

        rowSet.close();
    }
}
