/**
 * 
 */
package assignment.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * @author KIRAN 30-Aug-2019
 * 
 */
public class JDBC2_Metadata {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ajp_assignment_db";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, info);

			DatabaseMetaData md = (DatabaseMetaData) con.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}

			Statement st = null;
			st = con.createStatement();

			String sql = "select * from student";
			rs = st.executeQuery(sql);
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

			int rowCount = metaData.getColumnCount();

			System.out.println("Table Name : " + metaData.getTableName(1));
			System.out.println("Column Names");

			for (int i = 0; i < rowCount; i++) {
				System.out.print(metaData.getColumnName(i + 1) + "  \t");
				// System.out.println(metaData.getColumnTypeName(i + 1));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
