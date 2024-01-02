package com.elangovan16.rolehierarchy.viewmodel;

import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.DisplayRoleView;

public class DisplayRoleViewModel {
	private DisplayRoleView displayRoleView;

	public DisplayRoleViewModel(DisplayRoleView displayRoleView) {
		this.displayRoleView = displayRoleView;
	}

	public List<Role> getDisplayRoleViewModel() {
		return RoleHierarchyRepository.getInstance().getRoles();
	}

}
