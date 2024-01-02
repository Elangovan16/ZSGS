package com.elangovan16.rolehierarchy.viewmodel;

import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.AddRoleView;

public class AddRoleViewModel {
	private AddRoleView addRoleView;

	public AddRoleViewModel(AddRoleView addRoleView) {
		this.addRoleView = addRoleView;
	}

	public void addSubRole(String subRole, String reportingManager) {
		
		RoleHierarchyRepository.getInstance().addSubRole(subRole, reportingManager);
	}

}
