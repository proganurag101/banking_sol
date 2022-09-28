package banking;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	static Connection con; 
	public static Connection getConnection()
	{
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = " SYS AS SYSDBA";	 
			String pass = "Qwerty123#"; 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("fetching details..");
		}
		catch (Exception e) {
			System.out.println("Connection Failed!");
		}

		return con;
	}
}
