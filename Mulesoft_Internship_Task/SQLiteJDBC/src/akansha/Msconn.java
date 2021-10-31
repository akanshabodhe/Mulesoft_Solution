package akansha;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Msconn {
	public static void main(String []args) {
		Connection connection = null;

        

        try{
        	connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);  
                
                statement.executeUpdate("drop table if exists movies");
                statement.executeUpdate("create table movies (movie String, actor String,actress String,year Integer,director String)");
                statement.executeUpdate("insert into movies values('Shershah','Siddharth Malhotra','Kiara Adwani',2021,'Vishnuvardhan')");
                statement.executeUpdate("insert into movies values('Mimi','Pankaj Tripathi','Kriti Senon',2021,'Lakshman')");
                ResultSet rs = statement.executeQuery("select * from movies");
                
                while(rs.next())
                {
                 
                  System.out.println("movie = " + rs.getString("movie"));
                  System.out.println("actor = " + rs.getString("actor"));
                  System.out.println("actress = " + rs.getString("actress"));
                  System.out.println("year = " + rs.getInt("year"));
                  System.out.println("director = " + rs.getString("director"));
                 
                }
               

        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            
            System.err.println(e);
          }
    }
	
	}
	}
