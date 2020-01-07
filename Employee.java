package mcaSem5;
import java.sql.*;

//import mcaSem5.SqlConnection;

public class Employee {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost/student"; 
        String user = "root"; 
        String pass = "student"; 
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
			  
            //Reference to connection interface 
            con = DriverManager.getConnection(url,user,pass); 
            
            System.out.println("Connected to db succesfully");
            
			stmt = con.createStatement();
		      
		    String sql = "create table employee " +
		                   "(id integer not NULL, " +
		                   " firstName varchar(50), " + 
		                   " lastName varchar(50), " + 
		                   " deptName varchar(50), " + 
		                   " salary int, " +
		                   " primary key ( id ))"; 
		    
//		    stmt.executeUpdate(sql);
//		    System.out.println("created table");
		    
		    sql = "insert into employee " + 
		    		" values (001, 'harsha', 'ky', 'rnd', 645454)";
//		    stmt.executeUpdate(sql);
		    
		    sql = "insert into employee " + 
		    		" values (002, 'sudha', 'rao', 'accounts', 30000)";
//		    stmt.executeUpdate(sql);
		    
		    sql = "insert into employee " + 
		    		" values (003, 'mahesh', 'h', 'hr', 35000)";
//		    stmt.executeUpdate(sql);
		    
//		    System.out.println("Inserted");
		    
		    sql = "delete from employee " +
		    		" where id = 002";
//		    stmt.executeUpdate(sql);
//		    System.out.println("deleted");
		    
		    sql = "select * from employee";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		         
		         int id  = rs.getInt("id");
		         String first = rs.getString("firstName");
		         String last = rs.getString("lastName");
		         String dept = rs.getString("deptName");
		         int salary = rs.getInt("salary");

		         
		         System.out.print("ID: " + id);
		         System.out.print(", First Name: " + first);
		         System.out.print(", Last Name: " + last);
		         System.out.print(", Department Name: " + dept);
		         System.out.print(", Salary: " + salary);
		         System.out.println("");
		      }
		      rs.close();
		    
		    
		    con.close();
		    System.out.println("Connection Closed");
		    
		} catch (SQLException se){
			se.printStackTrace();
		}

	}

}
