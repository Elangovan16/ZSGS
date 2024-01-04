package com.elangovan16.rolehierarchy.view;

import java.util.Scanner;

import com.elangovan16.rolehierarchy.viewmodel.AddUserViewModel;

public class AddUserView {
	private AddUserViewModel addUserViewModel;
	Scanner sc = new Scanner(System.in);

	public AddUserView() {
		addUserViewModel = new AddUserViewModel(this);
	}

	public void addUser() {
		System.out.print("Enter User Name : ");
		String user = sc.nextLine();
		System.out.print("Enter Role : ");
		String role = sc.nextLine();
		addUserViewModel.addUser(user,role);
	}

}
