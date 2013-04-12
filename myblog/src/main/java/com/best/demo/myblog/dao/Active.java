package com.best.demo.myblog.dao;

import java.util.Date;

public class Active {

	private long id;
	private long uid;
	private String description;
	private Date createDate;
	
	public Active(){
		this(0, null, null);
	}
	
	public Active(long uid, String description, Date createDate) {
		super();
		this.uid = uid;
		this.description = description;
		this.createDate = createDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
