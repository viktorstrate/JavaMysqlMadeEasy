# JavaMysqlMadeEasy
MySQL in Java made easy

## Example
```java
// Connects with the database named "database",
// at the host "localhost" with the username "root" and no password.
Mysql testMysql = new Mysql("localhost", "root", "");

// Gets the results of a simple MYSQL query
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
```
#### The database structure for the example above
<table>
<tr><td>id</td><td>username</td><td>password</td></tr>
<tr><td>1</td><td>bob</td><td>1234</td>
<tr><td>2</td><td>john</td><td>1234</td>
<tr><td>3</td><td>john</td><td>1234</td>
</table>
