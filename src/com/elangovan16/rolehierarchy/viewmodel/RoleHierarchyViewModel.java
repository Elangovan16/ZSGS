package com.elangovan16.rolehierarchy.viewmodel;

import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.RoleHierarchyView;

public class RoleHierarchyViewModel {
	private RoleHierarchyView roleHierarchyView;

	public RoleHierarchyViewModel(RoleHierarchyView roleHierarchyView) {
		this.roleHierarchyView = roleHierarchyView;
	}

	public int getRoleCount() {
		return RoleHierarchyRepository.getInstance().getRoleCount();
	}

	public void addRootRole(String role) {
		RoleHierarchyRepository.getInstance().addRootRole(role);
	}
}
