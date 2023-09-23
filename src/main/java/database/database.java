package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author h
 */
public class database {
    public static Connection getconnection(){
        Connection con=null;
        try { 
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
               
            String url="jdbc:mySQL://localhost:3306/web_ban_hang3";
            String user="root";
            String password="";
            con= DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
        
    }
    public static void close(Connection c) {
		try {
			if (c!=null) {
			    c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
} 
