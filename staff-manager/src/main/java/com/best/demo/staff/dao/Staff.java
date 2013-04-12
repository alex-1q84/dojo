package com.best.demo.staff.dao;

import java.util.Date;

/**
 * @author <a href="mailto:hailxl@gmail.com">wuch</a>
 *
 */
public class Staff {
	private long id;
	private long deptId;
	private long stationId;
	private String code;
	private String name;
	private String phone;
	private String password;
	private String address;
	private int opType;
	private boolean privBarcode;
	private Date createDate;
	private Date updateDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public long getStationId() {
		return stationId;
	}
	public void setStationId(long stationId) {
		this.stationId = stationId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOpType() {
		return opType;
	}
	public void setOpType(int opType) {
		this.opType = opType;
	}
	public boolean isPrivBarcode() {
		return privBarcode;
	}
	public void setPrivBarcode(boolean privateBarcode) {
		this.privBarcode = privateBarcode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
