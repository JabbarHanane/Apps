package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class connecterBD {
	Connection conn=null;
	public static Connection connexionBD(){
        try {
             
           //chargement du driver
           Class.forName("com.mysql.jdbc.Driver");
           // System.out.print("driver ok\n");
             
          
            
            String url = "jdbc:mysql://localhost/essai";
            String user = "root";
            String passwd = "mysql";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            //state =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           // System.out.print("con ok");
             
 return conn;
        }catch(Exception e) {
                                e.printStackTrace(); return null;
            }
    }
}
