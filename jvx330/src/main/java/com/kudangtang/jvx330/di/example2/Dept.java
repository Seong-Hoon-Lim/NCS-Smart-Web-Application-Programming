package com.kudangtang.jvx330.di.example2;

public class Dept {
	private String deptName;
	private String deptAddr;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddr() {
		return deptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	@Override
	public String toString() {
		return "[deptName=" + deptName + ", deptAddr=" + deptAddr + "]";
	}
	
	
	
}
