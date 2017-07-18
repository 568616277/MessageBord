package struts2.db;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by zengman on 2017/7/15.
 */
public class DBConnect {

    private final String DBDRIVER = "com.mysql.jdbc.Driver" ;
    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/mystruts2db" ;
    private final String DBUSER = "root" ;
    private final String DBPASSWORD = "zeng1995" ;
    private Connection conn = null ;

    public DBConnect()   {
        try{
            Class.forName(DBDRIVER) ;
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // get the connection of DB
    public Connection getConnection(){
        return this.conn ;
    }

    // close the connection of DB
    public void close(){
        try{
            this.conn.close() ;
        }catch (Exception e){ }
    }
}
