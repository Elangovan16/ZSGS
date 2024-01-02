package com.elangovan16.rolehierarchy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;

public class RoleHierarchyRepository {
	private static RoleHierarchyRepository repository;

	private RoleHierarchyRepository() {

	}

	public static RoleHierarchyRepository getInstance() {
		if (repository == null) {
			repository = new RoleHierarchyRepository();
		}
		return repository;
	}

	public int getRoleCount() {
		int n = 0;
		String query = "select count(role_id) from roles";
		try {
			Connection con = GetConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			n = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public void addRootRole(String role) {
		String query = "insert into roles(role_name) values(?)";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, role);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId(String role) {
		String query = "select role_id from roles where role_name= ?";
		int id = 0;
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, role);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void addSubRole(String subRole, String reportingManager) {
		String query = "insert into roles(role_name,parent_id) values(?,?)";
		int id = getId(reportingManager);
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, subRole);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<>();
		String query = "select * from roles order by parent_id;";
		try {
			Connection con = GetConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Role role = new Role();
				role.setRole_id(rs.getInt(1));
				role.setRole_name(rs.getString(2));
				role.setParent_id(rs.getInt(3));

				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	public void deleteRole(String role, String transferred) {

	}

}
