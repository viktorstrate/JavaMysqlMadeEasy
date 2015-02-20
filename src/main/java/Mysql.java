import java.sql.*;

/**
 * Created by viktorstrate on 20/02/15.
 */
public class Mysql {
    private String host;
    private String username;
    private String password;
    private String dbName;

    public static boolean log = true;

    private Connection connection = null;
    private Statement statement = null;

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
    public Mysql(String host, String username, String password){
        this();
        this.connect(host, username, password);

    }

    /**
     * If not connected when initialized.
     * @param host the hostname of the mysql server, fx. "localhost" or "example.com"
     * @param username the username of the mysql server.
     * @param password the password of the mysql server. Use an empty string for no password.
     */
    public void connect(String host, String username, String password){
        this.host = host;
        this.username = username;
        this.password = password;
        try {
            // Setup the connection with the db
            connection = DriverManager.getConnection("jdbc:mysql://"+host+"/?"
            + "user="+username+"&password="+password);
            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database.");
            e.printStackTrace();
        }
    }
    /**
     * Executes a query, to the mysql server
     * @param query the query to execute fx. "SELECT * FROM table"
     * @return the selected rows, if any else returning NULL
     */
    public ResultSet query(String query){

        if(connection==null || statement==null){
            System.out.println("Couldn't execute query, is did the connection fail, or is it set");
        }

        try {
            if(query.toLowerCase().contains("insert") || query.toLowerCase().contains("update")){
                statement.executeUpdate(query);
                if(log) System.out.println("Inserted / Updated values to database syccessfully");
                return null;
            } else {
                ResultSet results = statement.executeQuery(query);
                if(log) System.out.println("Selected values from database syccessfully");
                return results;
            }
        } catch (SQLException e) {
            System.out.println("Couldn't execute query");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Frees up the ram, the mysql executions used.
     * Call it when you're done, using the Mysql Database.
     */
    public void close(){
        try{
            if(connection!=null) connection.close();
            if(statement!=null) statement.close();
        } catch (SQLException e){
            System.out.println("Couldn't close connection or statement");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
