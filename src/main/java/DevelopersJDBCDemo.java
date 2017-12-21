import java.sql.*;

public class DevelopersJDBCDemo {

    //JDBC driver and DB url

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbc_tutorial?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //User and Password

    static final String USER = "root";
    static final String PASSWORD = "Pir0jo4eK";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        Statement statement;

        System.out.println("Registering JDBC Driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM developers";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n============================================\n");
            System.out.println("ID= " + id);
            System.out.println("Name= " + name);
            System.out.println("Specialty= " + specialty);
            System.out.println("Salary= " + salary);
            }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
