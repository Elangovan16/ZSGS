package com.elangovan16.rolehierarchy.viewmodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.elangovan16.rolehierarchy.dto.Role;
import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.view.DisplayRoleView;

public class DisplayRoleViewModel {
	private DisplayRoleView displayRoleView;

	public DisplayRoleViewModel(DisplayRoleView displayRoleView) {
		this.displayRoleView = displayRoleView;
	}

	public List<String> getDisplayRoleViewModel() {
		String rootRole = RoleHierarchyRepository.getInstance().getRootRole();
		List<String> rolesName = new ArrayList<>();
		Queue<String> BFS = new LinkedList<>();
		BFS.add(rootRole);

		while (!BFS.isEmpty()) {
			String cur = BFS.poll();
			int id = RoleHierarchyRepository.getInstance().getId(cur);
			rolesName.add(cur);

			List<Role> role = RoleHierarchyRepository.getInstance().getRolesFromId(id);
			for (Role r : role) {
				BFS.add(r.getRole_name());
			}
		}
		return rolesName;
	}

}
