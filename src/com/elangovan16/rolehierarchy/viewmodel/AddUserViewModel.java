package com.elangovan16.rolehierarchy.viewmodel;

import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.AddUserView;

public class AddUserViewModel {
	private AddUserView addUserView;

	public AddUserViewModel(AddUserView addUserView) {
		this.addUserView = addUserView;
	}

	public void addUser(String user, String role) {
		RoleHierarchyRepository.getInstance().addUser(user, role);
	}

}
