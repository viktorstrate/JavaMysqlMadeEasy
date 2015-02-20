import java.sql.*;

/**
 * Created by viktorstrate on 20/02/15.
 */
public class Mysql {
    private String host;
    private String username;
    private String password;
    private String dbName;

    private Connection connection;
    private Statement statement;

    public Mysql(){
        try {
            // This loads the driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connection information
     * @param host the hostname of the mysql server, fx. "localhost" or "example.com"
     * @param username the username of the mysql server.
     * @param password the password of the mysql server. Use an empty string for no password.
     */
    public Mysql(String host, String username, String password, String databaseName){
        this();
        this.connect(host, username, password, databaseName);

    }

    /**
     * If not connected when initialized.
     * @param host the hostname of the mysql server, fx. "localhost" or "example.com"
     * @param username the username of the mysql server.
     * @param password the password of the mysql server. Use an empty string for no password.
     */
    public void connect(String host, String username, String password, String databaseName){
        this.host = host;
        this.username = username;
        this.password = password;
        try {
            // Setup the connection with the db
            connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+databaseName+"?"
            + "user="+username+"&password="+password);
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Executes a query, to the mysql server
     * @param query the query to execute fx. "SELECT * FROM table"
     * @return the selected rows, if any else returning NULL
     */
    public ResultSet query(String query){

        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
