///**
// * Created by Konrad on 2016-01-12.
// */
//import java.sql.*;
//
//public class JdbcTutor2 {
//    /**
//     * Please rename DB_NAME to your name, for example
//     * static final String DB_NAME="JohnDoe";
//     */
//    static final String DB_NAME="test";
//
//    Connection conn;
//
//    public static void main(String[] a) {
//        JdbcTutor t = null;
//        try {
//            t = new JdbcTutor();
//
//            /**
//             * Create table and Insert can be executed only once!
//             */
//            t.createTableStudents();
//            t.createTableMarks();
//            t.addStudent(1, "Andrew", "andrew@mail.ua");
//            t.addStudent(2, "John", "john@mail.ua");
//            t.addMark(5,1); // add mark 5 to Andrew
//            t.addMark(4,1); // and mark 4
//            t.addMark(5,2); // add mark 5 to John
//
//            /**
//             * Print all students and average marks
//             */
//            t.printStudents();
//
//        } catch(SQLException e) {
//            e.printStackTrace();
//        } finally {
//            t.closeConnection();
//        }
//
//    }
//
//    public JdbcTutor() {
//        openConnection();
//    }
//
//    public Connection openConnection() {
//        try {
//            Class.forName("org.h2.Driver"); // this is driver for H2
//            conn = DriverManager.getConnection("jdbc:h2:~/dnepr-db/"+DB_NAME,
//                    "sa", // login
//                    "" // password
//            );
//            return conn;
//        } catch(ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void closeConnection() {
//        try {
//            conn.close();
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Should create table Students
//     */
//    public void createTableStudents() throws SQLException {
//    }
//
//    /**
//     * Should create table Marks
//     */
//    public void createTableMarks() throws SQLException {
//    }
//
//    /**
//     * Should add student to the Students table
//     */
//    public void addStudent(int id, String name, String email) throws SQLException {
//    }
//
//    /**
//     * Should add mark to the Student
//     */
//    public void addMark(int student, int mark) throws SQLException {
//    }
//
//    /**
//     * Should print all students and their marks
//     */
//    public void printStudents() throws SQLException {
//
//    }
//
//}
//
