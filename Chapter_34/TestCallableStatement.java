package Chapter_34;

import java.sql.*;
import java.util.Scanner;

// 34.4 | TestCallableStatement
// CallableStatement enables us to execute SQL stored procedures.
public class TestCallableStatement {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        // this how we establish a connection between stored procedure and process their inputs and outputs.
        // the first '?' refer to the output coming from this procedure after processing the input.
        // while the '?'s between "()" are the input parameters for the function.
        CallableStatement callableStatement = connection.prepareCall("{? = call studentFound(?, ?)}");
        System.out.println("Enter the first name");
        String first = input.next();
        System.out.println("Enter the second name");
        String second = input.next();
        // here we pass the first input as the second '?', so we are referring to it as the number 2
        callableStatement.setString(2, first);
        // and this is the second input and the third '?' so we referred to it with number 3.
        callableStatement.setString(3, second);
        // here we are specifying that the output which it's the first '?' will be return as an integer
        callableStatement.registerOutParameter(1, Types.INTEGER);
        // after setting the input and the output we execute the callable statement.
        callableStatement.execute();
        // the method getInt() here return the output that we specified it before to be an Integer.
        if (callableStatement.getInt(1) >= 1) System.out.println(first + " " + second + " is in the database");
        else System.out.println(first + " " + second + " isn't in the database");
    }
}
