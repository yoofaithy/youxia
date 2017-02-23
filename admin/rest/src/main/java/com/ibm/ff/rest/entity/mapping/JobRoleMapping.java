package com.ibm.ff.rest.entity.mapping;

import java.util.*;

public class JobRoleMapping {
	
	private HashMap<String,String> jobRoleMap = new HashMap<String,String>();

	public HashMap<String, String> getJobRoleMap() {
		return jobRoleMap;
	}

	public void setJobRoleMap(HashMap<String, String> jobRoleMap) {
		this.jobRoleMap = jobRoleMap;
	}

	public JobRoleMapping() {		
		// TODO Auto-generated constructor stub
		jobRoleMap.put("jobRoleID1", "jobRoleID");
		jobRoleMap.put("jobRoleName1", "jobRoleName");
		jobRoleMap.put("revisionId1", "audit.revisionId");
		jobRoleMap.put("revisionTimeStamp1", "audit.revisionTimeStamp");
	}
	

}
