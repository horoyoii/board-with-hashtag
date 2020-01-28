package com.horoyoii.mvcexam.model;

public class Tag {
	int tid;
	String name;
	
	public Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
