/**
 * 
 */
package assignment.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author KIRAN 30-Aug-2019
 * 
 */
public class JDBC1_Connection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/ajp_assignment_db";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, info);
			String query = "SELECT * FROM student where usn=101";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				System.out.println("USN      	:" + rs.getString(1));
				System.out.println("FULLNAME    :" + rs.getString(2));
				System.out.println("BRANCH  	:" + rs.getString(3));
				System.out.println("CGPA  		:" + rs.getString(4));
				System.out.println();
				System.out.println();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
