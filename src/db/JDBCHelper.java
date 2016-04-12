package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Leo
 * @date 2016年3月30日下午6:22:29
 * @description
 * @usage
 */
public class JDBCHelper {

	private static Properties prop = new Properties();

	static {
		try {
			prop.load(JDBCHelper.class
					.getResourceAsStream("../config/db.properties"));
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JDBCHelper() {
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(prop.getProperty("url"),
					prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prepareStatement;
	}

	public static ResultSet getResultSet(PreparedStatement preparedStatement) {
		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
