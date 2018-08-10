package db.components;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;


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
		    String ConfigFilePath ="C:\\Users\\Sougata_S_B\\eclipse-workspace"
		    		+ "\\StrutsWebApp\\target\\StrutsLoginEx\\WEB-INF\\classes\\db.properties" ;

			Properties props = new Properties();
			FileInputStream in = new FileInputStream(ConfigFilePath);
			props.load(in);
			in.close();
		
			String driver = props.getProperty("DB_DRIVER_CLASS");
			System.out.println("Driver --" + driver );
		
			if (driver != null) {
				Class.forName(driver);
				}
			else
			{
				System.out.println("Driver not initialized");
				
			}
			String url = props.getProperty("DB_URL") ; 
			String dbUser = props.getProperty("DB_USERNAME");
			String dbPwd = props.getProperty("DB_PASSWORD");
			System.out.println("url --" +url +  "  dbUser --- "+ dbUser + " dbPwd  " + dbPwd);
			dbCon = DriverManager.getConnection(url,dbUser,dbPwd);
		
	  } 
	catch (Exception e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return dbCon;
	
	}
	
}

