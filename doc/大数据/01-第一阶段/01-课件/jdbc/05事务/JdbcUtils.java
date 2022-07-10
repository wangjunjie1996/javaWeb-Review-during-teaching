package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
    private static DataSource dataSource = new ComboPooledDataSource();//创建次c3p0连接池对象
    //private static Connection conn = null;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    //获取连接池对象
    public static DataSource getDataSource() {
          return dataSource;
    }
    
    //获取连接
    public static Connection getConnection() throws SQLException {
    	Connection conn = tl.get();
    	if(conn == null) {
    		return dataSource.getConnection();
    	}
    	return conn;
    }
    //开启事务
    public static void beginTransaction() throws SQLException {
    	Connection conn = tl.get();
		if(conn != null) {
			throw new SQLException("已经开启事务，不能重复开启");
		}
		conn = getConnection();
		conn.setAutoCommit(false);
		tl.set(conn);
	}
    //提交事务
    public static void commitTransaction() throws SQLException {
    	Connection conn = tl.get();
		if(conn == null) {
			throw new SQLException("连接为空，不能提交事务");
		}
		conn.commit();
		conn.close();
		tl.remove();
	}
    //回滚事务
    public static void rollbackTransaction() throws SQLException {
    	Connection conn = tl.get();
		if(conn == null) {
			throw new SQLException("连接为空，不能回滚事务");
		}
		conn.rollback();
		conn.close();
		tl.remove();
	}
}
