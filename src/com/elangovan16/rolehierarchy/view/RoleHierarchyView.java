package com.elangovan16.rolehierarchy.view;

import java.io.File;
import java.util.Scanner;

import com.elangovan16.rolehierarchy.util.Get;
import com.elangovan16.rolehierarchy.viewmodel.RoleHierarchyViewModel;

public class RoleHierarchyView {
	private RoleHierarchyViewModel roleHierarchyViewModel;

	public RoleHierarchyView() {
		roleHierarchyViewModel = new RoleHierarchyViewModel(this);
	}

	public void start() {
		boolean flag = true;
		File file = new File("src/com/elangovan16/rolehierarchy/repository/Data.json");
		roleHierarchyViewModel.initiateJSONObject();
		Scanner sc = new Scanner(System.in);
		do {
			if (file.length() > 3) {
				info();
				byte choice = Get.getByte();
				switch (choice) {
				case 0 -> {
					flag = false;
				}
				case 1 -> {
					System.out.print("Enter Sub-Role Name : ");
					String subRole = sc.nextLine();
					System.out.print("Enter reporting to role name : ");
					String reportingManager = sc.nextLine();
					roleHierarchyViewModel.addSubRole(subRole, reportingManager);
				}
				case 2 -> {
					roleHierarchyViewModel.displayRole();
				}
				default -> {
					System.out.println("Invalid ...");
				}
				}
			} else {
				System.out.print("Enter Root Role Name : ");
				String role = sc.nextLine();
				roleHierarchyViewModel.addRootRole(role);
			}
		} while (flag);
		System.out.println("Closeing....");
		sc.close();
	}

	public void info() {
		System.out.println("+----------------------------------+");
		System.out.println("|     OPERATIONS                   |");
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Add SubRole                   |");
		System.out.println("| 2. Display Role                  |");
		System.out.println("| 3. Delete Role                   |");
		System.out.println("| 4. Add User                      |");
		System.out.println("| 5. Display Role                  |");
		System.out.println("| 6. Display User and Sub-User     |");
		System.out.println("| 7. Delete User                   |");
		System.out.println("| 8. Number of users from top      |");
		System.out.println("| 9. Height of role hierarchy      |");
		System.out.println("|10. Common boss of users          |");
		System.out.println("| 0. Exit...                       |");
		System.out.println("+----------------------------------+");
		System.out.print("--> Operation to be performed : ");

	}
}
