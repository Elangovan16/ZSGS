package com.elangovan16.rolehierarchy.repository;

import org.json.simple.JSONObject;

public class RoleHierarchyRepository {
	private static RoleHierarchyRepository repository;
	private JSONObject jsonRetreiver;

	private RoleHierarchyRepository() {

	}

	public JSONObject getJsonRetreiver() {
		return jsonRetreiver;
	}

	public void setJsonRetreiver(JSONObject jsonRetreiver) {
		this.jsonRetreiver = jsonRetreiver;
	}

	public static RoleHierarchyRepository getInstance() {
		if (repository == null) {
			repository = new RoleHierarchyRepository();
		}
		return repository;
	}
}
