package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConnectionFactory class. Creates the connection with the database.
 */
public class ConnectionFactory {
    /**
     * The LOGGER of the class
     */
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    /**
     * The DRIVER
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * The DBURL. The path of the database
     */
    private static final String DBURL = "jdbc:mysql://localhost:3306/tema3";
    /**
     * The USER. The username of the database owner.
     */
    private static final String USER = "root";
    /**
     * The PASS. The password of the user for the database.
     */
    private static final String PASS = "root";

    /**
     * Creates a new instance of the connection
     */
    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Instantiates a new connection factory
     */
    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Creates a new Connection object
     * @return the connection
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Retrieves the connection
     * @return the connection
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes the connection
     * @param connection the connection to the database
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Closes the statement
     * @param statement the statement
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Closes the resultSet
     * @param resultSet the resultSet.
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
