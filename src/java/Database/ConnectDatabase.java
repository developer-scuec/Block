package Database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectDatabase {
	public Connection getConnection() {
		String db_driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		try {
			InputStream in = null;
			Properties properties = new Properties();
			in = getClass().getResourceAsStream("info.properties");
			properties.load(in);
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String dburl = properties.getProperty("dburl");
			Class.forName(db_driver);
			conn=DriverManager.getConnection(dburl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
