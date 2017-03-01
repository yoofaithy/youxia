package com.ibm.ff.rest.entity.response;

import java.util.Date;
import java.util.List;


public class Jobrole {
	public String jobRoleID1;
	public int futureDemand1;
	public String band1;
	public int historyDemand1;
	public int overallFit1;
	public List<Skill> skills1;
	public String jobRoleDescription1;
	public List<String> responsibilities1;
	
	public List<String> getResponsibilities1() {
		return responsibilities1;
	}
	public void setResponsibilities1(List<String> responsibilities1) {
		this.responsibilities1 = responsibilities1;
	}
	public String getJobRoleID1() {
		return jobRoleID1;
	}
	public void setJobRoleID1(String jobRoleID1) {
		this.jobRoleID1 = jobRoleID1;
	}
	public String getBand1() {
		return band1;
	}
	public void setBand1(String band1) {
		this.band1 = band1;
	}
	public int getFutureDemand1() {
		return futureDemand1;
	}
	public void setFutureDemand1(int futureDemand1) {
		this.futureDemand1 = futureDemand1;
	}
	public int getHistoryDemand1() {
		return historyDemand1;
	}
	public void setHistoryDemand1(int historyDemand1) {
		this.historyDemand1 = historyDemand1;
	}
	public int getOverallFit1() {
		return overallFit1;
	}
	public void setOverallFit1(int overallFit1) {
		this.overallFit1 = overallFit1;
	}
	public List<Skill> getSkills1() {
		return skills1;
	}
	public void setSkills1(List<Skill> skills1) {
		this.skills1 = skills1;
	}
	public String getJobRoleDescription1() {
		return jobRoleDescription1;
	}
	public void setJobRoleDescription1(String jobRoleDescription1) {
		this.jobRoleDescription1 = jobRoleDescription1;
	}
	
	
	
}
