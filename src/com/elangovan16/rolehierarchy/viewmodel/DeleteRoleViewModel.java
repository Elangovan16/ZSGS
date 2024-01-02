package com.elangovan16.rolehierarchy.viewmodel;

import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.DeleteRoleView;

public class DeleteRoleViewModel {
	private DeleteRoleView deleteRoleView;

	public DeleteRoleViewModel(DeleteRoleView deleteRoleView) {
		this.deleteRoleView = deleteRoleView;
	}

	public void deleteRole(String role, String transferred) {
		RoleHierarchyRepository.getInstance().deleteRole(role, transferred);
	}

}
