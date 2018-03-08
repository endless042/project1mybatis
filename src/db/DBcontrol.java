package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcontrol {
	private static DBcontrol db=new DBcontrol();

	private DBcontrol() {
		
	}
	
	public static DBcontrol getInstance() {
		return db;
	}
	
	public static Connection getConnection(){
		
		Connection con=null;
		try {
			String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
			String dbId="scott";
			String dbPass="tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
