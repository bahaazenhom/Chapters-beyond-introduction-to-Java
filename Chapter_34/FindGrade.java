package Chapter_34;

import java.sql.*;
import java.util.Scanner;

// 34.2 | FindGrade
// Without using PreparedStatement.
public class FindGrade {
    public static Statement statement;

    public static void main(String[] args) throws SQLException {
        initializeDB();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Student SSN: ");
        String ssn = input.next();
        System.out.println("Enter the Course ID: ");
        String courseId = input.next();
        showGrade(ssn, courseId);
    }

    public static void initializeDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database Connected");
        statement = connection.createStatement();
    }

    public static void showGrade(String ssn, String courseId) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName, title, grade from Student, Enrollment, Course" +
                " where Student.ssn = '" + ssn + "' and Enrollment.courseId " + " = '" + courseId +
                "' and Enrollment.courseId = Course.courseId " +
                " and Enrollment.ssn = Student.ssn");
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
