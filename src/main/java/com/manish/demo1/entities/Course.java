package com.manish.demo1.entities;

public class Course {

	private String documentId;
	private String name;
	private String desc;

	@Override
	public String toString() {
		return "Course [documentId=" + documentId + ", name=" + name + ", desc=" + desc + "]";
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String documentId, String name, String desc) {
		super();
		this.documentId = documentId;
		this.name = name;
		this.desc = desc;
	}

	
}
