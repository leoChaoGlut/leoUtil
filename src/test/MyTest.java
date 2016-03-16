package test;

import org.junit.Test;

import sql.SQLBuilder;

public class MyTest {
	@Test
	public void test() {
		SQLBuilder sqlBuilder = new SQLBuilder();
		String sql = sqlBuilder.select("id", "name").from("user")
				.where("username!=null").groupBy("name").desc().toString();
		System.out.println(sql);
	}

}
