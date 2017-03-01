package com.ibm.ff.rest.entity.cloudant;

import java.util.List;

public class Jobrole {
	public Audit audit;
	public String jobRoleID;
	public String jobRoleName;
	public List<Skill> skills;
	public String jobRoleDescription;
	public List<String> responsibilities;
	public Property property;
	public Meta meta;
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	public String getJobRoleID() {
		return jobRoleID;
	}
	public void setJobRoleID(String jobRoleID) {
		this.jobRoleID = jobRoleID;
	}
	public String getJobRoleName() {
		return jobRoleName;
	}
	public void setJobRoleName(String jobRoleName) {
		this.jobRoleName = jobRoleName;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String getJobRoleDescription() {
		return jobRoleDescription;
	}
	public void setJobRoleDescription(String jobRoleDescription) {
		this.jobRoleDescription = jobRoleDescription;
	}
	public List<String> getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	
}
