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
		jobRoleMap.put("jobRoleID", "jobRoleID1");
		jobRoleMap.put("property.futureDemand", "futureDemand1");
		jobRoleMap.put("property.bandId", "band1");
		jobRoleMap.put("$123", "band1");
		jobRoleMap.put("property.historyDemand", "historyDemand1");
		jobRoleMap.put("property.overallFit", "overallFit1");
		jobRoleMap.put("skills.skillName", "skills1.title1");
		jobRoleMap.put("skills.skillDescription", "skills1.description1");
		jobRoleMap.put("skills.skillType", "skills1.skillType1");
		jobRoleMap.put("jobRoleDescription", "jobRoleDescription1");
		jobRoleMap.put("responsibilities", "responsibilities1");
	}
	

}
