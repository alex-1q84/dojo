package com.best.demo.staff.dao;

/**
 * 员工统计结果
 * 
 * @author <a href="mailto:hailxl@gmail.com">wuch</a>
 */
public class StaffStatistic {
	private long stationId;
	private long deptId;
	private int count;

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return String.format("%d_%d_%d", this.stationId, this.deptId, this.count);
	}
}
