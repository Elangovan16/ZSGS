package com.elangovan16.rolehierarchy.view;

import java.util.Scanner;

import com.elangovan16.rolehierarchy.viewmodel.AddRoleViewModel;

public class AddRoleView {
	private AddRoleViewModel addRoleViewModel;
	Scanner sc = new Scanner(System.in);

	public AddRoleView() {
		addRoleViewModel = new AddRoleViewModel(this);
	}

	public void addSubRole() {
		System.out.print("Enter Sub-Role Name : ");
		String subRole = sc.nextLine();
		System.out.print("Enter reporting to role name : ");
		String reportingManager = sc.nextLine();
		addRoleViewModel.addSubRole(subRole, reportingManager);
	}

}
