package db.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public   class DbConnection {
	
	String driver;
	String url ;
	String dbUser;
	String dbPwd ;
		
	public DbConnection()
	{
	}
	
	/**
	 * @return _dbConnect
	 */
	public static Connection getConnect() throws Exception
	{
		Connection dbCon = null;
	try {
		    ResourceBundle Res = ResourceBundle.getBundle("db");
			if (Res.getString("DB_DRIVER_CLASS") != null) {
				Class.forName(Res.getString("DB_DRIVER_CLASS"));
				}
			else
			{
				System.out.println("Driver not initialized");
				
			}
			dbCon = DriverManager.getConnection(Res.getString("DB_URL"),Res.getString("DB_USERNAME"),Res.getString("DB_PASSWORD"));
	  } 
	catch (Exception e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return dbCon;
	
	}
	
}

