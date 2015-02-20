# JavaMysqlMadeEasy
MySQL in Java made easy

## Example
Connects to the database at the host "localhost" with the username "root" and no password.
```java
Mysql testMysql = new Mysql("localhost", "root", "");
```
Gets the results from a basic SELECT query
```java
ResultSet result = testMysql.query("SELECT * FROM database.table");
```
Lists out all the usernames for the table
```java
try {
    while(result.next())
        System.out.println(result.getString("username"));
} catch (SQLException e) {
    e.printStackTrace();
}
```
Inserts into the table a username and a password, with the username john and password 1234
```java
testMysql.query("INSERT INTO database.table (username, password) VALUES ('john', '1234')");
```
Updates the table, sets the username for row 1 to bob
```java
testMysql.query("UPDATE database.table SET username='bob' WHERE id = 1");
```
#### The database structure for the example above
<table>
<tr><td>id</td><td>username</td><td>password</td></tr>
<tr><td>1</td><td>bob</td><td>1234</td>
<tr><td>2</td><td>john</td><td>1234</td>
<tr><td>3</td><td>john</td><td>1234</td>
</table>
