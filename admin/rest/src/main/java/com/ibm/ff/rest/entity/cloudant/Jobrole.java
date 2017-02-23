package com.ibm.ff.rest.entity.cloudant;

public class Jobrole {
	public Audit audit;
	public String jobRoleID;
	public String jobRoleName;

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public String getJobRoleName() {
		return jobRoleName;
	}

	public void setJobRoleName(String jobRoleName) {
		this.jobRoleName = jobRoleName;
	}

	public String getJobRoleID() {
		return jobRoleID;
	}

	public void setJobRoleID(String jobRoleID) {
		this.jobRoleID = jobRoleID;
	}
	
	
}
