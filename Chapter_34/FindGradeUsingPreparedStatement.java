package Chapter_34;

import java.sql.*;
import java.util.Scanner;

// 34.3 | FindGradeUsingPreparedStatement
// PreparedStatement enables you to create parameterized SQL statements.
public class FindGradeUsingPreparedStatement {
    public static PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        initializeDB();
        System.out.println("Enter the Student SSN: ");
        String ssn = input.next();
        System.out.println("Enter the Course ID: ");
        String courseId = input.next();
        showGrade(ssn, courseId);

    }

    public static void initializeDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        // each '?' refer to a parameter that will be passed before executing the query.
        preparedStatement = connection.prepareStatement("select firstName, mi, lastName, title, grade from Student," +
                "Enrollment, Course where Student.ssn = ? and Enrollment.courseId = ? and Enrollment.courseId = Course.courseId");


    }

    public static void showGrade(String ssn, String courseId) throws SQLException {
        // each number we pass to the method setString() indicate the place and the order of '?' that have been put in the query.
        // '1' refer to the first '?', and '2' to the second '?' and so on.
        preparedStatement.setString(1, ssn);
        preparedStatement.setString(2, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // each number we pass in the method getString() here refers to the order of the value we asked to get in the query.
            // for example: '1' refers to the firstName, '3' refers to lastName and so on.
            // each loop refers to a complete record in the result set.
            String lastName = resultSet.getString(1);
            String mi = resultSet.getString(2);
            String firstName = resultSet.getString(3);
            String title = resultSet.getString(4);
            String grade = resultSet.getString(5);

            System.out.println(firstName + " " + mi + " " + lastName + "'s grade on course " + title + " is " + grade);
        } else {
            System.out.println("Not found");
        }

    }
}
