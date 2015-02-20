/**
 * Created by viktorstrate on 20/02/15.
 */
public class Mysql {
    private String host;
    private String username;
    private String password;

    public Mysql(){

    }
    public Mysql(String host, String username, String password){
        this.host = host;
        this.username = username;
        this.password = password;
    }
}
