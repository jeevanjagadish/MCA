package assignment.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * @author KIRAN 30-Aug-2019
 * 
 */

public class JDBC3_Callable {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ajp_assignment_db";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "");
		Scanner sc = new Scanner(System.in);
		String fname, srn, branch;
		double cgpa;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, info);
			System.out.println("Enter SRN of the record to update the Name");
			srn = sc.nextLine();
			System.out.println("Enter the New Name");
			fname = sc.nextLine();
			String query = "{CALL getStudent(?)}";
			CallableStatement cst = (CallableStatement) con.prepareCall(query);
			cst.setString(1, srn);
			ResultSet rs = cst.executeQuery();
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
			rs.last();
			int rowCount = rs.getRow();
			if (rowCount > 0) {
				String query2 = "{CALL updateStudent(?,?)}";
				CallableStatement cst2 = (CallableStatement) con.prepareCall(query2);
				cst2.setString(1, srn);
				cst2.setString(2, fname);
				cst2.execute();
				System.out.println("Record updated");
			} else {
				System.out.println("No Record found,please Enter below details to insert");
				System.out.println("Enter Branch");
				branch = sc.nextLine();
				System.out.println("Enter CGPA");
				cgpa = sc.nextDouble();
				String query3 = "{CALL insertStudent(?,?,?,?)}";
				CallableStatement cst3 = (CallableStatement) con.prepareCall(query3);
				cst3.setString(1, srn);
				cst3.setString(2, fname);
				cst3.setString(3, branch);
				cst3.setDouble(4, cgpa);
				cst3.execute();
				System.out.println("Record inserted");
			}

		} catch (Exception e) { 
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}

}
