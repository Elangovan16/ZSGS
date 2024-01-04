package com.elangovan16.rolehierarchy.view;

import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.viewmodel.SubUsersViewModel;

public class SubUsersView {
	private SubUsersViewModel subUsersViewModel;

	public SubUsersView() {
		subUsersViewModel = new SubUsersViewModel(this);
	}

	public void displaySubUsers() {
		List<List<Role>> subUsers = subUsersViewModel.getSubUsers();
	}
}
