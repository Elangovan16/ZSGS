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
		String query = "SELECT count(role_id) FROM roles";
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
		String query = "INSERT INTO roles(role_name) VALUES(?)";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, role);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getRootRole() {
		String name = "";
		String query = "SELECT role_name FROM roles WHERE parent_id IS NULL";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("role_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	public int getId(String role) {
		String query = "SELECT role_id FROM roles WHERE role_name= ?";
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
		String query = "INSERT INTO roles(role_name,parent_id) VALUES(?,?)";
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

	public List<Role> getRolesFromId(int id) {
		List<Role> roles = new ArrayList<>();
		String query = "SELECT * FROM roles WHERE parent_id = ?;";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

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

	public int getParentId(String role) {
		String query = "SELECT parent_id FROM roles WHERE role_name= ?";
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

	private void updateTransferredRole(int deletedRoleId, int transferredRoleId) {
		String query = "UPDATE roles SET parent_id = ? WHERE parent_id = ?";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, transferredRoleId);
			pstmt.setInt(2, deletedRoleId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeParentId(int deleteRoleparentId, String transferredRole) {
		String query = "UPDATE roles SET parent_id = ? WHERE role_name = ?";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deleteRoleparentId);
			pstmt.setString(2, transferredRole);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRole(String deleteRole, String transferredRole) {
		int deleteRoleId = getId(deleteRole);
		int transferredRoleId = getId(transferredRole);
		int deleteRoleparentId = getParentId(deleteRole);

		changeParentId(deleteRoleparentId, transferredRole);
		updateTransferredRole(deleteRoleId, transferredRoleId);
		String query = "DELETE FROM roles WHERE role_name = ?";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, deleteRole);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser(String user, String role) {
		int id = getId(role);
		String query = "INSERT INTO users(user_name,role_id) VALUES(?,?)";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Role> getUsers() {
		List<Role> roles = new ArrayList<>();

		String query = "SELECT users.user_name, roles.role_name FROM users JOIN roles ON users.role_id = roles.role_id;";
		try {
			Connection con = GetConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Role role = new Role();
				role.setUser_name(rs.getString(1));
				role.setRole_name(rs.getString(2));
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
}
