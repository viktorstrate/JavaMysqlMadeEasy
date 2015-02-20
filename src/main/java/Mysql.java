/**
 * Created by viktorstrate on 20/02/15.
 */
public class Mysql {
    private String host;
    private String username;
    private String password;
    private String dbName;

    public Mysql(){
        try {
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
        this.host = host;
        this.username = username;
        this.password = password;
    }

    /**
     * Select which database to connect to.
     * @param databaseName the name of the database, to connect to.
     */
    public void connectToDB(String databaseName){
        this.dbName = databaseName;
    }

    /**
     * Executes a query, to the mysql server
     * @param query the query to execute fx. "SELECT * FROM table"
     * @return the selected rows, if any else returning NULL
     */
    public Object query(String query){
        return null;
    }

}
