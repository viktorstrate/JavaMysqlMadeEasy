package dk.qpqp.mysqlMadeEasy;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by viktorstrate on 20/02/15.
 */
public class Example {
    public static void main(String[] args) {
        // Connects to the database at the host "localhost" with the username "root" and no password.
        Mysql testMysql = new Mysql("localhost", "root", "");

        // Gets the results from a basic SELECT query
        ResultSet result = testMysql.query("SELECT * FROM database.table");

        // Lists out all the usernames for the table
        try {
            while(result.next())
                System.out.println(result.getString("username"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Inserts into table a username and a password
        testMysql.query("INSERT INTO database.table (username, password) VALUES ('john', '1234')");

        // Updates the table
        testMysql.query("UPDATE database.table SET username='Bob' WHERE id = 1");
    }
}
