package com.elangovan16.rolehierarchy.view;

import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.viewmodel.DisplayUsersViewModel;

public class DisplayUsersView {
	private DisplayUsersViewModel displayUsersViewModel;

	public DisplayUsersView() {
		displayUsersViewModel = new DisplayUsersViewModel(this);
	}

	public void addUser() {

	}

	public void displayUsers() {
		List<Role> roles = displayUsersViewModel.getUsers();
		for (Role r : roles) {
			System.out.println(r.getRole_name() + " - " + r.getUser_name());
		}
	}
}
