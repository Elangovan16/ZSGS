package com.elangovan16.rolehierarchy.viewmodel;

import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.DisplayUsersView;

public class DisplayUsersViewModel {
	private DisplayUsersView displayUsersView;

	public DisplayUsersViewModel(DisplayUsersView displayUsersView) {
		this.displayUsersView = displayUsersView;
	}

	public List<Role> getUsers() {
		return RoleHierarchyRepository.getInstance().getUsers();
	}

}
