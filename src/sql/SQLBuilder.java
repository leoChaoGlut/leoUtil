package sql;

import static common.Const.SQL.DESC;
import static common.Const.SQL.FROM;
import static common.Const.SQL.GROUP_BY;
import static common.Const.SQL.SELECT;
import static common.Const.SQL.WHERE;

/**
 * 
 * @author leo
 * @date 2016年3月16日 下午1:31:31
 * @description sqlbuilder,线程不安全.
 */
public class SQLBuilder {

	private StringBuilder sql;

	public SQLBuilder() {
		sql = new StringBuilder();
	}

	public SQLBuilder select(String... fields) {
		sql.append(SELECT).append(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			sql.append("," + fields[i]);
		}
		return this;
	}

	public SQLBuilder from(String... tables) {
		sql.append(FROM).append(tables[0]);
		for (int i = 1; i < tables.length; i++) {
			sql.append("," + tables[i]);
		}
		return this;
	}

	public SQLBuilder where(String... whereArgs) {
		sql.append(WHERE).append(whereArgs[0]);
		for (int i = 1; i < whereArgs.length; i++) {
			sql.append("," + whereArgs[i]);
		}
		return this;
	}

	public SQLBuilder groupBy(String field) {
		sql.append(GROUP_BY).append(field);
		return this;
	}

	public SQLBuilder desc() {
		sql.append(DESC);
		return this;
	}

	@Override
	public String toString() {
		return sql.toString();
	}

}
