import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 Statement stmt = null;
		 try {
	            // connect way #1
	            String url1 = "jdbc:mysql://localhost:3306/my_database_mca";
	            //String user = "root";
	            //String password = "jeev@125971";
	            Properties prop = new Properties();
	            InputStream is = new InputStream() {
					
					@Override
					public int read() throws IOException {
						// TODO Auto-generated method stub
						return 0;
					}
				};
				prop.load(is);
	            conn = DriverManager.getConnection(url1, prop);
	            if (conn != null)
	            {
	                System.out.println("Connected to the database");
	            }
	            String query = "SELECT * FROM MCA_t1 where person_id = 001";
			    stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					System.out.println("person_id     	:" + rs.getInt(1));
					System.out.println("per_firstname    :" + rs.getString(2));
					System.out.println("per_surname  	:" + rs.getString(3));
					
					System.out.println("View successful");
					
				}
				rs.close();
				
				 conn.close();
				 System.out.println("Connection Closed");
	}catch (SQLException ex) {
        System.out.println("An error occurred");
        ex.printStackTrace();
    }
		 
	}
}
