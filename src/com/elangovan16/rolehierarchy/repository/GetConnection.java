package com.elangovan16.rolehierarchy.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static String name = "root";
	private static String password = "Elangovan@16";
	private static String url = "jdbc:mysql://localhost:3306/roles_db";
	private static Connection con;

	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
