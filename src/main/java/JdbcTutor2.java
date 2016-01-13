/**
 * Created by Konrad on 2016-01-12.
 */
import java.sql.*;

public class JdbcTutor2 {
    /**
     * Please rename DB_NAME to your name, for example
     * static final String DB_NAME="JohnDoe";
     */
    static final String DB_NAME="KonradAdamczyk2";

    Connection conn;

    public static void main(String[] a) {
        JdbcTutor2 t = null;
        try {
            t = new JdbcTutor2();

            /**
             * Create table and Insert can be executed only once!
             */
            t.dropTableStudents();  // drop table if it already exist
            t.dropTableMarks();  // drop table if it already exist
            t.createTableStudents();
            t.createTableMarks();
            t.addStudent(1, "Andrew", "andrew@mail.ua");
            t.addStudent(2, "John", "john@mail.ua");
            t.addMark(1,1,5); // add mark 5 to Andrew
            t.addMark(2,1,4); // and mark 4
            t.addMark(3,1,5); // add mark 5 to John

            /**
             * Print all students and average marks
             */
            t.printStudents();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            t.closeConnection();
        }

    }

    public JdbcTutor2() {
        openConnection();
    }

    public Connection openConnection() {
        try {
            Class.forName("org.h2.Driver"); // this is driver for H2
            conn = DriverManager.getConnection("jdbc:h2:~/dnepr-db/"+DB_NAME,
                    "sa", // login
                    "" // password
            );
            return conn;
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropTableStudents() throws SQLException {
        String sql = "DROP TABLE IF EXISTS STUDENTS";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
    public void dropTableMarks() throws SQLException {
        String sql = "DROP TABLE IF EXISTS MARKS";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    /**
     * Should create table Students
     */
    public void createTableStudents() throws SQLException {
        String sql = "CREATE TABLE STUDENTS " +
                "(ID INT PRIMARY KEY, " +
                " NAME VARCHAR(255)," +
                " EMAIL VARCHAR(255))";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    /**
     * Should create table Marks
     */
    public void createTableMarks() throws SQLException {
        String sql = "CREATE TABLE MARKS " +
                "(ID INT PRIMARY KEY, " +
                " STUDENT_ID INT, " +
                " FOREIGN KEY(STUDENT_ID)" +
                " REFERENCES STUDENTS(ID)," +
                " MARK INT)";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    /**
     * Should add student to the Students table
     */
    public void addStudent(int id, String name, String email) throws SQLException {
        String sql = "INSERT INTO STUDENTS(ID,NAME,EMAIL) " +
                "VALUES("+id+",'"+name+"','"+email+"') ";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    /**
     * Should add mark to the Student
     */
    public void addMark(int id, int studentId, int mark) throws SQLException {
        String sql = "INSERT INTO MARKS(ID, STUDENT_ID, MARK) " +
                "VALUES("+id+","+studentId+","+mark+") ";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    /**
     * Should print all students and their marks
     */
    public void printStudents() throws SQLException {
        try {
            // 1) Create statement
            Statement stmt = conn.createStatement();
            String sql = "SELECT id, name, EMAIL FROM STUDENTS ";
            // 2) Execute query and get the ResultSet
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over results and print it
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("EMAIL");

                // Display data
                System.out.print("ID: " + id + ", ");
                System.out.print("Name: " + name );
                System.out.print(", Email: " + email + "\n");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}

