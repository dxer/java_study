package com.wpo.app.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class DBManager {

	private DBConfig config = null;

	/**
	 * 不带参数的构造函数，读取的默认路径的配置文件
	 */
	public DBManager() {
		try {
			Properties props = new Properties();
			props.load(DBConfig.class.getResourceAsStream("jdbc.properties"));
			if (config == null) {
				config = new DBConfig(props);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 构造函数
	 * 
	 * @param fileName
	 *            配置文件的路径
	 */
	public DBManager(String fileName) {
		File file = new File(fileName);
		if (file != null) {
			try {
				if (file != null) {
					Properties props = new Properties();
					props.load(new FileInputStream(file));
					if (config == null) {
						config = new DBConfig(props);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获得连接
	 * 
	 * @param dataBaseName
	 * @return
	 */
	private Connection getConnection(String dataBaseName) {
		Connection conn = null;
		try {
			Class.forName(config.driver);
			if (dataBaseName != null) {
				conn = DriverManager.getConnection(config.url + dataBaseName,
						config.userName, config.password);
			} else {
				conn = DriverManager.getConnection(config.url, config.userName,
						config.password);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 创建database
	 * 
	 * @param dataBaseName
	 * @throws SQLException
	 */
	public void createDB(String dataBaseName) throws SQLException {
		Connection conn = getConnection(null);
		if (conn == null) {
			return;
		}
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String sql = "DROP DATABASE IF EXISTS " + dataBaseName;
			statement.execute(sql);
			sql = "CREATE DATABASE " + dataBaseName + " CHARACTER SET UTF8";
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(statement, conn);
		}
	}

	/**
	 * 更新字符集
	 * 
	 * @param dataBaseName
	 * @throws SQLException
	 */
	public void changeDbCharset(String dataBaseName) throws SQLException {
		Connection conn = getConnection(dataBaseName);
		if (conn == null) {
			return;
		}
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String sql = "ALTER DATABASE " + dataBaseName
					+ " CHARACTER SET UTF8";
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(statement, conn);
		}
	}

	/**
	 * 读取sql语句。"/*"开头为注释，";"为sql结束。
	 * 
	 * @param fileName
	 *            sql文件地址
	 * @return list of sql
	 * @throws Exception
	 */
	public List<String> readSqlFromFile(String fileName) throws Exception {
		BufferedReader br = null;
		List<String> sqlList = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName), "UTF-8"));
			sqlList = new ArrayList<String>();
			StringBuilder sqlSb = new StringBuilder();
			String s = null;
			while ((s = br.readLine()) != null) {
				if (s.startsWith("/*") || s.startsWith("#")
						|| StringUtils.isBlank(s)) {
					continue;
				}
				if (s.endsWith(";")) {
					sqlSb.append(s);
					sqlSb.setLength(sqlSb.length() - 1);
					sqlList.add(sqlSb.toString());
					sqlSb.setLength(0);
				} else {
					sqlSb.append(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return sqlList;
	}

	/**
	 * 创建表
	 * 
	 * @param dataBaseName
	 * @param fileName
	 */
	public void createTable(String dataBaseName, String fileName) {
		List<String> sqlList = null;
		try {
			sqlList = readSqlFromFile(fileName);

			if (sqlList != null && sqlList.size() > 0) {
				createTable(dataBaseName, sqlList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在指定的database中创建表
	 * 
	 * @param dataBaseName
	 * @param sqlList
	 * @throws SQLException
	 */
	public void createTable(String dataBaseName, List<String> sqlList)
			throws SQLException {
		Connection conn = getConnection(dataBaseName);
		if (conn == null) {
			return;
		}
		Statement statement = null;
		try {
			statement = conn.createStatement();
			for (String dllsql : sqlList) {
				statement.execute(dllsql);
			}
		} catch (Exception e) {

		} finally {
			close(statement, conn);
		}
	}

	/**
	 * 更新配置
	 * 
	 * @param dataBaseName
	 * @param sql
	 * @throws Exception
	 */
	public void updateConfig(String dataBaseName, String sql) throws Exception {
		Connection conn = getConnection(dataBaseName);
		if (conn == null) {
			return;
		}
		Statement statement = null;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(statement, conn);
		}
	}

	/**
	 * 关闭statement和connection
	 * 
	 * @param statement
	 * @param conn
	 * @throws SQLException
	 */
	private void close(Statement statement, Connection conn)
			throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * jdbc配置的一些属性
	 * 
	 * @class DBConfig
	 * @author walker
	 * 
	 */
	class DBConfig {
		public final String driver;
		public String url;
		public final String userName;
		public final String password;

		public DBConfig(Properties props) {
			this.driver = props.getProperty(JdbcProps.JDBC_DRIVER);
			this.url = props.getProperty(JdbcProps.JDBC_URL);
			this.userName = props.getProperty(JdbcProps.JDBC_USERNAME);
			this.password = props.getProperty(JdbcProps.JDBC_PASSWORD);
		}
	}

}
