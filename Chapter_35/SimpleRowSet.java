package Chapter_35;

import java.sql.SQLException;
import javax.sql.RowSet;

import com.sun.rowset.*;

// 35.4 | SimpleRowSet
// We the RowSet interface can be used to simplify database programming.
public class SimpleRowSet {
    public static void main(String[] args) throws SQLException {
        RowSet rowSet = new JdbcRowSetImpl();
        rowSet.setUrl("jdbc:mysql://localhost/javabook");
        rowSet.setUsername("scott");
        rowSet.setPassword("tiger");
        rowSet.setCommand("select firstName, mi, lastName from Student where lastName = 'Smith'");
        rowSet.execute();

        while (rowSet.next())
            System.out.println(rowSet.getString(1) + "\t" + rowSet.getString(2) + "\t" + rowSet.getString(3));
        rowSet.close();
    }
}
