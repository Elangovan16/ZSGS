package com.elangovan16.rolehierarchy.view;

import java.util.List;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.viewmodel.DisplayRoleViewModel;

public class DisplayRoleView {
	private DisplayRoleViewModel displayRoleViewModel;

	public DisplayRoleView() {
		displayRoleViewModel = new DisplayRoleViewModel(this);
	}

	public void displayRoles() {
		List<Role> roles = displayRoleViewModel.getDisplayRoleViewModel();
		for (Role r : roles) {
			System.out.println(r.getRole_name());
			System.out.println(r.getRole_id());
			System.out.println(r.getParent_id());
			System.out.println();
		}
	}
}
