package hu.dupetya.core.connection;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Datasource {
	private static volatile Datasource datasource;
	private ComboPooledDataSource cpds;

	private Datasource() throws PropertyVetoException {
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/portaldb");
		cpds.setUser("root");
		cpds.setPassword("mysql");

		cpds.setMinPoolSize(10);
		cpds.setAcquireIncrement(10);
		cpds.setMaxPoolSize(100);
	}

	public static Datasource getInstance() throws PropertyVetoException {
		if (datasource == null) {
			synchronized (Datasource.class) {
				if (datasource == null) {
					datasource = new Datasource();
				}
			}
		}
		return datasource;
	}

	public Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
}
