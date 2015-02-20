# JavaMysqlMadeEasy
MySQL in Java made easy, a java API inspired by the way **PHP** handles mysql.<br>
You just need one .jar file, it includes the drivers needed to run MYSQL in java.

## How it works
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

## How to setup
1. Download the desired version from the **jar** folder, located in the root of the repository.
2. Add the .jar to your buildpath, google that if you don't know how to do that.
3. [here](https://github.com/viktorstrate/JavaMysqlMadeEasy/blob/master/src/test/java/Example.java) you can see an example file to help or test if it works.

## See the wiki for more information
