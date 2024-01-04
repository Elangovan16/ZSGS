package com.elangovan16.rolehierarchy.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static final String name = "root";
	private static final String password = "Elangovan@16";
	private static final String url = "jdbc:mysql://localhost:3306/roles_db";
	private static Connection con;

	private GetConnection() {
	}

	public static Connection getConnection() {
		if (con == null) {
			synchronized (GetConnection.class) {
				if (con == null) {
					try {
						con = DriverManager.getConnection(url, name, password);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
