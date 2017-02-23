package com.ibm.ff.rest.entity.cloudant;

import java.util.Date;

public class Audit {
	public String revisionId;
	public String revisionTimeStamp;
	public String getRevisionId() {
		return revisionId;
	}
	public void setRevisionId(String revisionId) {
		this.revisionId = revisionId;
	}
	public String getRevisionTimeStamp() {
		return revisionTimeStamp;
	}
	public void setRevisionTimeStamp(String revisionTimeStamp) {
		this.revisionTimeStamp = revisionTimeStamp;
	}
	
}
