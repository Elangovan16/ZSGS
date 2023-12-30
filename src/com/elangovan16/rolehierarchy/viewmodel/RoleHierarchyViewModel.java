package com.elangovan16.rolehierarchy.viewmodel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.elangovan16.rolehierarchy.repository.RoleHierarchyRepository;
import com.elangovan16.rolehierarchy.util.Get;
import com.elangovan16.rolehierarchy.view.RoleHierarchyView;

public class RoleHierarchyViewModel {
	private RoleHierarchyView roleHierarchyView;

	public RoleHierarchyViewModel(RoleHierarchyView roleHierarchyView) {
		this.roleHierarchyView = roleHierarchyView;
	}

	public void initiateJSONObject() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = RoleHierarchyRepository.getInstance().getJsonRetreiver();
		String path = "src/com/elangovan16/rolehierarchy/repository/Data.json";
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(path));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RoleHierarchyRepository.getInstance().setJsonRetreiver(jsonObject);
		System.out.println(jsonObject);
	}

	public void writeFile(JSONObject mainObj) {
		try {
			String path = Get.getPath();
			FileWriter fw = new FileWriter(path);
			fw.write(mainObj.toJSONString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRootRole(String role) {
		JSONObject addRoot = new JSONObject();
		JSONArray roleDetail = new JSONArray();
		addRoot.put("name", null);
		addRoot.put("repoting manager", null);
		roleDetail.add(addRoot);
		JSONObject mainObj = RoleHierarchyRepository.getInstance().getJsonRetreiver();
		mainObj.put(role, roleDetail);
		writeFile(mainObj);
	}

	public void addSubRole(String subRole, String reportingManager) {
		JSONObject addRoot = new JSONObject();
		JSONArray roleDetail = new JSONArray();
		addRoot.put("name", null);
		addRoot.put("repoting manager", reportingManager);
		roleDetail.add(addRoot);
		JSONObject mainObj = RoleHierarchyRepository.getInstance().getJsonRetreiver();
		mainObj.put(subRole, roleDetail);
		writeFile(mainObj);
	}

	public void displayRole() {
		JSONObject mainObj = RoleHierarchyRepository.getInstance().getJsonRetreiver();
		Map map = new HashMap<>();
	}
}
