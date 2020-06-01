package ExcelImport;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	final static private String myurl = "jdbc:mysql://localhost:3306/"; // path
	final static private String mydriver = "com.mysql.jdbc.Driver"; // driver
	final static private String mydb = "manohar"; // schema
	final static private String password = "img_Global"; // password
	final static private String us = "root"; // user name

	public static Connection getDefaultConnection() {

		Connection conn = null;

		try {
			Class.forName(mydriver).newInstance();

			conn = (Connection) DriverManager.getConnection(myurl + mydb, us,
					password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
