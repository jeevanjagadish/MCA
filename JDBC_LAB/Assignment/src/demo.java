import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
public class demo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost/jeev@125971"; 
        String user = "root"; 
        String pass = "jeev@125971"; 

        try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
			  
            //Reference to connection interface 
            con = DriverManager.getConnection(url,user,pass); 
            
            System.out.println("Connected to db succesfully");
            
			stmt = con.createStatement();
		    
		    
		    con.close();
		    System.out.println("Connection Closed");
		    
		} catch (SQLException se)
        {
			se.printStackTrace();
		}
	}

}
