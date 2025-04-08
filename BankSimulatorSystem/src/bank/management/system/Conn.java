package bank.management.system;
import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		
		try {
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root"); 
			//Step-3: Create Statement
			s=c.createStatement();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}
}
