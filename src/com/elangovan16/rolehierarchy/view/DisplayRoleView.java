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

		List<String> roles = displayRoleViewModel.getDisplayRoleViewModel();
		for (String r : roles) {
			System.out.print(r + " ,");
		}
		System.out.println();
	}
}
