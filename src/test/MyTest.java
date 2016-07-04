package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import bitManiputlation.BitManipulation;
import crypt.MD5Util;
import db.JDBCHelper;

public class MyTest {
	@Test
	public void test() {
		String src = "chashaobao";
		byte[] build = MD5Util.build(src);
		String bytesToHex = MD5Util.bytesToHex(build);
		System.out.println(bytesToHex);
	}

	/**
	 * JDBCHelper
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test01() throws SQLException {
		Connection connection = JDBCHelper.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet resultSet = metaData.getColumns(null, null, "ob_project", null);
		while (resultSet.next()) {
			String columnName = resultSet.getString("COLUMN_NAME");
			System.out.println(columnName);
		}
	}

	@Test
	public void test02() {
		long result = BitManipulation.add(17L, 66L);
		System.out.println(result);
	}
}
