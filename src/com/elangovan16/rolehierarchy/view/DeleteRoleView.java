package com.elangovan16.rolehierarchy.view;

import java.util.Scanner;

import com.elangovan16.rolehierarchy.viewmodel.DeleteRoleViewModel;

public class DeleteRoleView {
	Scanner sc = new Scanner(System.in);
	private DeleteRoleViewModel deleteRoleViewModel;

	public DeleteRoleView() {
		deleteRoleViewModel = new DeleteRoleViewModel(this);
	}

	public void deleteRole() {
		System.out.print("Enter the role to be deleted : ");
		String role = sc.nextLine();
		System.out.print("Enter the role to be transferred : ");
		String transferred = sc.nextLine();
		deleteRoleViewModel.deleteRole(role, transferred);
	}

}
